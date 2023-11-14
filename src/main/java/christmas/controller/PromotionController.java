package christmas.controller;

import christmas.domain.PromotionModel;
import christmas.domain.calculator.Calculator;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class PromotionController {

    Validator validator = new Validator();

    private PromotionModel model;
    private InputView inputView;
    private OutputView outputView;

    public PromotionController(PromotionModel model, InputView inputView, OutputView outputView) {
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runPlanner() {
        runReadDate();
        runReadOrder();
        runOutputView();
    }

    private void runReadDate() {
        boolean isValid = false;

        while (!isValid) {
            try {
                model.setDate(inputView.readDate());
                isValid = validator.isValidDate(model.getDate());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void runReadOrder() {
        boolean isValid = false;

        while (!isValid) {
            try {
                model.setOrder(inputView.readOrder());
                isValid = validator.isValidOrder(model.getOrder());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void runOutputView() {
        Calculator calculator = new Calculator();
        Integer addedPrice = calculator.calculateAddedPrice(model.getOrder());
        Integer benefit = calculator.calculateBenefit(model.getDate(), addedPrice, model.getOrder());
        Map<String, Integer> appliedEvents = calculator.calculateAppliedEvents(model.getDate(), addedPrice, model.getOrder());

        outputView.printAll(model.getDate(), model.getOrder(), addedPrice, appliedEvents, benefit);
    }
}

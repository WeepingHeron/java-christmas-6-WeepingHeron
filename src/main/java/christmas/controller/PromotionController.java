package christmas.controller;

import christmas.domain.PromotionModel;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {

    private final PromotionModel model;
    private final InputView inputView;
    private final OutputView outputView;

    Validator validator = new Validator();

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
        outputView.printAll(
                model.getDate(),
                model.getOrder(),
                model.takeAddedPrice(),
                model.takeAppliedEvents(),
                model.takeBenefit()
        );
    }
}

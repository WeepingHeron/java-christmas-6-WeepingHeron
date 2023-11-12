package christmas.controller;

import christmas.domain.PromotionModel;
import christmas.domain.events.Applier;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {

    private PromotionModel model;
    private InputView inputView;
    private OutputView outputView;
    private Applier applier;
    private Validator validator;

    public PromotionController(PromotionModel model, InputView inputView, OutputView outputView, Applier applier, Validator validator) {
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
        this.applier = applier;
        this.validator = validator;
    }

    public void updateView() {
        runReadDate();
        runReadOrder();
        model.setAddedPrice(model.getOrder());
        if (model.getAddedPrice() >= 10000) {
            applier.applyDiscounts(model, model.getDate(), model.getAddedPrice(), model.getOrder());
            applier.applyEvents(model, model.getDate(), model.getAddedPrice(), model.getOrder());
        }
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
        outputView.printDate(model.getDate());
        outputView.printMenu(model.getOrder());
        outputView.printAddedPrice(model.getAddedPrice());
        outputView.printGift(model.getAppliedEvents());
        outputView.printAppliedEvents(model.getAppliedEvents());
        outputView.printDiscountedAmount(model.getDiscountedAmount());
        outputView.printFinalPrice(model.getAddedPrice(), model.getDiscountedAmount());
        outputView.printBadge(model.getDiscountedAmount());
    }
}

package christmas.controller;

import christmas.domain.PromotionModel;
import christmas.domain.events.Applier;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {

    private PromotionModel model;
    private InputView inputView;
    private OutputView outputView;
    private Applier applier;

    public PromotionController(PromotionModel model, InputView inputView, OutputView outputView, Applier applier) {
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
        this.applier = applier;
    }

    public void updateView() {
        runInputView();
        model.setAddedPrice(model.getOrder());
        applier.applyDiscounts(model.getAddedPrice(), model.getDate(), model.getOrder());
        applier.applyEvents(model.getAddedPrice(), model.getDate(), model.getOrder());
        System.out.println(model.getAddedPrice());
        System.out.println(model.getAppliedEvents());
        System.out.println(model.getDiscountedAmount());
        System.out.println(model.getOrder());
        System.out.println(model.getDate());
        runOutputView();
    }

    private void runInputView() {
        model.setDate(inputView.readDate());
        model.setOrder(inputView.readOrder());
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

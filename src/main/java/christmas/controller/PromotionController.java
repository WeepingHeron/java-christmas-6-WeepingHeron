package christmas.controller;

import christmas.domain.PromotionModel;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {
    private PromotionModel model;
    private InputView inputView;
    private OutputView outputView;

    public PromotionController(PromotionModel model, InputView inputView, OutputView outputView) {
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void updateView() {
        readDateAndOrder();
        model.setAddedPrice(model.getOrder());
        printData();
    }

    private void readDateAndOrder() {
        model.setDate(inputView.readDate());
        model.setOrder(inputView.readOrder());
    }

    private void printData() {
        outputView.printDate(model.getDate());
        outputView.printMenu(model.getOrder());
        outputView.printAddedPrice(model.getAddedPrice());
    }
}

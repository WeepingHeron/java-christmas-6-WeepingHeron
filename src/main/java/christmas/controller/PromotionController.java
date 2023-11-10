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
        runInputView();
        model.setAddedPrice(model.getOrder());
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
    }
}

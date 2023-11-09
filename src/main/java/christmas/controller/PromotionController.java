package christmas.controller;

import christmas.domain.PromotionModel;
import christmas.domain.calculate.Calculator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {
    private PromotionModel model;
    private InputView inputView;
    private OutputView outputView;
    private Calculator calculator;

    public PromotionController(PromotionModel model, InputView inputView, OutputView outputView, Calculator calculator) {
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    public void updateView() {
        model.setDate(inputView.readDate());
        model.setOrder(inputView.readOrder());

        Integer addedPrice = calculator.addPrice(model.getOrder());
        model.setAddedPrice(addedPrice);

        outputView.printDate(model.getDate());
        outputView.printMenu(model.getOrder());
        outputView.printListPrice(model.getAddedPrice());
    }
}

package christmas;

import christmas.controller.PromotionController;
import christmas.domain.PromotionModel;
import christmas.domain.calculate.Calculator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        PromotionModel model = new PromotionModel();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Calculator calculator = new Calculator();

        PromotionController promotionController = new PromotionController(model, inputView, outputView, calculator);

        promotionController.updateView();
    }
}

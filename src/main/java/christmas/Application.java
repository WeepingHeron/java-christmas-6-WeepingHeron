package christmas;

import christmas.controller.PromotionController;
import christmas.domain.PromotionModel;
import christmas.domain.events.Applier;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        PromotionModel model = new PromotionModel();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Applier applier = new Applier();
        Validator validator = new Validator();

        PromotionController promotionController = new PromotionController(model, inputView, outputView, applier, validator);

        promotionController.runPlanner();
    }
}

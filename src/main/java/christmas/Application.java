package christmas;

import christmas.controller.PromotionController;
import christmas.domain.PromotionModel;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        PromotionModel model = new PromotionModel();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        PromotionController promotionController = new PromotionController(model, inputView, outputView);

        promotionController.runPlanner();
    }
}

package christmas.domain.events;

import christmas.controller.PromotionController;
import christmas.domain.PromotionModel;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApplierTest {

    private PromotionModel model;
    private Applier applier;

//    @BeforeEach
//    void setUp() {
//        model = new PromotionModel();
//        applier = new Applier();
//    }
//
//    @Test
//    void applyDiscountsAndEvents() {
//        // 모의 입력 데이터 설정
//        String input = "3\n티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        // 입력뷰, 출력뷰 생성
//        InputView inputView = new InputView();
//        OutputView outputView = new OutputView();
//
//        // 컨트롤러 생성
//        PromotionController controller = new PromotionController(model, inputView, outputView, applier);
//
//        // 뷰 업데이트
//        controller.updateView();
//
//        // 예상 결과값
//        Map<String, Integer> expectedOrder = new HashMap<>();
//        expectedOrder.put("티본스테이크", 1);
//        expectedOrder.put("바비큐립", 1);
//        expectedOrder.put("초코케이크", 2);
//        expectedOrder.put("제로콜라", 1);
//
//        Integer expectedDate = 3;
//
//        // 결과값 검증
//        assertEquals(expectedOrder, model.getOrder());
//        assertEquals(expectedDate, model.getDate());
//    }
}
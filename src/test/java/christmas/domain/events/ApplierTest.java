package christmas.domain.events;

import christmas.domain.PromotionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ApplierTest {

    Applier applier = new Applier();

    private Integer date;
    private Integer addedPrice;
    private Map<String, Integer> order;
    private PromotionModel model;

    @BeforeEach
    void setUp() {
        model = new PromotionModel();
        date = 3;
        order = new HashMap<>();
        order.put("티본스테이크",1);
        order.put("바비큐립",1);
        order.put("초코케이크",2);
        order.put("제로콜라",1);
        model.setAddedPrice(order);
        addedPrice = model.getAddedPrice();
    }

    @DisplayName("총주문 금액, 날짜, 주문을 통해 model에 총할인 금액을 설정한다.")
    @Test
    void applyDiscountsTest() {
        applier.applyDiscounts(model, date, addedPrice, order);

        Assertions.assertEquals(31246, model.getDiscountedAmount());
    }

    @DisplayName("총주문 금액, 날짜, 주문을 통해 model에 적용된 혜택을 설정한다.")
    @Test
    void applyEventsTest() {
        // Given
        Map<String, Integer> expectedEvents = new HashMap<>();
        expectedEvents.put("크리스마스 디데이 할인", 1200);
        expectedEvents.put("증정 이벤트", 25000);
        expectedEvents.put("평일 할인", 4046);
        expectedEvents.put("특별 할인", 1000);

        // When
        applier.applyEvents(model, date, addedPrice, order);

        // Then
        Assertions.assertEquals(expectedEvents, model.getAppliedEvents());
    }
}
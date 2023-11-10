package christmas.domain;

import christmas.domain.calculate.Calculator;

import java.util.HashMap;
import java.util.Map;

public class PromotionModel {
    Calculator calculator = new Calculator();

    private Integer date;
    private Map<String, Integer> order;
    private Integer addedPrice;
    private Map<String, Integer> appliedEvents = new HashMap<>();
    private Integer discountedAmount = 0;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getAddedPrice() {
        return addedPrice;
    }

    public void setAddedPrice(Map<String, Integer> order) {
        addedPrice = calculator.addPrice(order);
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<String, Integer> order) {
        this.order = order;
    }

    public Map<String, Integer> getAppliedEvents() {
        return appliedEvents;
    }

    public void setAppliedEvents(String key, Integer value) {
        appliedEvents.put(key, value);
    }

    public Integer getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(Integer discountedAmount) {
        this.discountedAmount = discountedAmount;
    }
}

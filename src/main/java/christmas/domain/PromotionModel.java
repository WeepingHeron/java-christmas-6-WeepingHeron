package christmas.domain;

import christmas.domain.calculator.Calculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PromotionModel {

    private Integer date;
    private Map<String, Integer> order = new HashMap<>();

    Calculator calculator = new Calculator();

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Map<String, Integer> getOrder() {
        return Collections.unmodifiableMap(order);
    }

    public void setOrder(Map<String, Integer> order) {
        this.order = order;
    }

    public Integer takeAddedPrice() {
        return calculator.calculateAddedPrice(order);
    }

    public Integer takeBenefit() {
        return calculator.calculateBenefit(date, takeAddedPrice(), order);
    }

    public Map<String, Integer> takeAppliedEvents() {
        return calculator.calculateAppliedEvents(date, takeAddedPrice(), order);
    }
}

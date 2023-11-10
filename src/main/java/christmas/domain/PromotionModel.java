package christmas.domain;

import christmas.domain.calculate.Calculator;

import java.util.Map;

public class PromotionModel {
    Calculator calculator = new Calculator();

    private Integer date;
    private Map<String, Integer> order;
    private Integer addedPrice;

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
}

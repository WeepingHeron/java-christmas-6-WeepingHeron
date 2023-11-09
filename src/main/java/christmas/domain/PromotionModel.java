package christmas.domain;

import java.util.Map;

public class PromotionModel {
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

    public void setAddedPrice(Integer addedPrice) {
        this.addedPrice = addedPrice;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<String, Integer> order) {
        this.order = order;
    }
}

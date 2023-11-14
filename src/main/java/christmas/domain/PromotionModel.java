package christmas.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PromotionModel {

    private Integer date;
    private Map<String, Integer> order = new HashMap<>();

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
}

package christmas.util;

import java.text.DecimalFormat;

public class PriceFormatterUtil {

    public String getFormattedPrice(Integer price) {
        DecimalFormat formatter = new DecimalFormat("###,###원");

        return formatter.format(price);
    }
}

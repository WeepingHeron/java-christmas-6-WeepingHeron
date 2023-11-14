package christmas.view.tools;

import java.text.DecimalFormat;

public class OutputTool {

    public String formatPrice(Integer price) {
        DecimalFormat formatter = new DecimalFormat("###,###원");

        return formatter.format(price);
    }
}

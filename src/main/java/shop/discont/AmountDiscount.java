package shop.discont;

import java.math.BigDecimal;

public class AmountDiscount implements Discount {


    public BigDecimal applyDiscount(BigDecimal total) {
        if (total.intValue() > 1000) {
            return total.multiply(new BigDecimal(0.99));
        } else return total;
    }
}

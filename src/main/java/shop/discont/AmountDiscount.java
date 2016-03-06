package shop.discont;

import java.math.BigDecimal;

public class AmountDiscount implements Discount {

    public BigDecimal applyDiscount(BigDecimal total) {
        if (total.intValue() > 1000) {
            return total.multiply(new BigDecimal(0.99)).setScale(2, BigDecimal.ROUND_FLOOR);
        } else
            return total.setScale(2, BigDecimal.ROUND_FLOOR);
    }
}

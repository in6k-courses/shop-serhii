package shop.discont;

import java.math.BigDecimal;

//TODO add constructor with amount and discount
public class AmountDiscount implements Discount {

    private final int AMOUNT = 1000;

    public BigDecimal applyDiscount(BigDecimal price) {
        if (price.doubleValue() > AMOUNT) {
            return price.multiply(new BigDecimal(0.99)).setScale(2, BigDecimal.ROUND_FLOOR);
        } else
            return price.setScale(2, BigDecimal.ROUND_FLOOR);
    }
}

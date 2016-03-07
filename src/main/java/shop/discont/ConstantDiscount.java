package shop.discont;


import java.math.BigDecimal;

public class ConstantDiscount implements Discount {
    BigDecimal CONSTANT_DISCOUNT = new BigDecimal(10);

    public BigDecimal applyDiscount(BigDecimal price) {
        return price.subtract(CONSTANT_DISCOUNT).setScale(2, BigDecimal.ROUND_FLOOR);
    }

}

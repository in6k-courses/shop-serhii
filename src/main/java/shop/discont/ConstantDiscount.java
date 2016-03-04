package shop.discont;


import java.math.BigDecimal;

public class ConstantDiscount implements Discount {
    BigDecimal CONSTANT_DISCOUNT = new BigDecimal(10);

    public BigDecimal applyDiscount(BigDecimal total) {
        return total.subtract(CONSTANT_DISCOUNT);
    }

}

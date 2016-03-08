package shop.discont;

import java.math.BigDecimal;

//TODO change class to купон
public class CouponDiscount implements Discount {
    private BigDecimal couponSize;

    public CouponDiscount(BigDecimal couponSize) {
        this.couponSize = couponSize;
    }

    public BigDecimal applyDiscount(BigDecimal price) {
        return couponSize ;
    }

}

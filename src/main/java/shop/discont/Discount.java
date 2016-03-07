package shop.discont;

import java.math.BigDecimal;

//TODO make change return
public interface Discount {

      BigDecimal applyDiscount(BigDecimal price);
}

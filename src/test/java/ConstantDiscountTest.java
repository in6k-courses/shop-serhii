import shop.discont.ConstantDiscount;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConstantDiscountTest {

    @org.junit.Test
    public void test() {
        ConstantDiscount constantDiscount = new ConstantDiscount();
        assertThat(constantDiscount.applyDiscount(new BigDecimal(550)), is(new BigDecimal(540)));
    }

}

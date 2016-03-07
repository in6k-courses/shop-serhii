import shop.discont.ConstantDiscount;
import shop.discont.Discount;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConstantDiscountTest {

    @org.junit.Test
    public void testConstantDiscount() {
        Discount constantDiscount = new ConstantDiscount();
        BigDecimal actual = constantDiscount.applyDiscount(new BigDecimal(550));
        BigDecimal expect = new BigDecimal(540).setScale(2, BigDecimal.ROUND_FLOOR);
        assertThat(actual, is(expect));
    }

}

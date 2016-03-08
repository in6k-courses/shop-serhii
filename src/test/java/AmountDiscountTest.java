
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;
import shop.discont.AmountDiscount;
import shop.discont.Discount;
import java.math.BigDecimal;


public class AmountDiscountTest {

    @Test
    public void testWithValueMoreThanAmount() {
        Discount amountDiscount = new AmountDiscount(1000,new BigDecimal(0.5));
        assertThat(amountDiscount.applyDiscount(new BigDecimal(1200)), closeTo(new BigDecimal(600),new BigDecimal(0.00)));
    }
    
    @Test
    public void testWithLessAmount() {
        AmountDiscount amountDiscount = new AmountDiscount(1000, new BigDecimal(0.5));
        assertThat(amountDiscount.applyDiscount(new BigDecimal(500)), is(new BigDecimal(500)));
    }

}

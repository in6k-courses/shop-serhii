
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import shop.discont.AmountDiscount;
import java.math.BigDecimal;

public class AmountDiscountTest {

    @org.junit.Test
    public void test(){
        AmountDiscount amountDiscount = new AmountDiscount();
        BigDecimal expect = new BigDecimal(1001).multiply(new BigDecimal(0.99)).setScale(2, BigDecimal.ROUND_FLOOR);
        assertThat(amountDiscount.applyDiscount(new BigDecimal(1001)), is(expect));
    }


    @org.junit.Test
    public void testLess(){
        AmountDiscount amountDiscount = new AmountDiscount();
        assertThat(amountDiscount.applyDiscount(new BigDecimal(1000)), is(new BigDecimal(1000).setScale(2,BigDecimal.ROUND_FLOOR)));
    }

}

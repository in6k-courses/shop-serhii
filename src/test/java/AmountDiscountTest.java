
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import shop.discont.AmountDiscount;
import java.math.BigDecimal;

public class AmountDiscountTest {

    @org.junit.Test
    public void test(){
        AmountDiscount amountDiscount = new AmountDiscount();
        BigDecimal expect = new BigDecimal(1001).multiply(new BigDecimal(0.99));
        assertThat(amountDiscount.applyDiscount(new BigDecimal(1001)), is(expect));
    }

}

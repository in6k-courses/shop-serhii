import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {


        BigDecimal price = new BigDecimal(100);
        BigDecimal sale = new BigDecimal(5);
        System.out.println(price = price.multiply(sale).divide(new BigDecimal(10)));
        System.out.println(price);
       // System.out.println(100 - 100 * 0.5);
    }
}

import shop.ShoppingCard;
import shop.product.OrderItem;
import shop.product.Product;
import shop.sale.GiftSale;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class ShoppingCardTest {


    @org.junit.Test
    public void test(){
        ShoppingCard shoppingCard = new ShoppingCard();

        Product product1 = new Product("phone","cx70", new BigDecimal(55));
        OrderItem item1 = new OrderItem(product1, new BigDecimal(2));

        Product product2 = new Product("phone","cx70", new BigDecimal(55));
        OrderItem item2 = new OrderItem(product2, new BigDecimal(2));

        Product product3 = new Product("phone", "a300", new BigDecimal(100));
        OrderItem item3 = new OrderItem(product3, new BigDecimal(2));

        Product product4 = new Product("phone", "5530", new BigDecimal(100));
        OrderItem item4 = new OrderItem(product4, new BigDecimal(2));

        shoppingCard.addOrderItem(item1);
        shoppingCard.addOrderItem(item2);
        shoppingCard.addOrderItem(item3);
        shoppingCard.addOrderItem(item4);
        shoppingCard.setSaleStrategy(new GiftSale());


        String actual = shoppingCard.getCheck();
        String expected = "category\tmodel\tprice\tamount\tpriceSale \ttotal\n"
                + "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n"
                + "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n"
                + "phone\t    a300\t100.00\t2.00\t100.00\t   200.00\n"
                + "phone\t    5530\t100.00\t2.00\t100.00\t   200.00\n"
                + "cover\t    K2l5\t50.00\t1.00\t0.00\t   0.00\n"
                + "Total = 610.00";
        assertThat(actual, is(expected));

    }




}

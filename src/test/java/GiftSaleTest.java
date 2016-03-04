import org.junit.*;
import shop.product.OrderItem;
import shop.product.Product;
import shop.sale.GiftSale;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class GiftSaleTest {

    List<OrderItem> orderItems;

    @Before
    public void CreateOrderItem() {
        orderItems = new ArrayList<OrderItem>();
        Product item2 = new Product("laptop", "samsung a300", new BigDecimal(20));
        Product item1 = new Product("phones", "lenovo a300", new BigDecimal(2));
        Product item3 = new Product("phones", "samsung a300", new BigDecimal(22.1));
        //Product item4 = new Product("phones", "nokia 5530",new BigDecimal(100));
        orderItems.add(new OrderItem(item1, 1));
        orderItems.add(new OrderItem(item2, 5));
        orderItems.add(new OrderItem(item3, 1));
    }

    @org.junit.Test
    public void test() {
        GiftSale giftSale = new GiftSale();
        giftSale.applySale(orderItems);
        Product gift = new Product("phones", "samsung a300", new BigDecimal(22.1));
        OrderItem giftOrderItem = new OrderItem(gift,1);
        giftOrderItem.setOrderedPrice(new BigDecimal(0));
        assertThat(orderItems, hasItem(giftOrderItem));
    }


}

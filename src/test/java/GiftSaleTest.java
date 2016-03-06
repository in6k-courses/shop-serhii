import org.junit.Before;
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
    public void createOrderItem() {
        orderItems = new ArrayList<OrderItem>();
        Product item2 = new Product("laptop", "a300", new BigDecimal(20));
        Product item1 = new Product("phone", " x57", new BigDecimal(2));
        Product item3 = new Product("phone", "U1", new BigDecimal(22.1));
        Product item4 = new Product("phone", "5530", new BigDecimal(100));

        orderItems.add(new OrderItem(item1, new BigDecimal(1)));
        orderItems.add(new OrderItem(item2, new BigDecimal(2)));
        orderItems.add(new OrderItem(item3, new BigDecimal(10)));
        orderItems.add(new OrderItem(item4, new BigDecimal(10)));
    }

    @org.junit.Test
    public void test() {
        GiftSale giftSale = new GiftSale();
        giftSale.applySale(orderItems);

        Product gift = new Product("cover", "K2l5", new BigDecimal(50));
        OrderItem giftOrderItem = new OrderItem(gift, new BigDecimal(1));
        giftOrderItem.setOrderedPrice(new BigDecimal(0));

        assertThat(orderItems, hasItem(giftOrderItem));
    }

}

import org.junit.Before;
import shop.model.OrderItem;
import shop.model.Product;
import shop.sale.GiftSale;
import shop.sale.Sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class GiftSaleTest {

    List<OrderItem> orderItems;
    Sale giftSale;

    @Before
    public void createOrderItem() {
        orderItems = new ArrayList<>();
        Product item2 = new Product("laptop", "a300", new BigDecimal(20));
        Product item1 = new Product("phone", " x57", new BigDecimal(2));
        Product item3 = new Product("phone", "U1", new BigDecimal(22.1));
        Product item4 = new Product("phone", "5530", new BigDecimal(100));

        orderItems.add(new OrderItem(item1, new BigDecimal(1)));
        orderItems.add(new OrderItem(item2, new BigDecimal(2)));
        orderItems.add(new OrderItem(item3, new BigDecimal(10)));
        orderItems.add(new OrderItem(item4, new BigDecimal(10)));

        Map<Product,Product> giftProducts = new HashMap<>();
        Product gift = new Product("cover", "K2l5", new BigDecimal(50));
        giftProducts.put(item4, gift);

        giftSale = new GiftSale(giftProducts);
    }

    @org.junit.Test
    public void test() {
        giftSale.applySale(orderItems);

        Product gift = new Product("cover", "K2l5", new BigDecimal(50));
        OrderItem giftOrderItem = new OrderItem(gift, new BigDecimal(1));
        giftOrderItem.setPurchasePrice(new BigDecimal(0));

        assertThat(orderItems, hasItem(giftOrderItem));
    }

}

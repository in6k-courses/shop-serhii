import org.junit.Before;
import org.junit.Test;
import shop.model.OrderItem;
import shop.model.Product;
import shop.sale.GiftSale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class GiftSaleTest {
    List<OrderItem> orderItems;
    GiftSale giftSale;
    OrderItem giftOrderItem;

    @Before
    public void createOrderItemAndGiftOrderItem() {
        orderItems = new ArrayList<>();
        Product phone = new Product("phone", "U1", new BigDecimal(22.1));
        orderItems.add(new OrderItem(phone, new BigDecimal(10)));

        Product gift = new Product("cover to phone", "d4w3", new BigDecimal(50));
        giftOrderItem = new OrderItem(gift, new BigDecimal(1));
        giftOrderItem.setPurchasePrice(new BigDecimal(0));
        giftSale = new GiftSale();
        giftSale.addProductAndGift(phone, gift);
    }

    @Test
    public void testIfOrderItemsContainsGiftOrderItemAfterApplySale() {
        giftSale.applySale(orderItems);
        assertThat(orderItems, hasItem(giftOrderItem));
    }

}

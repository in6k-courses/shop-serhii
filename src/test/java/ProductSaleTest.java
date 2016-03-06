import org.junit.Before;
import shop.product.OrderItem;
import shop.product.Product;
import shop.sale.ProductSale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductSaleTest {

    List<OrderItem> orderItems;

    @Before
    public void prepareOrderItem() {
        Product item1 = new Product("phone", "o8s1", new BigDecimal(100));
        Product item2 = new Product("laptop", "ui21", new BigDecimal(100));
        Product item3 = new Product("phone", "a300", new BigDecimal(100));

        orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem(item1, new BigDecimal(1)));
        orderItems.add(new OrderItem(item2, new BigDecimal(5)));
        orderItems.add(new OrderItem(item3, new BigDecimal(3)));

    }

    @org.junit.Test
    public void testProductSale() {
        ProductSale productSale = new ProductSale();
        BigDecimal total = new BigDecimal(0);

        productSale.applySale(orderItems);

        for (OrderItem item : orderItems) {
            total = total.add(item.getPurchasePrice());
        }

        BigDecimal actual  = total.setScale(2, BigDecimal.ROUND_FLOOR);
        BigDecimal expected = new BigDecimal(250).setScale(2, BigDecimal.ROUND_FLOOR);

        assertThat(actual, is(expected));
    }

}

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
        orderItems = new ArrayList<OrderItem>();
        Product item1 = new Product("phones", "lenovo a300", new BigDecimal(2));
        Product item2 = new Product("laptop", "samsung a300", new BigDecimal(20));
        Product item3 = new Product("phones", "nokia 5530", new BigDecimal(100));
        // Product item4 = new Product("phones", "nokia 5530",new BigDecimal(100));

        orderItems.add(new OrderItem(item1, 1));
        orderItems.add(new OrderItem(item2, 5));
        orderItems.add(new OrderItem(item3, 1));

    }


    @org.junit.Test
    public void testProductSale() {
        ProductSale productSale = new ProductSale();
        productSale.applySale(orderItems);
        BigDecimal actual = new BigDecimal(0);

        for (OrderItem item : orderItems) {
            actual = actual.add(item.getOrderedPrice());
        }

        assertThat(actual.doubleValue(),is(72.00));

    }


}

import org.junit.Before;
import org.junit.Test;
import shop.ShoppingCard;
import shop.discont.AmountDiscount;
import shop.discont.ConstantDiscount;
import shop.model.OrderItem;
import shop.model.Product;
import shop.sale.GiftSale;
import shop.sale.ProductSale;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingCardTest {

    ShoppingCard shoppingCard;

    @Before
    public void initShoppingCard() {
        shoppingCard = new ShoppingCard();

        Product product1 = new Product("phone", "cx70", new BigDecimal(55));
        OrderItem item1 = new OrderItem(product1, new BigDecimal(2));

        Product product2 = new Product("phone", "cx70", new BigDecimal(55));
        OrderItem item2 = new OrderItem(product2, new BigDecimal(2));

        Product product3 = new Product("phone", "a300", new BigDecimal(100));
        OrderItem item3 = new OrderItem(product3, new BigDecimal(2));

        Product product4 = new Product("phone", "5530", new BigDecimal(100));
        OrderItem item4 = new OrderItem(product4, new BigDecimal(2));

        shoppingCard.addOrderItem(item1);
        shoppingCard.addOrderItem(item2);
        shoppingCard.addOrderItem(item3);
        shoppingCard.addOrderItem(item4);
    }


    //TODO change print
    @Test
    public void testDefaultShoppingCard() {
        String actual = shoppingCard.getCheck();
        String expected = "category\tmodel\tprice\tamount\tpriceSale \ttotal\n" +
                "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n" +
                "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n" +
                "phone\t    a300\t100.00\t2.00\t100.00\t   200.00\n" +
                "phone\t    5530\t100.00\t2.00\t100.00\t   200.00\n" +
                "Total = 620.00";
        assertThat(actual, is(expected));
    }


    @Test
    public void testWithProductSaleAndConstantDiscount() {
        shoppingCard.setSale(new ProductSale(getSellProducts()));
        shoppingCard.setDiscount(new ConstantDiscount());
        String actual = shoppingCard.getCheck();
        String expected = "category\tmodel\tprice\tamount\tpriceSale \ttotal\n"
                + "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n"
                + "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n"
                + "phone\t    a300\t100.00\t2.00\t50.00\t   100.00\n"
                + "phone\t    5530\t100.00\t2.00\t100.00\t   200.00\n"
                + "Total = 510.00";
        assertThat(actual, is(expected));
    }

    @Test
    public void testWithGiftSaleAndConstantDiscount() {
        shoppingCard.setSale(new GiftSale(getGiftProducts()));
        shoppingCard.setDiscount(new ConstantDiscount());
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

    @Test
    public void testWithProductSaleAndAmountDiscount() {
        Product product = new Product("phone", "5530", new BigDecimal(300));
        OrderItem item = new OrderItem(product, new BigDecimal(2));
        shoppingCard.addOrderItem(item);

        shoppingCard.setSale(new ProductSale(getSellProducts()));
        shoppingCard.setDiscount(new AmountDiscount());
        String actual = shoppingCard.getCheck();
        String expected = "category\tmodel\tprice\tamount\tpriceSale \ttotal\n" +
                "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n" +
                "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n" +
                "phone\t    a300\t100.00\t2.00\t50.00\t   100.00\n" +
                "phone\t    5530\t100.00\t2.00\t100.00\t   200.00\n" +
                "phone\t    5530\t300.00\t2.00\t300.00\t   600.00\n" +
                "Total = 1108.79";
        assertThat(actual, is(expected));
    }

    @Test
    public void testWithGiftSaleAndAmountDiscount() {
        shoppingCard.setSale(new GiftSale(getGiftProducts()));
        shoppingCard.setDiscount(new AmountDiscount());
        String actual = shoppingCard.getCheck();
        String expected = "category\tmodel\tprice\tamount\tpriceSale \ttotal\n"
                + "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n"
                + "phone\t    cx70\t55.00\t2.00\t55.00\t   110.00\n"
                + "phone\t    a300\t100.00\t2.00\t100.00\t   200.00\n"
                + "phone\t    5530\t100.00\t2.00\t100.00\t   200.00\n"
                + "cover\t    K2l5\t50.00\t1.00\t0.00\t   0.00\n"
                + "Total = 620.00";
        assertThat(actual, is(expected));
    }


    private Map<Product, Product> getGiftProducts() {
        Map<Product, Product> giftProducts = new HashMap<>();
        Product product1 = new Product("phone", "5530", new BigDecimal(100));
        Product gift = new Product("cover", "K2l5", new BigDecimal(50));
        giftProducts.put(product1, gift);
        return giftProducts;
    }

    private Map<Product, BigDecimal> getSellProducts() {
        Map<Product, BigDecimal> sealProducts = new HashMap<>();
        Product product = new Product("phone", "a300", new BigDecimal(100));
        sealProducts.put(product, new BigDecimal(0.5));
        return sealProducts;
    }

    @Test
    public void testAddOrderItem() {
        ShoppingCard shoppingCard = new ShoppingCard();
        Product product = new Product("phone", "5530", new BigDecimal(100));
        OrderItem item = new OrderItem(product, new BigDecimal(2));
        shoppingCard.addOrderItem(item);
        assertThat(shoppingCard.getOrderItems(), hasItem(item));
        assertThat(shoppingCard.getOrderItems().size(), is(1));
    }

    @Test
    public void testRemoveOrderItem() {
        ShoppingCard shoppingCard = new ShoppingCard();
        Product product = new Product("phone", "5530", new BigDecimal(100));
        OrderItem item = new OrderItem(product, new BigDecimal(2));
        shoppingCard.addOrderItem(item);
        assertThat(shoppingCard.getOrderItems(), hasItem(item));
        assertThat(shoppingCard.getOrderItems().size(), is(1));
        shoppingCard.removeOrderItem(item);
        assertThat(shoppingCard.getOrderItems().size(), is(0));
    }




}

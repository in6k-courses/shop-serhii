import org.junit.Before;
import org.junit.Test;
import shop.ShoppingCard;
import shop.discont.AmountDiscount;
import shop.discont.CouponDiscount;
import shop.discont.NoDiscount;
import shop.model.OrderItem;
import shop.model.Product;
import shop.sale.GiftSale;
import shop.sale.NoSale;
import shop.sale.ProductSale;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class ShoppingCardTest {

    ShoppingCard shoppingCard;
    Product phone;

    @Before
    public void initShoppingCard() {
        shoppingCard = new ShoppingCard();
        phone = new Product("phone", "cx70", new BigDecimal(100));
        OrderItem item = new OrderItem(phone, new BigDecimal(2));
        shoppingCard.addOrderItem(item);
    }

    @Test
    public void testTotalCostWithOutSaleAndDiscount() {
        shoppingCard.setSale(new NoSale());
        shoppingCard.setDiscount(new NoDiscount());
        assertThat(shoppingCard.getTotalCost(), is(new BigDecimal(200)));
    }

    @Test
    public void testTotalCostWithProductSale() {
        ProductSale productSale = new ProductSale();
        productSale.addSale(phone, new BigDecimal(0.5));
        shoppingCard.setSale(productSale);
        assertThat(shoppingCard.getTotalCost(), closeTo(new BigDecimal(100), new BigDecimal(0.01)));
    }


    @Test
    public void testTotalCostWithGiftSale() {
        GiftSale giftSale = new GiftSale();
        Product gift = new Product("cover to phone", "e432", new BigDecimal(10));
        giftSale.addProductAndGift(phone, gift);
        shoppingCard.setSale(giftSale);
        assertThat(shoppingCard.getTotalCost(),is(new BigDecimal(200)));
    }

    @Test
    public void testTotalCostWithAmountDiscount(){
        AmountDiscount amountDiscount = new AmountDiscount(100,new BigDecimal(0.5));
        shoppingCard.setDiscount(amountDiscount);
        assertThat(shoppingCard.getTotalCost(),closeTo(new BigDecimal(100),new BigDecimal(0.01)));
        System.out.println(shoppingCard.getTotalCost());
    }

    @Test
    public void testTotalCostWithCouponDiscount(){
        CouponDiscount couponDiscount = new CouponDiscount(new BigDecimal(10));
        shoppingCard.setDiscount(couponDiscount);
        assertThat(shoppingCard.getTotalCost(),closeTo(new BigDecimal(190),new BigDecimal(0.01)));
    }

    @Test
    public void testAddOrderItemToShoppingCard() {
        ShoppingCard shoppingCard = new ShoppingCard();
        Product product = new Product("phone", "5530", new BigDecimal(100));
        OrderItem item = new OrderItem(product, new BigDecimal(2));
        shoppingCard.addOrderItem(item);
        assertThat(shoppingCard.getOrderItems(), hasItem(item));
        assertThat(shoppingCard.getOrderItems().size(), is(1));
    }

    @Test
    public void testRemoveOrderItemFromShoppingCard() {
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

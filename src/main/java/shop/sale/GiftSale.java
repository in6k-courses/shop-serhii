package shop.sale;

import shop.product.OrderItem;
import shop.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiftSale implements Sale {
    private Map<Product, Product> giftProducts;

    public GiftSale() {
        giftProducts = new HashMap<Product, Product>();
        Product product1 = new Product("phone", "5530", new BigDecimal(100));
        Product gift = new Product("cover", "K2l5", new BigDecimal(50));
        giftProducts.put(product1, gift);
    }

    public void applySale(List<OrderItem> products) {
        List<OrderItem> gifts = new ArrayList<>();
        for (OrderItem item : products) {
            if (giftProducts.containsKey(item.getProduct())) {
                Product gift = giftProducts.get(item.getProduct());
                OrderItem orderItemGift = new OrderItem(gift, new BigDecimal(1));
                orderItemGift.setPurchasePrice(new BigDecimal(0));
                gifts.add(orderItemGift);
            }
        }
        products.addAll(gifts);
    }

}

package shop.sale;


import shop.product.OrderItem;
import shop.product.Product;
import shop.product.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GiftSale implements Sale {
    ProductService productService = new ProductService();

    public void applySale(List<OrderItem> products) {
        List<OrderItem> gifts = new ArrayList<OrderItem>();

        for (OrderItem orderItem : products) {
            Product gift = productService.getGiftIfExist(orderItem.getProduct());
            if (gift != null) {
                OrderItem orderItemGift = new OrderItem(gift, new BigDecimal(1));
                orderItemGift.setOrderedPrice(new BigDecimal(0));
                gifts.add(orderItemGift);
            }
        }
        products.addAll(gifts);
    }

}

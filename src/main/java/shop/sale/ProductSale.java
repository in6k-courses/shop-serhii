package shop.sale;

import shop.product.OrderItem;
import shop.product.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductSale implements Sale {
    private ProductService productService = new ProductService();

    public void applySale(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            BigDecimal orderedPrice = orderItem.getOrderedPrice();
            BigDecimal sale = productService.getSale(orderItem.getProduct());
            orderItem.setOrderedPrice(orderedPrice.multiply(sale));
        }
    }


}

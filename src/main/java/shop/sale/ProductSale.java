package shop.sale;

import shop.product.OrderItem;
import shop.product.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSale implements Sale {

    private Map<Product, BigDecimal> sealProducts;

    public ProductSale() {
        sealProducts = new HashMap<>();
        Product product = new Product("phone", "a300", new BigDecimal(100));
        sealProducts.put(product, new BigDecimal(0.5));
    }

    public void applySale(List<OrderItem> orderItems) {
        for (OrderItem item : orderItems) {
            if (sealProducts.containsKey(item.getProduct())) {
                BigDecimal purchasePrice = item.getPurchasePrice();
                BigDecimal sale = sealProducts.get(item.getProduct());
                item.setPurchasePrice(purchasePrice.multiply(sale));
            }
        }
    }
}

package shop.sale;

import shop.model.OrderItem;
import shop.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSale implements Sale {

    private Map<Product, BigDecimal> sealProducts;

    public ProductSale(Map<Product, BigDecimal> sealProducts) {
        this.sealProducts = sealProducts;
    }

    public void applySale(List<OrderItem> orderItems) {
        for (OrderItem item : orderItems)
            if (sealProducts.containsKey(item.getProduct()))
                setSalePurchasePrice(item);
    }

    private void setSalePurchasePrice(OrderItem item) {
        BigDecimal purchasePrice = item.getPurchasePrice();
        BigDecimal sale = sealProducts.get(item.getProduct());
        item.setPurchasePrice(purchasePrice.multiply(sale));
    }
}

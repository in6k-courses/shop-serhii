package shop.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private Map<Product, BigDecimal> sellProducts;
    private Map<Product, Product> giftProducts;

    public ProductService() {
        sellProducts = new HashMap<Product, BigDecimal>();
        Product product = new Product("phone", "a300", new BigDecimal(100));
        sellProducts.put(product, new BigDecimal(0.5));

        giftProducts = new HashMap<Product, Product>();
        Product product1 = new Product("phone", "5530", new BigDecimal(100));
        Product gift = new Product("cover", "K2l5", new BigDecimal(50));
        giftProducts.put(product1, gift);
    }

    public boolean checkSale(Product product) {
        return sellProducts.containsKey(product);
    }

    public BigDecimal getSale(Product product) {
        if (checkSale(product)) {
            return sellProducts.get(product);
        } else
            return new BigDecimal(1);
    }

    public Product getGiftIfExist(Product product) {
        if (giftProducts.containsKey(product)) {
            return giftProducts.get(product);
        } else
            return null;
    }

    public void addSellProduct(Product product, BigDecimal sell) {
        sellProducts.put(product, sell);
    }

    public void removeSellProduct(Product product) {
        sellProducts.remove(product);
    }

    public void addGiftProduct(Product product, Product gift) {
        giftProducts.put(product, gift);
    }

    public void removeGiftProduct(Product product) {
    }

}

package shop.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private Map<Product, BigDecimal> sellProducts;
    private Map<Product, Product> giftProducts;


    public ProductService() {
        sellProducts = new HashMap<Product, BigDecimal>();
        sellProducts.put(new Product("phones", "nokia 5530", new BigDecimal(55.34)), new BigDecimal(0.5));
        sellProducts.put(new Product("phones", "samsung a300", new BigDecimal(22.1)), new BigDecimal(0.5));


        giftProducts = new HashMap<Product, Product>();
        giftProducts.put(new Product("phones", "samsung a300", new BigDecimal(22.1)),
                new Product("phones", "samsung a300", new BigDecimal(22.1)));

/*        sellProducts.put(new Product("notebook", "acer 700",),0);
        sellProducts.put(new Product("notebook", "dell 7720"),0);
        sellProducts.put(new Product("notebook", "asus 333"),0);*/
        // giftProducts.put(new Product("phones", "nokia 5530",new BigDecimal(55.34)),)
    }

    public boolean checkSale(Product product) {
        return sellProducts.containsKey(product);
    }

    public BigDecimal getSale(Product product) {
        if (checkSale(product)) {
            return sellProducts.get(product);
        } else return new BigDecimal(1);
    }


    public Product getGiftIfExist(Product product) {
        if (giftProducts.containsKey(product)) {
            return giftProducts.get(product);
        } else return null;
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        BigDecimal sale = productService.getSale(new Product("phones", "samsung a300", new BigDecimal(22.1)));
        System.out.println(sale);

    }

}

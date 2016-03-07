package shop.model;

import java.math.BigDecimal;

public class Product {

    private String category;
    private String modelName;
    private final BigDecimal price;

    public Product(String category, String modelName, BigDecimal price) {
        this.category = category;
        this.modelName = modelName;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (modelName != null ? !modelName.equals(product.modelName) : product.modelName != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return category + "\t    " + modelName + "\t" + price.setScale(2, BigDecimal.ROUND_FLOOR);
    }
}

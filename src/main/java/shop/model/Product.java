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

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (!(obj instanceof Product)))
            return false;
        Product that = (Product) obj;
        return modelName.equals(that.modelName) &&
                category.equals(that.category);
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + modelName.hashCode();
        hash = 31 * hash + category.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return category + "\t    " + modelName + "\t" + price.setScale(2, BigDecimal.ROUND_FLOOR);
    }
}

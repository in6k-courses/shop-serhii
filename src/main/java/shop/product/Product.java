package shop.product;

import java.math.BigDecimal;

public class Product {

    private String category;
    private String name;
    private final BigDecimal price;


    public Product(String category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name.equals(that.name) &&
                category.equals(that.category);
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + category.hashCode();
        return hash;
    }

}

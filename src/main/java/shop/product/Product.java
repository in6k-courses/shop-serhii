package shop.product;

import java.math.BigDecimal;

public class Product {

    private String category;
    private String model;
    private final BigDecimal price;

    public static void main(String[] args) {
        Product product1 = new Product("a", "b", new BigDecimal(33));
        Product product2 = new Product("a", "b", new BigDecimal(33));
        System.out.println(product1.hashCode()+ " \n" + product2.hashCode());
    }

    public Product(String category, String model, BigDecimal price) {
        this.category = category;
        this.model = model;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        return model.equals(that.model) &&
                category.equals(that.category);
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + model.hashCode();
        hash = 31 * hash + category.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return category + "\t    " + model + "\t" + price.setScale(2, BigDecimal.ROUND_FLOOR);
    }
}

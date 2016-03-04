package shop.product;

import java.math.BigDecimal;

public class OrderItem {

    Product product;
    BigDecimal orderedPrice;
    int amount;

    public OrderItem(Product product,int amount) {
        this.product = product;
        orderedPrice = product.getPrice();
        this.amount = amount;
    }

    public BigDecimal getOrderedPrice() {
        return orderedPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrderedPrice(BigDecimal orderedPrice) {
        this.orderedPrice = orderedPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (!(obj instanceof OrderItem)))
            return false;
        OrderItem that = (OrderItem) obj;
        return product.equals(that.getProduct()) &&
                orderedPrice.equals(that.orderedPrice);
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + product.hashCode();
        hash = 31 * hash + orderedPrice.hashCode();
        return hash;
    }

    public static void main(String[] args) {
        OrderItem orderItem = new OrderItem(new Product("a","b",new BigDecimal(33)),5);
        OrderItem orderItem2 = new OrderItem(new Product("a","b",new BigDecimal(33)),5);
        System.out.println(orderItem.equals(orderItem2));
    }
}

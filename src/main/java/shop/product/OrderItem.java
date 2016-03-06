package shop.product;

import java.math.BigDecimal;

public class OrderItem {

   private Product product;
    private BigDecimal orderedPrice;
    private BigDecimal amount;


    public OrderItem(Product product, BigDecimal amount) {
        this.product = product;
        orderedPrice = product.getPrice().setScale(2,BigDecimal.ROUND_FLOOR);
        this.amount = amount;
    }

    public BigDecimal getOrderedPrice() {
        return orderedPrice;
    }

    public void setOrderedPrice(BigDecimal orderedPrice) {
        this.orderedPrice = orderedPrice;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal calculatePrice(){
        return orderedPrice.multiply(amount).setScale(2,BigDecimal.ROUND_FLOOR);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (!(obj instanceof OrderItem)))
            return false;
        OrderItem that = (OrderItem) obj;
        return product.equals(that.getProduct()) &&
                orderedPrice.equals(that.orderedPrice) && amount.equals(that.getAmount());
    }

    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + product.hashCode();
        hash = 31 * hash + orderedPrice.hashCode();
        hash = 31 * hash + amount.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return product.toString() + "\t" + amount.setScale(2, BigDecimal.ROUND_FLOOR) +
                 "\t" + orderedPrice.setScale(2, BigDecimal.ROUND_FLOOR) + "\t   " + calculatePrice();
    }

    public BigDecimal getAmount() {
        return amount;
    }


}

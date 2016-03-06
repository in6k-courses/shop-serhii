package shop;

import shop.discont.ConstantDiscount;
import shop.discont.Discount;
import shop.product.OrderItem;
import shop.sale.ProductSale;
import shop.sale.Sale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {

    private List<OrderItem> orderItems;
    private Sale saleStrategy;
    private Discount discountStrategy;

    public ShoppingCard() {
        orderItems = new ArrayList<OrderItem>();
        saleStrategy = new ProductSale();
        discountStrategy = new ConstantDiscount();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public BigDecimal getTotal() {
        saleStrategy.applySale(orderItems);
        BigDecimal total = new BigDecimal(0);
        for (OrderItem item : orderItems) {
            total = total.add(item.calculatePrice());
        }
        total = discountStrategy.applyDiscount(total);
        return total.setScale(2, RoundingMode.FLOOR);
    }

    public String getCheck() {
        BigDecimal total = getTotal();
        StringBuilder builder = new StringBuilder("category\tmodel\tprice\tamount\tpriceSale \ttotal\n");
        for (OrderItem orderItem : orderItems) {
            builder.append(orderItem);
            builder.append("\n");
        }
        builder.append("Total = " + total);
        return builder.toString();
    }

    public Sale getSaleStrategy() {
        return saleStrategy;
    }

    public void setSaleStrategy(Sale saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public Discount getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(Discount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}

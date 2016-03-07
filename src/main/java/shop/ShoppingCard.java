package shop;


import shop.discont.Discount;
import shop.discont.NoDiscount;
import shop.model.OrderItem;
import shop.sale.NoSale;
import shop.sale.Sale;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {

    private List<OrderItem> orderItems;
    private Sale saleStrategy;
    private Discount discountStrategy;

    public ShoppingCard() {
        orderItems = new ArrayList<>();
        saleStrategy = new NoSale();
        discountStrategy = new NoDiscount();
    }
//TODO change class to do one work
    public String getCheck() {
        BigDecimal total = getFullCost();
        StringBuilder check = new StringBuilder("");
        check.append(getCheckHead());
        check.append(getCheckBody());
        check.append("Total = " + total);
        return check.toString();
    }

    private BigDecimal getFullCost() {
        saleStrategy.applySale(orderItems);
        BigDecimal total = getOrderItemTotalCost();
        total = discountStrategy.applyDiscount(total);
        return total.setScale(2, BigDecimal.ROUND_FLOOR);
    }

    private BigDecimal getOrderItemTotalCost() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : orderItems) {
            total = total.add(item.calculateCost());
        }
        return total;
    }
    
    private String getCheckHead() {
        return "category\tmodel\tprice\tamount\tpriceSale \ttotal\n";
    }

    private String getCheckBody() {
        StringBuilder checkBody = new StringBuilder();
        for (OrderItem orderItem : orderItems) {
            checkBody.append(orderItem);
            checkBody.append("\n");
        }
        return checkBody.toString();
    }

    public void setSale(Sale saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    public void setDiscount(Discount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void removeOrderItem(OrderItem orderItem){
        if(orderItems.contains(orderItem)){
            orderItems.remove(orderItem);
        }
    }
}

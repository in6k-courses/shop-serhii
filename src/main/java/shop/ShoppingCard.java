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

    public BigDecimal getTotalCost(){
        BigDecimal total;
        saleStrategy.applySale(orderItems);
        total = getTotalOrderItemCost();
        total = total.subtract(discountStrategy.applyDiscount(total));
        return total;
    }

    public BigDecimal getTotalOrderItemCost() {
        BigDecimal total = BigDecimal.ZERO;
        for(OrderItem item: orderItems){
            total = total.add(item.getPurchasePrice());
        }
        return total;
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

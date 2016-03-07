package shop;

import shop.discont.ConstantDiscount;
import shop.discont.Discount;
import shop.model.OrderItem;
import shop.model.Product;
import shop.sale.ProductSale;
import shop.sale.Sale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCard {

    private List<OrderItem> orderItems;
    private Sale saleStrategy;
    private Discount discountStrategy;

    public ShoppingCard() {
        orderItems = new ArrayList<>();
        saleStrategy = new ProductSale(new HashMap<Product, BigDecimal>());
        discountStrategy = new ConstantDiscount();
    }

    public BigDecimal getTotalPurchaseCost() {
        saleStrategy.applySale(orderItems);
        BigDecimal total = getOrderItemTotalCost();
        total = discountStrategy.applyDiscount(total);
        return total.setScale(2, RoundingMode.FLOOR);
    }

    private BigDecimal getOrderItemTotalCost() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : orderItems) {
            total = total.add(item.calculateCost());
        }
        return total;
    }

    public String getCheck() {
        BigDecimal total = getTotalPurchaseCost();
        StringBuilder check = new StringBuilder("");
        check.append(getCheckHead());
        check.append(getCheckBody());
        check.append("Total = " + total);
        return check.toString();
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

    public void setSaleStrategy(Sale saleStrategy) {
        this.saleStrategy = saleStrategy;
    }
    public void setDiscountStrategy(Discount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

}

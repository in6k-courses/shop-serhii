package shop.sale;

import shop.model.OrderItem;

import java.util.List;

public interface Sale {
        void applySale(List<OrderItem> products);
}

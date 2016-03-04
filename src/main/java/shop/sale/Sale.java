package shop.sale;


import shop.product.OrderItem;

import java.util.List;

public interface Sale {
        void applySale(List<OrderItem> products);
}

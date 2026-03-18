package com.order.state;

import com.order.context.OrderContext;

public interface OrderState {
    void handle(OrderContext context);
}
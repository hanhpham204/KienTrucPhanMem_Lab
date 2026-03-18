package com.order.state;

import com.order.context.OrderContext;
import com.order.strategy.DeliveredStrategy;
import com.order.strategy.ProcessStrategy;

public class DeliveredState implements OrderState {
    public void handle(OrderContext context) {

        ProcessStrategy strategy = new DeliveredStrategy(); // ✅ đúng

        strategy.execute();
    }
}
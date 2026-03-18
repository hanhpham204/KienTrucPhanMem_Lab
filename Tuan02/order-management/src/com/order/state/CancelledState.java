package com.order.state;

import com.order.context.OrderContext;
import com.order.strategy.CancelStrategy;
import com.order.strategy.ProcessStrategy;

public class CancelledState implements OrderState {
    public void handle(OrderContext context) {
        ProcessStrategy strategy = new CancelStrategy();
        strategy.execute();
    }
}
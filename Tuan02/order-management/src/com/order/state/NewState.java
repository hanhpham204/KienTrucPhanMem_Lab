package com.order.state;

import com.order.context.OrderContext;
import com.order.strategy.CheckOrderStrategy;

public class NewState implements OrderState {
    public void handle(OrderContext context) {
        CheckOrderStrategy strategy = new CheckOrderStrategy();
        strategy.execute();

        context.setState(new ProcessingState());
    }
}
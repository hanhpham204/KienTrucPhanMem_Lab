package com.order.context;

import com.order.state.OrderState;

public class OrderContext {
    private OrderState state;

    public void setState(OrderState state) {
        this.state = state;
    }

    public void process() {
        if (state != null) {
            state.handle(this);
        } else {
            System.out.println("Chua co trang thai!");
        }
    }
}
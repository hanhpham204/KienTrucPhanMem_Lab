package com.order.state;

import com.order.context.PaymentContext;

public interface PaymentState {
    void handle(PaymentContext context);
}
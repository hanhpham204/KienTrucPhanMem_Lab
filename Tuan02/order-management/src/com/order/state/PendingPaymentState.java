package com.order.state;

import com.order.context.PaymentContext;

public class PendingPaymentState implements PaymentState {
    public void handle(PaymentContext context) {
        System.out.println("⏳ Dang cho thanh toán...");
        context.setState(new CompletedPaymentState());
    }
}

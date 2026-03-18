package com.order.state;

import com.order.context.PaymentContext;

public class CompletedPaymentState implements PaymentState {
    public void handle(PaymentContext context) {
        System.out.println("Thanh toan thanh công!");
    }
}
package com.order.decorator;

import com.order.strategy.PaymentStrategy;

public class FeeDecorator extends PaymentDecorator {

    public FeeDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    public void pay(double amount) {
        double fee = amount * 0.02;
        System.out.println("➕ Phi xu ly: " + fee);
        super.pay(amount + fee);
    }
}
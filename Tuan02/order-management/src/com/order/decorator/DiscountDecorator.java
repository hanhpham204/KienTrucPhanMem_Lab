package com.order.decorator;

import com.order.strategy.PaymentStrategy;

public class DiscountDecorator extends PaymentDecorator {

    public DiscountDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    public void pay(double amount) {
        double discount = amount * 0.1;
        System.out.println("Giam gia: -" + discount);
        super.pay(amount - discount);
    }
}
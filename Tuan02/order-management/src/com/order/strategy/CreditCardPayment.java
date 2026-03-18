package com.order.strategy;

public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("💳 Thanh toan bang the: " + amount);
    }
}

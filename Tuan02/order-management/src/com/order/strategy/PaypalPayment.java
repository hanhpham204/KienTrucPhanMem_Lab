package com.order.strategy;

public class PaypalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("🅿️ Thanh toan PayPal: " + amount);
    }
}
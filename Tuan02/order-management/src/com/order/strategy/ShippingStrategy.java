package com.order.strategy;

public class ShippingStrategy implements ProcessStrategy {
    public void execute() {
        System.out.println("📦 Dong goi va van chuyen...");
    }
}
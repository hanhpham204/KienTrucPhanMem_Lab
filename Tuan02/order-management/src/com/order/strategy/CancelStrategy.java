package com.order.strategy;

public class CancelStrategy implements ProcessStrategy {
    public void execute() {
        System.out.println("❌ Huy don va hoan tien...");
    }
}
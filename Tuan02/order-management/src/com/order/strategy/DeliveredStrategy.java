package com.order.strategy;



public class DeliveredStrategy implements ProcessStrategy {

    @Override
    public void execute() {
        System.out.println("✅ Don hang da duoc giao!");
    }
}
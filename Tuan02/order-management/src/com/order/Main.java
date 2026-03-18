package com.order;


import com.order.context.OrderContext;
import com.order.state.CancelledState;
import com.order.state.NewState;

public class Main {
    public static void main(String[] args) {

        OrderContext order = new OrderContext();

        System.out.println("=== Don moi ===");
        order.setState(new NewState());
        order.process();

        System.out.println("\n=== Dang xu ly ===");
        order.process();

        System.out.println("\n=== Da giao ===");
        order.process();

        System.out.println("\n=== Huy don ===");
        order.setState(new CancelledState());
        order.process();
    }
}
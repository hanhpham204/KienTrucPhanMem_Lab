package com.order.decorator;

import com.order.state.ProcessingState;
import com.order.strategy.ProcessStrategy;

public class FastDeliveryDecorator extends StrategyDecorator {

    public FastDeliveryDecorator(ProcessStrategy strategy) {
        super((ProcessStrategy) strategy);
    } // <-- Added missing closing brace

    @Override
    public void execute() {
        super.execute();
        System.out.println("🚀 Giao hang nhanh.");
    }
}
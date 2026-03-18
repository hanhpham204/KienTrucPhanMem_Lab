package com.order.decorator;

import com.order.strategy.ProcessStrategy;

public class InsuranceDecorator extends StrategyDecorator {

    public InsuranceDecorator(ProcessStrategy strategy) {
        super(strategy);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("🛡️ Them bao hiem cho don hang.");
    }
}
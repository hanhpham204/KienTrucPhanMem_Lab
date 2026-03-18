package com.order.decorator;

import com.order.state.ProcessingState;
import com.order.strategy.ProcessStrategy;
public abstract class StrategyDecorator implements ProcessStrategy {
    protected ProcessStrategy strategy;

    public StrategyDecorator(ProcessStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute(); // ❗ nếu null → crash
    }
}
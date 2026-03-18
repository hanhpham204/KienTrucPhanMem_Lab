package com.order.decorator;

import com.order.strategy.TaxStrategy;

public class ExtraTaxDecorator extends TaxDecorator {

    public ExtraTaxDecorator(TaxStrategy strategy) {
        super(strategy);
    }

    @Override
    public double calculate(double price) {
        double base = super.calculate(price);
        double extra = price * 0.05;
        return base + extra;
    }
}

package com.order.state;

import com.order.context.OrderContext;
import com.order.decorator.FastDeliveryDecorator;
import com.order.decorator.InsuranceDecorator;
import com.order.strategy.ProcessStrategy;
import com.order.strategy.ShippingStrategy;
public class ProcessingState implements OrderState {
    public void handle(OrderContext context) {

        // ✅ BẮT BUỘC: tạo strategy gốc trước
        ProcessStrategy strategy = new ShippingStrategy();

        // ✅ Sau đó mới decorator
        strategy = new FastDeliveryDecorator(strategy);
        strategy = new InsuranceDecorator(strategy);

        strategy.execute();

        context.setState(new DeliveredState());
    }
}
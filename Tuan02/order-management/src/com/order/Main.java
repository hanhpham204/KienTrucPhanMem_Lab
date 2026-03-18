package com.order;


import com.order.context.OrderContext;
import com.order.context.PaymentContext;
import com.order.decorator.DiscountDecorator;
import com.order.decorator.ExtraTaxDecorator;
import com.order.decorator.FeeDecorator;
import com.order.state.CancelledState;
import com.order.state.NewState;
import com.order.state.PendingPaymentState;
import com.order.strategy.CreditCardPayment;
import com.order.strategy.PaymentStrategy;
import com.order.strategy.TaxStrategy;
import com.order.strategy.VATStrategy;

public class Main {
    public static void main(String[] args) {

        // ===== BÀI 1 =====
        System.out.println("=== ORDER ===");
        OrderContext order = new OrderContext();
        order.setState(new NewState());
        order.process();
        order.process();
        order.process();

        // ===== BÀI 2 =====
        System.out.println("\n=== TAX ===");
        double price = 1000;

        TaxStrategy tax = new VATStrategy();
        tax = new ExtraTaxDecorator(tax);

        System.out.println("Thuế: " + tax.calculate(price));

        // ===== BÀI 3 =====
        System.out.println("\n=== PAYMENT ===");

        PaymentStrategy payment = new CreditCardPayment();
        payment = new DiscountDecorator(payment);
        payment = new FeeDecorator(payment);

        payment.pay(1000);

        PaymentContext context = new PaymentContext();
        context.setState(new PendingPaymentState());
        context.process();
        context.process();
    }
}
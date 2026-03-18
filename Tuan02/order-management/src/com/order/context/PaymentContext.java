package com.order.context;

import com.order.state.PaymentState;

public class PaymentContext {

    private PaymentState state;

    // Set trạng thái
    public void setState(PaymentState state) {
        this.state = state;
    }

    // Xử lý theo state hiện tại
    public void process() {
        if (state != null) {
            state.handle(this);
        } else {
            System.out.println("❗ Chua co trang thai thanh toan!");
        }
    }
}
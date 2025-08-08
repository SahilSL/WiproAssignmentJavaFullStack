package com.example.junit;
/*5.Scenario: In an OrderService, there’s a method placeOrder() that internally calls PaymentService.processPayment().
Mock PaymentService
Verify that processPayment() is called exactly once*/
public class OrderService{

    public interface PaymentService {
        void processPayment();
    }

    public static class OrderServiceclass {
        private PaymentService paymentService;

        public OrderServiceclass(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        public void placeOrder() {
            System.out.println("Placing order...");
            paymentService.processPayment();
        }
    }
}

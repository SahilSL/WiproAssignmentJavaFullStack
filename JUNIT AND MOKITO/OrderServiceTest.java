package com.example.junit;
/*5.Scenario: In an OrderService, there’s a method placeOrder() that internally calls PaymentService.processPayment().
Mock PaymentService
Verify that processPayment() is called exactly once*/
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder_CallsProcessPaymentOnce() {
        // Create mock PaymentService
        OrderService.PaymentService mockPaymentService = mock(OrderService.PaymentService.class);

        // Inject mock into OrderService
        OrderService.OrderServiceclass orderService = new OrderService.OrderServiceclass(mockPaymentService);

        // Call placeOrder()
        orderService.placeOrder();

        // Verify processPayment() was called exactly once
        verify(mockPaymentService, times(1)).processPayment();
    }
}

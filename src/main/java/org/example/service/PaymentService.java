package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPayment(Long bookingId, Double amount) {
        // Mock payment processing
        System.out.println("Processing payment for booking: " + bookingId + ", amount: $" + amount);

        // Simulate payment success (you can add logic for failure scenarios)
        try {
            Thread.sleep(1000); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Payment Successful for booking: " + bookingId);
        return true;
    }
}

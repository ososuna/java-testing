package com.platzi.payment;

public interface PaymentGateway {
  
  PaymentResponse requestPayment(PaymentRequest paymentRequest);

}

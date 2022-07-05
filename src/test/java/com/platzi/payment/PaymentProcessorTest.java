package com.platzi.payment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentProcessorTest {
  
  @Mock
  private PaymentGateway paymentGateway;

  @Test
  public void paymentIsCorrect() {
    when(paymentGateway.requestPayment(any()))
      .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
    PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
    assertTrue(paymentProcessor.makePayment(1000));
  }

  @Test
  public void paymentIsWrong() {
    when(paymentGateway.requestPayment(any()))
      .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
    PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
    assertFalse(paymentProcessor.makePayment(1000));
  }

}

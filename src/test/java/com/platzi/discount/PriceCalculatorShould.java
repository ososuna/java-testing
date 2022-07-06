package com.platzi.discount;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class PriceCalculatorShould {
  
  @Test
  public void totalZeroWhenThereArePrices() {
    PriceCalculator priceCalculator = new PriceCalculator();
    assertThat(priceCalculator.getTotal(), is(0.0));
  }

  @Test
  public void totalIsTheSumOfPrices() {
    PriceCalculator priceCalculator = new PriceCalculator();
    priceCalculator.addPrice(10.0);
    priceCalculator.addPrice(20.0);
    assertThat(priceCalculator.getTotal(), is(30.0));
  }

  @Test
  public void applyDiscountToPrices() {
    PriceCalculator priceCalculator = new PriceCalculator();
    priceCalculator.addPrice(100);
    priceCalculator.addPrice(50);
    priceCalculator.addPrice(50);
    priceCalculator.setDiscount(25);
    assertThat(priceCalculator.getTotal(), is(150.0));
  }

}

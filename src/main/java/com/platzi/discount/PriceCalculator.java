package com.platzi.discount;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

  private List<Double> prices = new ArrayList<>();
  private double discount;

  public double getTotal() {
    Double total = prices.stream().mapToDouble(p -> p).sum();
    return total - (total * (discount / 100));
  }

  public void addPrice(double price) {
    prices.add(price);
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

}

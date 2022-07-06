package com.platzi.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzShould {

  @Test
  public void returnFizzWhenNumberIsDivisibleBy3() {
    assertEquals(FizzBuzz.fizzBuzz(27), "Fizz");
  }

  @Test
  public void returnBuzzWhenNumberIsDivisibleBy5() {
    assertEquals(FizzBuzz.fizzBuzz(220), "Buzz");
  }

  @Test
  public void returnFizzBuzzWhenNumberIsDivisibleBy3And5() {
    assertEquals(FizzBuzz.fizzBuzz(15), "FizzBuzz");
  }

  @Test
  public void returnNumberWhenNumberIsNotDivisibleBy3Or5() {
    assertEquals(FizzBuzz.fizzBuzz(1), "1");
  }

}

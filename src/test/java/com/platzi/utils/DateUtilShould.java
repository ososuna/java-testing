package com.platzi.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilShould {
  
  @Test
  public void returnTrueWhenYearIsDivisibleBy400() {
    assertTrue(DateUtil.isLeapYear(1600));
    assertTrue(DateUtil.isLeapYear(2000));
    assertTrue(DateUtil.isLeapYear(2400));
  }

  @Test
  public void returnFalseWhenYearIsDivisibleBy100ButNotBy400() {
    assertFalse(DateUtil.isLeapYear(1700));
    assertFalse(DateUtil.isLeapYear(1800));
    assertFalse(DateUtil.isLeapYear(1900));
  }

  @Test
  public void returnTrueWhenYearIsDivisibleBy4ButNotBy100() {
    assertTrue(DateUtil.isLeapYear(1996));
    assertTrue(DateUtil.isLeapYear(2012));
    assertTrue(DateUtil.isLeapYear(2016));
  }

  @Test
  public void returnFalseWhenYearIsNotDivisibleBy4() {
    assertFalse(DateUtil.isLeapYear(1993));
    assertFalse(DateUtil.isLeapYear(1994));
    assertFalse(DateUtil.isLeapYear(1995));
  }
}
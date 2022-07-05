package com.platzi.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilTest {
  
  @Test
  public void testRepeatZero() {
    assertEquals(StringUtil.repeat("Hola", 0), "");
  }

  @Test
  public void testRepeatOnce() {
    assertEquals(StringUtil.repeat("Hola", 1), "Hola");
  }

  @Test
  public void testRepeatMultiple() {
    assertEquals(StringUtil.repeat("Hola", 3), "HolaHolaHola");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRepeatNegative() {
    StringUtil.repeat("Hola", -1);
  }

  @Test
  public void testNullIsEmpty() {
    assertTrue(StringUtil.isEmpty(null));
  }

  @Test
  public void testEmptyStringIsEmpty() {
    assertTrue(StringUtil.isEmpty(""));
  }

  @Test
  public void testSpacesStringIsEmpty() {
    assertTrue(StringUtil.isEmpty("   "));
  }

  @Test
  public void testIsNotEmpty() {
    assertFalse(StringUtil.isEmpty("hello"));
  }

}

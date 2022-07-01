package com.platzi.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilTest {
  
  @Test 
  public void testRepeat() {
    assertEquals(StringUtil.repeat("Hola", 3), "HolaHolaHola");
    assertEquals(StringUtil.repeat("Hola", 1), "Hola");
  }

}

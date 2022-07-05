package com.platzi.utils;

public class StringUtil {

  public static String repeat(String str, int times) {

    if (times < 0) {
      throw new IllegalArgumentException("Times must be greater than or equal to 0");
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < times; i++) {
      sb.append(str);
    }
    return sb.toString();
  }

}

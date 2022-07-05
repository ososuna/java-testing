package com.platzi.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PasswordUtilTest {

  @Test
  public void weakWhenHasLessThan8Characters() {
    assertEquals(
      PasswordUtil.SecurityLevel.WEAK,
      PasswordUtil.assessPassword("1234567")
    );
  }

  @Test
  public void weakWhenHasOnlyLetters() {
    assertEquals(
      PasswordUtil.SecurityLevel.WEAK,
      PasswordUtil.assessPassword("abcdefg")
    );
  }

  @Test
  public void mediumWhenHasLettersAndNumbers() {
    assertEquals(
      PasswordUtil.SecurityLevel.MEDIUM,
      PasswordUtil.assessPassword("abcdefg123")
    );
  }

  @Test
  public void strongWhenHasLettersAndNumbersAndSpecialCharacters() {
    assertEquals(
      PasswordUtil.SecurityLevel.STRONG,
      PasswordUtil.assessPassword("abcdefg123@")
    );
  }

}

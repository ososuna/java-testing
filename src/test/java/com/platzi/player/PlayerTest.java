package com.platzi.player;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

public class PlayerTest {
  
  @Test
  public void loosesWhenDiceNumberIsLessThanMinNumberToWin() {
    Dice dice = Mockito.mock(Dice.class);
    Mockito.when(dice.roll()).thenReturn(2);
    Player player = new Player(dice, 5);
    assertFalse(player.play());
  }

  @Test
  public void winsWhenDiceNumberIsGreaterThanMinNumberToWin() {
    Dice dice = Mockito.mock(Dice.class);
    Mockito.when(dice.roll()).thenReturn(6);
    Player player = new Player(dice, 5);
    assertTrue(player.play());
  }
}

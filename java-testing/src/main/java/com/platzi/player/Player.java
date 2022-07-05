package com.platzi.player;

public class Player {
  
  private Dice dice;
  private int minNumberToWIn;

  public Player(Dice dice, int minNumberToWIn) {
    this.dice = dice;
    this.minNumberToWIn = minNumberToWIn;
  }

  public boolean play() {
    int diceNumber = dice.roll();
    return diceNumber >= minNumberToWIn;
  }
}

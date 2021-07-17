/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author brandoncotton
 */
public class Card {
  //suit of the card
  private String suit;
  //number that will be displayed. Only changes for Jacks, Queens, Kings, and Aces
  private String numDisplay;
  //Actual value of the card
  private int value;
  
  public Card(){
    suit = "default";
    value = 0;
    numDisplay = "default";
  }
  
  public Card(String suit, int value){
    this.suit = suit;
    this.value = value;
    if(value > 10){
      this.value = 10;
    }
    switch(value){
      case 1:
        numDisplay = "Ace";
        this.value = 11;
        break;
      case 11:
        numDisplay = "Jack";
        break;
      case 12:
        numDisplay = "Queen";
        break;
      case 13:
        numDisplay = "King";
        break;
        default:
        numDisplay = Integer.toString(value);
    }
  }
  
  @Override
  public String toString(){
    if(numDisplay == "Ace" || value == 8){
      return "an " + getNumDisplay() + " of " + getSuit();
    }
    return "a " + getNumDisplay() + " of " + getSuit();
  }

  /**
   * @return the suit
   */
  public String getSuit() {
    return suit;
  }

  /**
   * @param suit the suit to set
   */
  public void setSuit(String suit) {
    this.suit = suit;
  }

  /**
   * @return the numDisplay
   */
  public String getNumDisplay() {
    return numDisplay;
  }

  /**
   * @param numDisplay the numDisplay to set
   */
  public void setNumDisplay(String numDisplay) {
    this.numDisplay = numDisplay;
  }

  /**
   * @return the value
   */
  public int getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(int value) {
    this.value = value;
  }
}

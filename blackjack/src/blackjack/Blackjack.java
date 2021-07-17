/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author brandoncotton
 */
public class Blackjack {
  //keeps track of the player's cards
  static ArrayList<Card> cards = new ArrayList<>();
  static Card newestCard = new Card();
  //counts how many times the player stands.
  static int stands = 0;
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    String command = "";
    int score = 0;
    
    //The hit/stand system.
    while(true){
      
      
      /*
      waits for the user input either h or s. closes if the input is s. repeats if the input 
      is anything else
      */
      System.out.println("Hit or Stand? (type h/s)");
      
      command = keyboard.next();
      
      switch (command.toUpperCase()) {
        case "H":
          /*creates a new card and shows what card the player gets. Also adds that card's value to 
          the score.*/
          cards.add(cardCreate());
          score += newestCard.getValue();
          System.out.print("You were dealt " + newestCard.toString() + "\nCurrent Hand: ");
          
          
          /*shows the player's current hand and checks to see if an ace can be used as a one.*/
          for(int i = 0; i < cards.size();i++){
          System.out.print(cards.get(i).getNumDisplay() + " ");
            if(score > 21 && "Ace".equals(cards.get(i).getNumDisplay()) && cards.get(i).getValue() == 11){
              cards.get(i).setValue(1);
              score -=10;
            }
          }
          
          System.out.println("\nCurrent Score: " + score + "\n");
          break;
          
        //The player stands. This clears their score, clears their hand and adds one to the stand count.
        case "S":
          System.out.println("You stand.");
          stands++;
          score = 0;
          cards.clear();
          break;
          
        default:
          System.out.println("Please only input s or h.");
          break;
        }
        
      endCheck(score);
        
      }
    }
  
  /*Creates a card and checks to see if you already have it. If you already have the caard generated,
  Then it will generate another one.*/
  public static Card cardCreate(){
    String[] suits = {"Hearts","Clubs","Diamonds","Spades"};
    Random rand = new Random();
    Card card = new Card(suits[rand.nextInt(4)],rand.nextInt(13)+1);
    if(cards.contains(card)){
      card = cardCreate();
    }
    newestCard = card;
    return card;
  }
  
  
  //checks to see if the player has won or lost.
  public static void endCheck(int score){
    if(score > 21){
      System.out.println("You busted. GAME OVER.");
      System.exit(0);
    }
    else if(score == 21){
      System.out.println("You won!");
      if(stands == 0){
        System.out.println("And you didn't stand one time!");
      }
      else if(stands <= 3){
        System.out.println("And you did it in 3 stands or less!");
      }
      System.exit(0);
    }
  }
}

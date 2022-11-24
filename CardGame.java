import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import cardgame.Player;
import cardgame.Card;
import cardgame.CardDeck;

/**
 * A card game whereby a player needs 4 matching cards to win
 * they pick up a card from a deck to their left and discard a
 * card to their right. Each player is a thread.
 *
 * @author Max Ward, James White
 * @version 1.0
 *
 */

 /** 
  * A method to request the input of the number of players
  * Verifies the input is a positive integer and rejects inputs
  * that are negative, zero, or letters.
  * If the number of players is valid the method requests the
  * location of the pack file. If the pack file is found it verifies
  * that the pack has 8n cards and contains only positive integers.
  * The pack file is rejected if it contains letters, multiple integers
  * or is of the incorrect length.
  */
  public class CardGame {
   
    static int inputPlayers() {
        int players = 0;
    
        System.out.println("How many players are playing? ");
        Boolean test = false;
        while(test == false) {
            // Declare scanner object
            Scanner enter = new Scanner(System.in);
            if(enter.hasNextInt()) {
                players = enter.nextInt();
                if(players > 0) {
                    test = true;
                } else {
                    System.out.println("Enter positive number:");
                }
            } else {
                System.out.println("Enter valid number of players:");
            }
        }
        return players;
    }


    static ArrayList<Integer> inputPack(int players) {
        ArrayList<Integer> data = new ArrayList<Integer>();

        Boolean test = true;
        while (test == true) {
            System.out.println("Please enter name of pack to load: ");
            Scanner scanner = new Scanner(System.in);
            String pack = scanner.nextLine();
            int lines = 0;
            int verify = 0;

            try {
            File file = new File(pack);
            Scanner sc = new Scanner(file);
            // ensuring pack only contains integers
            while(sc.hasNextLine()) {
                String content = sc.nextLine();
                lines++;
                try{
                    int number = Integer.parseInt(content);
                    data.add(number);
                }
                catch (NumberFormatException ex){
                    //ex.printStackTrace();
                    System.out.println("File doesnt contain only integers");
                    verify = 1;
                }
            }
            // ensuring the pack contains the correct number of cards
            final int constant = 8;
            int n = constant * players;

            if (lines == n && verify == 0) {
                System.out.println("Pack found with correct number of cards inside");
                sc.close();
                test = false;

            } else {
                System.out.println("Please enter a pack with a valid number of cards in please");
                n = 1;
            }
        
            } catch (Exception e) {
                System.out.println("File name not found");
            e.getStackTrace();
            }
        }
        return data;
    }
    
/**
 * Executable main method which stores the number of players
 * inputed by the user to a variable and converts the inputed
 * card pack from the user into an ArrayList. Begins the game
 * and checks continuously too see if a player has won.
 */
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<CardDeck> decks = new ArrayList<>();
        int noPlayers = inputPlayers();
        ArrayList<Integer> cardPack = inputPack(noPlayers);
        System.out.println(cardPack);

        for (int j=1;j<noPlayers+1;j++) {
            players.add(new Player(j));
            decks.add(new CardDeck(j));
        }
       distributeCards(noPlayers, players, decks, cardPack);
        for (Player p : players) {
            p.start();
        }
        
        boolean gameNotWon = true;

        while(gameNotWon);
            for (Player p : players) {
                p.takeTurn(decks);
                if (p.winCheck()) {
                    gameNotWon = false;
            for (Player a : players) {
                if (a.winCheck()) {
                    gameNotWon = false;
                }
            }
        System.out.println("end");
                }
            }    
    } 

/**
 * Method to distribute cards in a round robin fashion
 * to all players created and once all players have 4 cards
 * remaining cards are distributed in round robin fashion
 * to all the decks
 */
    public static void distributeCards(int noPlayers, ArrayList<Player> players, ArrayList<CardDeck> decks, ArrayList<Integer> cardPack){
        for (int i=1;i<noPlayers+1;i++){
            System.out.println("Giving each player a card");
            for (int j=1;j<noPlayers+1;j++){
                System.out.println("Player " + j + " is receiving a card");
                players.get(j-1).addCard(new Card(cardPack.get(i*noPlayers + j-1)));
            }
        }    
        for (int i=1;i<noPlayers+1;i++){
            System.out.println("Giving a card to each deck");
            for (int j=1;j<noPlayers+1;j++){
                System.out.println("Deck " + j + " is receiving a card");
                decks.get(j-1).addCard(new Card(cardPack.get(i*noPlayers + j-1)));
            }
        }
    }
}
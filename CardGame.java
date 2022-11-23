import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

import cardgame.Player;
import cardgame.Card;
import cardgame.CardDeck;

/* TASKS TO DO:
     * *DONE* player input and test validity 
     * *DONE* pack file input and validity
     *  player threads created
     *  new card object created and written to pack file
     *  cards are distributed to make list of hands and decks for each player (NOTE: Order is 1 card to each player in a round robin until 4 cards, then decks )
     *  output file is made for players and the decks EACH
     *  wincondition checked upon each player, if no win is made
     *  atomic action of drawing, checking win condition and discarding for player threads
     *  atomic action of drawing from top of deck and add from bottom of deck
     *  wincondition is met and player that has one notifies other players so game is stopped
     * Synchronise file writing
     */

public class CardGame {
   
    

    static int inputPlayers() {
        int players = 0;
    
        System.out.println("How many players are playing? ");
        Boolean test = false;
        while(test == false) {
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
        scanner.close();
        return data;
    }
    


    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        //ArrayList<CardDeck> decks = new ArrayList<>();
        int noPlayers = inputPlayers();
        ArrayList<Integer> CardPack = inputPack(noPlayers);
        System.out.println(CardPack);
    } 


    /*public static void distributeCards(){
        for (int i=0;i<4;i++){
            System.out.println("Giving each player a card");
            for (int j=0;j<noPlayers;j++){
                System.out.println("Player " + j + " is receiving a card");
                players.get(j).dealCard(pack.get(i*numberOfPlayers + j));
            }
        }    
        for (int i=0;i<4;i++){
            System.out.println("Giving a card to each deck");
            for (int j=0;j<noPlayers;j++){
                System.out.println("Deck " + j + " is receiving a card");
                players.get(j).dealCard(pack.get(i*noPlayers + j));
            }
        }
    }*/
}
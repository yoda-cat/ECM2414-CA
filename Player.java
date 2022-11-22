package cardgame;

import java.util.ArrayList;
import java.util.Random;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Player extends Thread {
    
    private final int playerID;
    private ArrayList<Card> hand = new ArrayList<Card>();

    //private BufferedWriter out;

    public Player(int ID) {
        this.playerID = ID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int[] getHandValues() {
        int[] cardValues = new int[hand.size()];
        for (int i = 0; i < hand.size(); i++) {
			cardValues[i] = hand.get(i).getValue();
		}
		return cardValues;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    //public void drawCard();
        //card = card taken from deck with ID playerID
        //add card to hand
        //(a card must be discarded beforehand or else this one may be removed which shiuldnt happen)
        //write the action to file

    public void discardCard() {
        cards = getHand();
        for (Card card : cards) {
            if (card.getValue() == playerID) {
                cards.remove(card);
            }
        Random random = new Random();
        Card discardCard = cards[random.nextInt(0,cards.size())];
        hand.remove(discardCard);
        //add card to deck with ID playerID + 1
        //OR
        //return the discarded card and the cardGame class sends it to the deck instead
        //write the action to file
        }


    }

    //boolean win checking method to be called by the cardGame for each round, return True if this player has won
    //if all cards in the hand have the same value then announce to all threads that the game has been won, terminal gets a message blah blah blah

    //file stuff:

    //String filename = "deck"+deckID+"_output.txt"
    //private BufferedWriter out = new BufferedWriter( new FileWriter( filename ) );

    //check to see if file already exists, if so then delete it
    //create file with name filename
    //
    //write to file method needed, gonna be called by a few methods


    //initial hand must be first thing in the file


    //final things in file are:
        //player x wins  OR  player n has informed player x that player n has won
        //player x exist
        //player x final hand: (their final hand)


    //private void writeToFile(String message) throws IOException {
    //    this.out.write(message);
    //    this.out.newLine();
    //    this.out.flush();
    //}

}







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

    public synchronized void takeTurn() {
        //drawCard();
        discardCard();
        //output current hand to file
    }

    //private void drawCard();
        //card = card taken from deck with ID playerID
        //add card to hand
        //(a card must be discarded beforehand or else this one may be removed which shiuldnt happen)
        //write the action to file

    private void discardCard() {
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

    public boolean hasWon() {
        int[] handValues = getHandValues();
        for (int value : handValues) {
            if (value != handValues[0]) {
                return False;
            }
        }
        //inform the other player threads that this player has won, the game is over
        //print to terminal that player (playerID) has won
        return True;
    }

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







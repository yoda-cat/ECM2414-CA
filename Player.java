package cardgame;

import java.util.ArrayList;
import java.util.Random;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;

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

    public synchronized void takeTurn(ArrayList<CardDeck> decks) {
        
        drawCard(decks.get(playerID - 1)); // deck with same ID as the player due to array positioning starting at 0
        
        if (playerID = decks.size()) { 
            discardCard(decks.get(0));
        }

        else {
            discardCard(decks.get(playerID));
        }
                
        //write current hand to file
    }

    private void drawCard(CardDeck deck) {
        Card chosenCard = deck.getTopCard();
        hand.add(chosenCard);
        //write the action to file
    }

    private void discardCard(CardDeck deck) {
        cards = getHand();
        for (Card card : cards) {
            if (card.getValue() == playerID) {
                cards.remove(card);
            }
        Random random = new Random();
        Card chosenCard = cards[random.nextInt(0,cards.size())];
        hand.remove(chosenCard);
        deck.addCard(chosenCard);
        //write the action to file
        }


    }

    public boolean winCheck() {
        int[] handValues = getHandValues();
        for (int value : handValues) {
            if (value != handValues[0]) {
                return false;
            }
        }
        //inform the other player threads that this player has won, the game is over
        //print to terminal that player (playerID) has won
        return true;
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







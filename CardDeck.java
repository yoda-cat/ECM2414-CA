package cardgame;

import java.util.ArrayList;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;

public class CardDeck {
    
    private int deckID;
    private ArrayList<Card> cards = new ArrayList<Card>();
    

    public CardDeck(int ID) {
        this.deckID = ID;
    }

    public int getDeckID() {
        return deckID;
    }
    
    public ArrayList<Card> getCards() {
        return cards;
    }

    public int[] getCardValues() {
        int[] cardValues = new int[cards.size()];
        for (int i = 0; i < cards.size(); i++) {
			cardValues[i] = cards.get(i).getValue();
		}
		return cardValues;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }



    
    //file writing stuff:

    String filename = "deck"+deckID+"_output.txt";
    //private BufferedWriter out = new BufferedWriter(new FileWriter(filename));

    //if (new File(filename).exists()) {
        //
    //}

    //check to see if file already exists, if so then delete it
    //create file with name filename
    //

    //at end of game put "deck'x' contents: (vals of each card in the deck)"

}

package cardgame;

import java.util.ArrayList;

public class CardDeck {
    
    private int deckID; //final?
    private ArrayList<Card> cards = new ArrayList<Card>();

    Deck(int ID) {
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

    public getTopCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;

    }

    //file writing stuff

    //String filename = "deck"+deckID+"_output.txt"
    //check to see if file already exists, if so then delete it
    //create file with name filename
    //
    //write to file method needed, gonna be called by a few methods


    //at end of game put "deck'x' contents: (vals of each card in the deck)"

}

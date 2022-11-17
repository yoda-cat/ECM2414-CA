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

    public getTopCard(Card card) {
        //find top card of deck
        //remove said card from cards array
        //return the card
    }

    //file writing stuff

}

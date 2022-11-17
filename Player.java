package cardgame;

import java.util.ArrayList;

public class Player extends Thread {
    
    private final int playerID;
    private ArrayList<Card> hand = new ArrayList<Card>();

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

    //discard card

    //do file stuff

    //

}

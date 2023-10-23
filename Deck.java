import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
/**
 * Emulate a deck of cards
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class Deck
{
    private List<Card> cards;

    /**
     * Deck constructor: Create an empty deck of cards
     */
    public Deck()
    {
        cards = new ArrayList<Card>();
    }

    public void initializeNewDeck() {
        String[] suits = {"Hearts","Clubs","Spades","Diamonds"};
        int[] ranks = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        String[] faces = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        for (String suit : suits) {
            for (int idx=0; idx<ranks.length; idx++) {
                Card c = new Card(ranks[idx], faces[idx], suit);
                this.cards.add(c);
            }
        }
    }

    /**
     * Get the number of cards in the deck
     * 
     * @returns Number of cards in the deck
     */
    public int getDeckSize() {

        return cards.size();
    }

    /**
     * Shuffles the cards in the deck
     */
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

    /**
     * Deal all the cards in the deck to make two new decks of cards
     * 
     * @returns Deck array where index 0 is the first deck and index 1 is the second deck
     */
    public Deck[] dealDeck() {
        Deck[] halves = new Deck[2];
        halves[0] = new Deck();
        halves[1] = new Deck();
        boolean idx = false;
        while (this.cards.size() > 0) {
            halves[idx ? 0 : 1].addCardToDeck(this.dealCardFromDeck());
            idx = !idx;
        }
        return halves;
    }

    /**
     * Deal the top card of the deck and remove it from the deck
     * @returns The top card of the deck (at cards index 0)
     */
    public Card dealCardFromDeck() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null;
        }
    }

    /**
     * Adds the provided card to the deck
     * @param cardToAdd: Card to add to this deck
     */
    public void addCardToDeck(Card cardToAdd) {
        cards.add(cardToAdd);
    }

}

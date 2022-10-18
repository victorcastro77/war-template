
/**
 * Implement a playing card
 *
 * @author Mr. Jaffe
 * @version 2022-10-18
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int rank;
    private String face;
    private String suit;

    /**
     * Constructor for objects of class Card
     */
    public Card(int rank, String face, String suit)        
    {
        this.rank = rank;
        this.face = face;
        this.suit = suit;
    }

    public int getRank() {
        return this.rank;
    }
    
    public void setRank(int newRank) {
        this.rank = newRank;
    }

    public String getSuit() {
        return this.suit;
    }

    public void setSuit(String newSuit) {
        this.suit = newSuit;
    }

    public String getFace() {
        return this.face;
    }

    public void setFace(String newFace) {
        this.face = newFace;
    }
}

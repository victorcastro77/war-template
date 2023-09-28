
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck d = new Deck();
        Deck p1;
        Deck p2;
        d.initializeNewDeck();
        d.shuffle();
        Deck[] halves = d.dealDeck();
        p1=halves[0];
        p2=halves[1];
        
        // ...then run the event loop
        this.runEventLoop(p1, p2);
    }
    public int getDeckSize1(Deck p1) {
        return p1.getDeckSize();
    }

    public int getDeckSize2(Deck p2) {
        return p2.getDeckSize();
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck p1, Deck p2) {
        boolean hasAll = false;
        boolean p1Win = false;
        boolean p2Win = false;
        if (getDeckSize1(p1) ==52) {
            p1Win = true;
        } else if (getDeckSize2(p2) == 52) {
            p2Win = true;
        }
        if (p1Win == true || p2Win == true) {
            hasAll = true;
        }
        while (!hasAll) {
            
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}

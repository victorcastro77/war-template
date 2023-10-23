public class War {
    private Deck p1;
    private Deck p2;
    private int roundLimit = 10000;
    public War() {
        // Initialize the decks, shuffle, and deal
        Deck d = new Deck();
        d.initializeNewDeck();
        d.shuffle();
        Deck[] halves = d.dealDeck();
        p1 = halves[0];
        p2 = halves[1];

        // Run the event loop
        runEventLoop();
    }

    public void runEventLoop() {
        int round = 0;
        while (p1.getDeckSize() > 0 && p2.getDeckSize() > 0 && round < roundLimit) {
            Card p1card = p1.dealCardFromDeck();
            Card p2card = p2.dealCardFromDeck();

            System.out.println("P1's card: " + p1card.getFace() + " of " + p1card.getSuit());
            System.out.println("P2's card: " + p2card.getFace() + " of " + p2card.getSuit());

            if (p1card.getRank() > p2card.getRank()) {
                System.out.println("P1 won this round");
                p1.addCardToDeck(p1card);
                p1.addCardToDeck(p2card);
            } else if (p2card.getRank() > p1card.getRank()) {
                System.out.println("P2 won this round");
                p2.addCardToDeck(p1card);
                p2.addCardToDeck(p2card);
            } else {
                // War situation
                System.out.println("War!");

                // Continue drawing 4 cards from each player
                for (int i = 0; i < 3; i++) {
                    if (p1.getDeckSize() > 0 && p2.getDeckSize() > 0) {
                        Card p1WarCard = p1.dealCardFromDeck();
                        Card p2WarCard = p2.dealCardFromDeck();

                        System.out.println("P1's war card: " + p1WarCard.getFace() + " of " + p1WarCard.getSuit());
                        System.out.println("P2's war card: " + p2WarCard.getFace() + " of " + p2WarCard.getSuit());

                        if (p1WarCard.getRank() > p2WarCard.getRank()) {
                            System.out.println("P1 won the war");
                            p1.addCardToDeck(p1card);
                            p1.addCardToDeck(p2card);
                            p1.addCardToDeck(p1WarCard);
                            p1.addCardToDeck(p2WarCard);
                        } else if (p2WarCard.getRank() > p1WarCard.getRank()) {
                            System.out.println("P2 won the war");
                            p2.addCardToDeck(p1card);
                            p2.addCardToDeck(p2card);
                            p2.addCardToDeck(p1WarCard);
                            p2.addCardToDeck(p2WarCard);
                        } else {

                        }
                    }
                }
            }
            round++;
            if (round >= roundLimit) {
                // End the game in a draw if the round limit is reached.
                System.out.println("Game ends in a draw after " + round + " rounds.");
                return;
            }
        }
        if (p1.getDeckSize() == 0) {
            System.out.println("P2 wins the game");
            return;
        } else if (p2.getDeckSize() == 0) {
            System.out.println("P1 wins the game");
            return;
        }
    }

    public static void main(String[] args) {
        War war = new War();
    }
}

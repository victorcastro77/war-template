import java.util.ArrayList;
import java.util.List;

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

                List<Card> warPile = new ArrayList<>();

                // Continue drawing 4 cards from each player
                for (int i = 0; i < 3; i++) {
                    if (p1.getDeckSize() > 0 && p2.getDeckSize() > 0) {
                        Card p1WarCard = p1.dealCardFromDeck();
                        Card p2WarCard = p2.dealCardFromDeck();

                        System.out.println("P1's war card: " + p1WarCard.getFace() + " of " + p1WarCard.getSuit());
                        System.out.println("P2's war card: " + p2WarCard.getFace() + " of " + p2WarCard.getSuit());

                        warPile.add(p1WarCard);
                        warPile.add(p2WarCard);
                    }
                }

                // Determine the winner of the war
                if (!warPile.isEmpty()) {
                    int p1WarCardRank = warPile.get(warPile.size() - 4).getRank(); // P1's last war card
                    int p2WarCardRank = warPile.get(warPile.size() - 2).getRank(); // P2's last war card

                    if (p1WarCardRank > p2WarCardRank) {
                        System.out.println("P1 won the war");
                        p1.addCardToDeck(p1card);
                        p1.addCardToDeck(p2card);
                        for (Card warCard : warPile) {
                            p1.addCardToDeck(warCard);
                        }
                    } else if (p2WarCardRank > p1WarCardRank) {
                        System.out.println("P2 won the war");
                        p2.addCardToDeck(p1card);
                        p2.addCardToDeck(p2card);
                        for (Card warCard : warPile) {
                            p2.addCardToDeck(warCard);
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
            if (p1.getDeckSize() == 0) {
                System.out.println("P2 wins the game");
                return;
            } else if (p2.getDeckSize() == 0) {
                System.out.println("P1 wins the game");
                return;
            }
        }
        }
        public static void main(String[] args) {
        War war = new War();
    }
}


package Example;

public class Blackjack {
    public static void main(String[] args) {
        // make a deck of cards
        DeckOfCards deck = new DeckOfCards();
        // shuffle
        deck.shuffle();
        Card card1 = deck.drawACard();
        card1.flip();
        System.out.println(card1);
        Card card2 = deck.drawACard();
        card2.flip();
        System.out.println(card2);
    }
}

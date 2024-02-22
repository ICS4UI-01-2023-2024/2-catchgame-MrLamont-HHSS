package Example;

public class DeckOfCards {
    private int numCards;
    private Card[] cards;

    // constructor
    public DeckOfCards(){
        // create 52 cards
        this.cards = new Card[52];
        char[] ranks = {'A', '2', '3', '4', '5', 
            '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}; 
        String[] suits = {"Clubs", "Diamonds", 
                    "Hearts", "Spades"};
        
        this.numCards = 0;
        // for each suit
        for(int i = 0; i < 4; i++){
            // for each rank
            for(int j = 0; j < 13; j++){
                // create a new card
                Card c = new Card(ranks[j], suits[i]);
                // put it into the array
                this.cards[this.numCards] = c;
                // increase the card count
                this.numCards++;
            }
        }
    }

    // takes one card from the deck
    public Card drawACard(){
        // Grab the card
        // last one is 1 less than the number of cards
        Card aCard = this.cards[this.numCards - 1];
        // "physically remove" the card from the array
        this.cards[this.numCards - 1] = null;
        // decrease our card count
        this.numCards--;
        // give the drawn card
        return aCard;
    }

    // accessor/getter to know how many cards
    // are left in the deck
    public int cardsLeft(){
        return this.numCards;
    }

    public void shuffle(){
        // go through the cards
        for(int i = 0; i < this.numCards - 1; i++){
            // generate random swap position
            int start = i;
            int end = this.numCards - 1;
            int swapPosition = (int)(Math.random()*(end - start + 1)+start);
            // swap the cards
            Card tempCard = this.cards[i];
            this.cards[i] = this.cards[swapPosition];
            this.cards[swapPosition] = tempCard;
  
        }
    }
}

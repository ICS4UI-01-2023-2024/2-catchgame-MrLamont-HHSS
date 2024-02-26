package Example;

public class Hand {
    private Card[] cards;
    private int numCards;
    private String name;

    public Hand(String name){
        this.name = name;
        this.cards = new Card[10];
        this.numCards = 0;
    }

    public void addCard(Card c){
        // add the card to the end of the hand
        this.cards[this.numCards] = c;
        // increase the card count
        this.numCards++;
    }

    public int handTotal(){
        // keep track of the number of Aces
        int aceCount = 0;
        // start a sum
        int sum = 0;
        // go through each card
        for(int i = 0; i < this.numCards; i++){
            // if the card is face down, skip it
            if(this.cards[i].isFaceUp() == false){
                // this moves on to the next i value
                continue;
            }
            // get the card rank
            char rank = this.cards[i].getRank();
            if(rank >= '1' && rank <= '9'){
                sum = sum + Integer.parseInt("" + rank);
            }else if(rank == 'A'){
                // ace always starts at 11
                sum = sum + 11;
                aceCount++;
            }else{
                // anything else is 10
                sum = sum + 10;
            }
        }

        // deal with over 21
        while(sum > 21 && aceCount > 0){
            // change aces to 1 if needed
            sum = sum - 10;
            aceCount--;
        }
        return sum;
    }

    public void showCards(){
        // go through each card
        for(int i = 0; i < this.numCards; i++){
            // if it isn't face up
            if(this.cards[i].isFaceUp() == false){
                // flip it face up
                this.cards[i].flip();
            }
        }
    }

    public String toString(){
        // blank String for the output
        String output = "";
        // add the name and move to new line
        output += this.name + "\n";
        // add all the cards
        output += "CARDS: ";
        // go through each card and and them
        for(int i = 0; i < this.numCards; i++){
            // this will automatically call toString on card
            output += this.cards[i];
            // decide if we need a comma
            if(i < this.numCards - 1){
                output += ", ";
            }
        }
        // add a new line and add the total
        output += "\nTOTAL: " + this.handTotal();
        // return our new String
        return output;
    }
}

package Example;

import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // make a deck of cards
        DeckOfCards deck = new DeckOfCards();
        // shuffle the deck
        deck.shuffle();
        // create player and dealer
        Hand player = new Hand("Mr. Lamont");
        Hand dealer = new Hand("Dealer");

        // deal face up cards to the player
        player.addCard(deck.drawFaceUpCard());
        // draw a different card
        player.addCard(deck.drawFaceUpCard());

        // dealer's starting cards
        dealer.addCard(deck.drawFaceUpCard());
        // non flipped card
        dealer.addCard(deck.drawACard());

        // game loop
        while(player.handTotal() < 21){
            // print both hands
            System.out.println(dealer);
            System.out.println();
            System.out.println(player);
            // determine if player hits or stays
            System.out.println("hit or stay?");
            String response = input.nextLine();
            if(response.equals("hit")){
                // draw a new card and add to total
                Card aCard = deck.drawFaceUpCard();
                System.out.println("You drew a " + aCard);
                player.addCard(aCard);
            }else{
                // didn't hit so move on
                break;
            }
        }
        // flip all dealer cards and print hands
        dealer.showCards();
        System.out.println(dealer);
        System.out.println(player);
        // while dealer is under 16
        while(dealer.handTotal() < 16){
            // dealer gets new card
            dealer.addCard(deck.drawFaceUpCard());
        }
        
        // Print both hands and determine the winner
        System.out.println(dealer);
        System.out.println(player);
        if(player.handTotal() > 21){
            System.out.println("Player busts. Dealer wins");
        }else if(dealer.handTotal() > 21){
            System.out.println("Dealer busts. Player wins");
        }else if(player.handTotal() > dealer.handTotal()){
            System.out.println("Player wins!");
        }else if(player.handTotal() == 21){
            System.out.println("21! Player wins");
        }else{
            System.out.println("Dealer wins");
        }
        
    }
}

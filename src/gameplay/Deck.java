package gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of playing cards, throughout a round of the game Uh-Oh.
 * @author Jack
 *
 */
public class Deck {
    private final List<Card> deck = new ArrayList<>();
    
    
    /**
     * Instantiate an unshuffled Deck of all 52 Cards.
     */
    public Deck() {
        for (int number = 1; number < 14; number++){
            for(int suit = 0; suit <4; suit++){
                if (suit == 0){
                    deck.add(new Card(number,"Spade"));
                }
                else if (suit == 1){
                    deck.add(new Card(number,"Heart"));
                }
                else if (suit == 2){
                    deck.add(new Card(number,"Club"));
                }
                else if (suit == 3){
                    deck.add(new Card(number,"Diamond"));
                }
            }
        }
    }
    
    /**
     * @return a random Card from the Deck, decrement the size of the Deck. 
     * @throws IndexOutOfofBoundsException if deck is empty
     */
    public Card getCard(){
        int deckSize = deck.size();
        if (deckSize == 0){
            throw new IndexOutOfBoundsException();
        }
        return deck.remove(new Random().nextInt(deckSize)); //returning a random index because the deck isn't shuffled
    }
    
    /**
     * Make a Hand of Cards to use during a Round of the game, remove those cards from the Deck.  
     * @param numCards how many Cards you want there to be in the Hand. 
     * @return a randomly generated Hand with numCards in it
     * @throws IndexOutOfofBoundsException if deck doesn't have enough cards to make hand that size. 
     */
    public Hand makeHand(int numCards){
        if (deck.size() < numCards){
            throw new IndexOutOfBoundsException();
        }
        List<Card> hand = new ArrayList<>();
        for (int ii = 0; ii < numCards; ii++){
            hand.add(this.getCard());
        }
        return new Hand(hand);
    }

}

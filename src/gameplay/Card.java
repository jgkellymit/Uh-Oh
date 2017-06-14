package gameplay;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A playing card from a standard deck of 52 cards. 
 * Suit can be Spade, Heart, Club, or Diamond. 
 * Value is represented 1-13 with Ace as 1 and Jack as 11, Queen as 12, King as 13. 
 * @author Jack
 *
 */
public class Card {
    
    private final int number;
    private final String suit;
    
    /**
     * Ensures the representation invariant is not broken
     */
    private void checkRep(){
        assert this.number <= 13;
        assert this.number >= 1;
        List<String> possibleSuits = Arrays.asList("Spade", "Heart", "Club", "Diamond");
        assert possibleSuits.contains(this.suit);
        
    }
    
    /**
     * Instantiates a specific card
     * @param set_number- the number 1-12, with 1 being an Ace and 13 being a King
     * @param set_suit- the suit
     */
    public Card(int set_number, String set_suit) {
        this.number = set_number;
        this.suit = set_suit;
        checkRep();
    }
    /**
     * Instantiates a random Card
     */
    public Card(){
        this.number = new Random().nextInt(13) + 1;
        int suit_number = new Random().nextInt(4);
        if (suit_number == 0) {
            this.suit = "Spade";
        }
        else if (suit_number == 1) {
            this.suit = "Club";
        }
        else if (suit_number == 2) {
            this.suit = "Heart";
        }
        else if (suit_number == 3) {
            this.suit = "Diamond";
        }
        else{ 
            this.suit = "";
        }
        checkRep();
    }

    /**
     * 
     * @return the card number, 1-12: 1 being and Ace and 13 being a King
     */
    public int getNumber(){
        return this.number;
    }
    
    /**
     * 
     * @return the suit of the card
     */
    public String getSuit(){
        return this.suit;
    }
}

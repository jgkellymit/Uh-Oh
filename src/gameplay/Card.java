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
    
    //Rep Invariant- number is between 1-13 (a valid playing card number) and the suit is one of the four
    //               playing card suits.
    
    /*
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
     * @param set_number- the number 1-13, with 1 being an Ace and 13 being a King
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
     * @return the card number, 1-13: 1 being and Ace and 13 being a King
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
    
    /**
     * Compare two cards to see which one is bigger, given the trump suit and the suit led
     * Assuming never comparing two cards that are both neither in the trump suit or the suitLed
     * Comparing the same card returns false
     * @param cardToCompare card to compare 
     * @param trumpSuit
     * @param suitLed
     * @return true if other card is bigger, false if this card is bigger
     */
    public boolean compareCard(Card cardToCompare, String trumpSuit, String suitLed){
        if (cardToCompare.getSuit() == trumpSuit){
            if (this.suit != trumpSuit){ //other card is trump, this card isn't
                return true;
            }
            else{
                if (cardToCompare.getNumber() > this.getNumber()){ // both trump but other bigger
                    return true;
                }
                return false;
            }
        }
        else{
            if (this.suit == trumpSuit){ //this is trump, other isn't
                return false;
            }
            else{
                if (cardToCompare.getSuit() == suitLed){ //both suits not trump, but other is suit that's led
                    if (cardToCompare.getNumber() > this.getNumber()){//other card is suit that's led and bigger than this card
                        return true;
                    }
                    if (this.suit != suitLed){ //other card is suit that's led, this isn't
                        return true;
                    }
                }
                return false; //other card isn't suit that's led or trump, this must be one of them so is bigger. 
            }  
        }
    }
    
    @Override
    public String toString(){
        Character suit = this.suit.toCharArray()[0];
        String output =  "--------\n"
                + "-"+ this.number + suit +"    -\n"
                + "-      -\n"
                + "-    " + this.number + suit + "-\n"
                + "--------\n";
        return output;
    }
}

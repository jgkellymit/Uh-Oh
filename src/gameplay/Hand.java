package gameplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Hand is a group of Cards, representative of the Cards a player has throughout a Trick
 * @author Jack
 *
 */
public class Hand {
    private final int handSize;
    private final List<Card> myCards;
    
    //Rep Invariant- Hand size is >=0 
    
    /*
     * Enforce Representation invariant
     */
    private void checkRep(){
        assert handSize >= 0;
    }
    
    
    /**
     * A group of Cards
     * @param oldHand a list of Cards to be in the Hand
     */
    public Hand(List<Card> oldHand){
        this.handSize = oldHand.size();
        this.myCards = oldHand;
        checkRep();
    }
    
    /**
     * A group of Cards generated randomly (could be duplicates)
     * @param howManyCards you want to start with in your hand
     */
    public Hand(int howManyCards) {
       this.handSize = howManyCards;
       this.myCards = new ArrayList<>();
       for (int ii = 0; ii < this.handSize; ii++){
           this.myCards.add(new Card());
       }
       checkRep();
    }

    
    /**
     * Remove a card from your Hand
     * @param cardToPlay
     * @throws IllegalArgumentException if you try to play a card not in your Hand
     */
    public Hand playCard(Card cardToPlay) throws IllegalArgumentException{
        if(this.myCards.remove(cardToPlay) == false){
            throw new IllegalArgumentException(); //Card not in your Hand
        }
        checkRep();
        return new Hand(this.myCards);
    }
    
    /**
     * @return unmodifiable view of Cards in the Hand
     */
    public List<Card> getHand(){
        return Collections.unmodifiableList(myCards);
    }
    
    /**
     * @return the current size of the Hand
     */
    public int getHandSize(){
        return handSize;
    }

}

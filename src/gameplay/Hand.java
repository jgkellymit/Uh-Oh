package gameplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private final int handSize;
    private final List<Card> myCards;
    
    
    public Hand(int howManyCards) {
       this.handSize = howManyCards;
       this.myCards = new ArrayList<>();
       for (int ii = 0; ii < this.handSize; ii++){
           this.myCards.add(new Card());
       }
    }
    
    public Hand(List<Card> oldHand){
        this.handSize = oldHand.size();
        this.myCards = oldHand;
    }
    
    public void playCard(Card cardToPlay) throws IllegalArgumentException{
        if(this.myCards.remove(cardToPlay) == false){
            throw new IllegalArgumentException();
        }
    }
    
    public List<Card> getHand(){
        return Collections.unmodifiableList(myCards);
    }
    
    public int getHandSize(){
        return handSize;
    }

}

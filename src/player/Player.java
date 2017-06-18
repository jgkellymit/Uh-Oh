package player;

import gameplay.Card;
import gameplay.Hand;

public interface Player {
    public static int numPlayers = 0;
    
    public Hand getCurrentHand();
    
    public void setCurrentHand(Hand newHand);
    
    public int bid();
    
    public Card playCard();
    
    
    

}

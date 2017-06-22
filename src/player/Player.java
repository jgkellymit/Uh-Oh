package player;

import java.util.List;

import gameplay.Card;
import gameplay.Hand;
import gameplay.Trick;

public interface Player {
    public static int NUM_PLAYERS = 0;
        
    public void setPlayers(List<Player> playerList);
    
    public Hand getCurrentHand();
    
    public void setCurrentHand(Hand newHand);
    
    public int bid();
    
    public Card playCard(Trick currentTrick);
    
    public void TricksWonByPlayer(List<Integer> playerTrickCounts);
    
    
    
    

}

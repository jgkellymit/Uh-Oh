package gameplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import player.Player;

/**
 * A Trick is one "play" during a Round of the game Uh-Oh. In every Round, there are numCards Tricks. 
 * @author Jack
 *
 */
public class Trick {
    private final int numPlayers;
    private final String trump;
    private final List<Card> cardsPlayed = new ArrayList<>();
    private final List<Player> playerPlayed = new ArrayList<>();
    
    /**
     * Instantiate a new Trick
     * @param numPlayers how many Players are playing the game 
     * @param trump the suit that is trump
     */
    public Trick(int numPlayers, String trump){
        this.numPlayers = numPlayers;
        this.trump = trump;

    }

    /**
     * Represents a player playing a Card during the Trick
     * @param cardPlayed
     * @param playerThatPlayed
     */
    public void playCard(Card cardPlayed, Player playerThatPlayed){
        cardsPlayed.add(cardPlayed);
        this.playerPlayed.add(playerThatPlayed);
    }
    
    /**
     * @return an unodifiable view of the Cards played during the trick. 
     */
    public List<Card> getTrick(){
        return Collections.unmodifiableList(this.cardsPlayed);
    }
    
    /**
     * Calculates the winner of the trick, must play cards in clockwise order (or order that you assign the players)
     * @return int representing the player that one the trick
     */
    public Player getWinner(){
        String suitLed = cardsPlayed.get(0).getSuit();
        Card currentHighestCard = cardsPlayed.get(0);
        Player playerWithHighestCard = this.playerPlayed.get(0);
        
        for (int ii = 0; ii < cardsPlayed.size(); ii++){
            if (cardsPlayed.get(ii) == currentHighestCard){  //should only happen on first iteration
                continue;
            }
            if (currentHighestCard.compareCard(cardsPlayed.get(ii), this.trump, suitLed)){ //thisCard beats current highestCard
                currentHighestCard = cardsPlayed.get(ii);
                playerWithHighestCard = this.playerPlayed.get(ii);
            }
        }
        return playerWithHighestCard;
    }
    
}

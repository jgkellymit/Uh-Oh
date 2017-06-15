package gameplay;

import java.util.ArrayList;
import java.util.List;

public class Trick {
    final int numPlayers;
    final Card trump;
    final List<Card> cardsPlayed = new ArrayList<>();
    final int playerThatLeads;
    
    
    public Trick(int numPlayers, int playerThatLeads) {
        this.numPlayers = numPlayers;
        this.trump = new Card();
        this.playerThatLeads = playerThatLeads;
    }
    
    public Trick(int numPlayers, Card trump, int playerThatLeads){
        this.numPlayers = numPlayers;
        this.trump = trump;
        this.playerThatLeads = playerThatLeads;

    }

    public void playCard(Card cardPlayed){
        cardsPlayed.add(cardPlayed);
    }
    
    /**
     * Calculates the winner of the trick, must play cards in clockwise order (or order that you assign the players)
     * @return int representing the player that one the trick
     */
    public int getWinner(){
        String suitLed = cardsPlayed.get(0).getSuit();
        Card highestCard = cardsPlayed.get(0);
        int playerWithHighestCard = this.playerThatLeads;
        
        for (Card thisCard:cardsPlayed){
            if (thisCard == highestCard){  //should only happen on first iteration
                continue;
            }
            if (highestCard.compareCard(thisCard, this.trump.getSuit(), suitLed)){ //thisCard beats current highestCard
                highestCard = thisCard;
                playerWithHighestCard = ((cardsPlayed.indexOf(thisCard) + this.playerThatLeads) % numPlayers);
            }
        }
        return playerWithHighestCard;
    }
    
}

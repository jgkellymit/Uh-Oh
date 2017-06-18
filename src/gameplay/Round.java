package gameplay;

import java.util.List;

import player.Player;


public class Round {
    private final Deck deck = new Deck();
    private final List<Player> players;
    private final int numCardsInRound;
    
    public Round(List<Player> peoplePlaying, int numCards) {
        this.players = peoplePlaying;
        this.numCardsInRound = numCards;
    }
    
    

}

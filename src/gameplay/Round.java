package gameplay;

import java.util.ArrayList;
import java.util.List;

import game_logs.BidLog;
import game_logs.ScoreLog;
import player.Player;


public class Round {
    private final Deck deck = new Deck();
    private List<Integer> playerBids = new ArrayList<>();;
    private Card trump = deck.getCard();
    private final List<Integer> tricksTaken = new ArrayList<>();
    
    private final List<Player> players;
    private final int numCardsInRound;
    private final ScoreLog scoreSheet;
    private final BidLog bidLog;
    private Player playerThatLeads;

    
    public Round(List<Player> peoplePlaying, int numCards, ScoreLog _scoresheet, BidLog _bidLog, Player _playerThatLeads) {
        this.players = peoplePlaying;
        this.numCardsInRound = numCards;
        this.scoreSheet = _scoresheet;
        this.bidLog = _bidLog;
        this.playerThatLeads = _playerThatLeads;
        
        for (int ii = 0; ii < this.players.size(); ii++){ //intialize all players with zero tricks
            this.tricksTaken.add(0); 
        }
    }
    
    private void dealHands(){
        for (int ii = 0; ii < players.size(); ii++){
            players.get(ii).setCurrentHand(deck.makeHand(this.numCardsInRound));
        }
    }
    
    private void getBids(){
        for (Player player : this.players){
            this.playerBids.add(player.bid());
        }
        this.bidLog.addRoundBids(this.playerBids);
    }
    
    private Player playOneTrick(){
        int indexOfLeader = players.indexOf(this.playerThatLeads);
        Trick thisTrick = new Trick(players.size(), trump.getSuit());
        for (int ii = 0; ii < players.size(); ii++){ //everyone plays a card
            Player playerToPlay = players.get((indexOfLeader + ii) % players.size()); //playing starts with Leader then goes in a round
            playerToPlay.TricksWonByPlayer(this.tricksTaken); //updates player with who has taken tricks so far
            Card cardPlayed = playerToPlay.playCard(thisTrick); //player chooses which card to play
            thisTrick.playCard(cardPlayed, playerToPlay);
        }
        return thisTrick.getWinner();
        
    }
    
    private List<Boolean> playAllTricks(){
        for (int ii = 0; ii < this.numCardsInRound; ii++){
            
            Player playerThatWon = this.playOneTrick();
            
            this.playerThatLeads = playerThatWon; //leader of next trick is the winner of the previous
            int playerIndex = players.indexOf(playerThatWon);
            tricksTaken.set(playerIndex, tricksTaken.get(playerIndex) + 1); //updates the count of players that have taken a trick
        }
        
        List<Boolean> whoMade = new ArrayList<>();
        for (int ii = 0; ii < this.tricksTaken.size(); ii++){
            if (this.tricksTaken.get(ii) == this.playerBids.get(ii)){
                whoMade.add(true);
            }
            else{
                whoMade.add(false);
            }
        }
        return whoMade;
        
    }
    
    public void doRound(){
        //deal everyone a hand
        this.dealHands();
        //record everyones bids
        this.getBids();
        //play through all the tricks
        List<Boolean> whoMadeList = this.playAllTricks();
        
        assert(whoMadeList.size() == this.playerBids.size());
        
        List<Integer> roundScoreList = new ArrayList<>();
        for (int ii = 0; ii < this.playerBids.size(); ii++){
            if (whoMadeList.get(ii)){
                roundScoreList.add(this.playerBids.get(ii) * 10);
            }
            else{
                roundScoreList.add(this.playerBids.get(ii) * -10);
            }
        }
        
        this.scoreSheet.addRoundScore(roundScoreList);
        
    }
    
    
    

}

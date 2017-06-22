package game_logs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import player.Player;

public class BidLog {
    private final List<Player> playerList;
    private final List<List<Integer>> bidLog = Arrays.asList(new ArrayList<>());
    private final List<Integer> playerCurrentBids = new ArrayList<>();
    
    public BidLog(List<Player> _playerList) {
        this.playerList = _playerList;
        for (int ii = 0; ii < playerList.size(); ii++){
            this.playerCurrentBids.add(0);
        }
    }

    /**
     * Adds all the bids from a round to the game-long bidlog
     * @param playerBids - Index i of playerBids must correspond with the player i of bidLog.getPlayers().get(i)
     */
    public void addRoundBids(List<Integer> playerBids){
        assert playerBids.size() == playerList.size();
        
        bidLog.add(playerBids);
        for (int ii = 0; ii < playerBids.size(); ii++){ //updates the current score of each player
            playerCurrentBids.set(ii, playerCurrentBids.get(ii) + playerBids.get(ii)); 
        }        
    }
    
    public List<Player> getPlayers(){
        return Collections.unmodifiableList(playerList);
    }
    
    public List<List<Integer>> getBidLog(){
        return Collections.unmodifiableList(bidLog);
    }
    
    public List<Integer> getCurrentBids(){
        return Collections.unmodifiableList(playerCurrentBids);
    }
          

}

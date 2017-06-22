package game_logs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import player.Player;

public class ScoreLog {
    private final List<Player> players;
    private final int numRounds;
    private final List<List<Integer>> scoreLog = Arrays.asList(new ArrayList<>());
    private final List<Integer> playerCurrentScores = new ArrayList<>();
    
    private void checkRep(){
        assert scoreLog.size() <= this.numRounds;
    }
    
    public ScoreLog(List<Player> playerList, int _numRounds) {
        this.players = playerList;
        this.numRounds = _numRounds; 
        for (int ii = 0; ii < playerList.size(); ii++){
            this.playerCurrentScores.add(0);
        }
    }

    /**
     * Adds all the scores from a round to the game-long scoresheet
     * @param playerScores - Index i of playerScores must correspond with the player i of ScoreSheet.getPlayers().get(i)
     */
    public void addRoundScore(List<Integer> playerScores){
        assert playerScores.size() == players.size();
        
        scoreLog.add(playerScores);
        for (int ii = 0; ii < playerScores.size(); ii++){ //updates the current score of each player
            playerCurrentScores.set(ii, playerCurrentScores.get(ii) + playerScores.get(ii)); 
        }
        
        checkRep();
    }
    
    public List<Player> getPlayers(){
        return Collections.unmodifiableList(players);
    }
    
    public List<List<Integer>> getScoreLog(){
        return Collections.unmodifiableList(scoreLog);
    }
    
    public List<Integer> getCurrentScores(){
        return Collections.unmodifiableList(playerCurrentScores);
    }
            
}

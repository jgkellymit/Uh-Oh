package game_logs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import player.Player;

public class LeaderLog {
    private final List<Player>leaderLog = new ArrayList<>();
    
    public LeaderLog(List<Player> playerList, int numRounds) {
        for (int ii = 0; ii < numRounds * 2; ii++){
            leaderLog.add(playerList.get(ii % numRounds));
        }
    }
    
    public List<Player> getLeaderLog(){
        return Collections.unmodifiableList(this.leaderLog);
    }
    
    public Player getLeaderForRound(int Round){
        return leaderLog.get(Round);
    }

}

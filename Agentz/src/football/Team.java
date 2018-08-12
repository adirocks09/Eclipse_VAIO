package football;

import java.util.List;
import java.util.Map;

public class Team {

 private String teamName;	
 private List<Player> playerList;
 private int goalCount;
 private Map<Integer,String> goalMap;
 
 public Team(String teamName, List<Player> playerList, int goalCount, Map<Integer, String> goalMap) {
	super();
	this.teamName = teamName;
	this.playerList = playerList;
	this.goalCount = goalCount;
	this.goalMap = goalMap;
}

public String getTeamName() {
	return teamName;
}

 public void setTeamName(String teamName) {
	this.teamName = teamName;
}

public List<Player> getPlayerList() {
	return playerList;
}

public void setPlayerList(List<Player> playerList) {
	this.playerList = playerList;
}

public int getGoalCount() {
	return goalCount;
}

public void setGoalCount(int goalCount) {
	this.goalCount = goalCount;
}

public Map<Integer, String> getGoalMap() {
	return goalMap;
}

public void setGoalMap(Map<Integer, String> goalMap) {
	this.goalMap = goalMap;
}

public Player getPlayer(String playerName){
	for(Player p: playerList){
		if(p.getName().equals(playerName)){
			return p;
		}
	}
	return null;
}

@Override
public String toString() {
	return "Team [teamName=" + teamName + ", playerList=" + playerList + ", goalCount=" + goalCount + ", goalMap="
			+ goalMap + "]";
}

}

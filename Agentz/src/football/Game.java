package football;

import java.io.DataInputStream;
import java.util.Map;

public class Game {
	public static enum State{start,stop,inProgress,end};
	DataInputStream in =new DataInputStream(System.in);
	private Team teamA;
	private Team teamB;
	private State state;
	Thread t;
	public Game(Team teamA, Team teamB) {
		super();
		this.teamA = teamA;
		this.teamB = teamB;
	}
	public void start() throws Exception {
		System.out.println("---------------"+teamA.getTeamName() + "  V/S  "  +teamB.getTeamName() +"---------------");
		state=State.start;
		t=new Thread();
		while(state!=State.end){
			t.sleep(1000); // Ask to update event after every minute
			System.out.println("Do you want to update an event   1.Yes  2. No"); 
			int choice1=Integer.parseInt(in.readLine());
			if (choice1==1){
				System.out.println("Enter choice :");
				System.out.println("1. Add Goal\n"
						+ "2. Stop Game\n"
						+ "3. Resume Game\n"
						+ "4. End Game\n"
						+ "5. Player Injured/Substitue Called\n"
						+ "6. Card Issued\n");
			int choice2=Integer.parseInt(in.readLine());
	        if(choice2 == 1){
				System.out.println("Enter Team Name :");
				String team = in.readLine();
				System.out.println("Enter Player Name :");
				String playerName = in.readLine();
				System.out.println("Enter time :");
				String time = in.readLine();
	        	addGoal(team,playerName,time);
	        }
	        else if(choice2 == 2){
	        	state=State.stop;
	        	System.out.println("Match Stopped");

	        }
	        else if(choice2 == 3){
	        	state=State.inProgress;
	        	System.out.println("Match Resumed");

	        }
	        else if(choice2 == 4){
	        	state=State.end;
	        	System.out.println("Match Ended");
	        	break;
	        }
	        else if(choice2 == 5){
				System.out.println("Enter Team Name :");
				String team = in.readLine();
				System.out.println("Enter Injured Player Name :");
				String injuredPlayer = in.readLine();
				System.out.println("Enter Substitue Player Name :");
				String substituePlayer = in.readLine();
	        	substitue(team,injuredPlayer,substituePlayer);
	        }
	        else if(choice2 == 6){
				System.out.println("Enter Team Name :");
				String team = in.readLine();
				System.out.println("Enter Injured Player Name :");
				String foulPlayer = in.readLine();
				System.out.println("Enter Color of the card : \n"
						+ "R : red\n"
						+ "Y : Yellow\n");
				String color = in.readLine();
	        	issueCard(team,foulPlayer,color);
	        }
			}else{
				continue;
			}
		}
		declareWinner();
	}
	private void declareWinner() {
		if(teamA.getGoalCount()>teamB.getGoalCount()){
			System.out.println("WINNER : "+teamA.getTeamName());
		}
		
		else if (teamA.getGoalCount()<teamB.getGoalCount()){
			System.out.println("WINNER : "+teamB.getTeamName());
		}
		
		else{
			System.out.println("MATCH TIED");
		}
		
		System.out.println("-------MATCH SUMMARY------------");
		System.out.println("Team :"+teamA.getTeamName() + "GOALS : "+ teamA.getGoalCount());
		for(Map.Entry<Integer,String> entry : teamA.getGoalMap().entrySet()){
			System.out.println(entry.getKey()+ " : "+entry.getValue());
		}
		System.out.println("Team :"+teamB.getTeamName()+ "GOALS : "+ teamB.getGoalCount());
		for(Map.Entry<Integer,String> entry : teamB.getGoalMap().entrySet()){
			System.out.println(entry.getKey()+ " : "+entry.getValue());
		}

	}
	private void issueCard(String teamName, String foulPlayerName, String color) {
		Team foulTeam = (teamName.equalsIgnoreCase(teamA.getTeamName()))?teamA:teamB;
		Player foulPlayer = foulTeam.getPlayer(foulPlayerName);
		if(color.equalsIgnoreCase("R")){
			foulPlayer.setRedCard(foulPlayer.getRedCard()+1);
			foulPlayer.setActive(false);
		}
		else if(color.equalsIgnoreCase("Y")){
			foulPlayer.setYellowCard(foulPlayer.getYellowCard()+1);
			if(foulPlayer.getYellowCard()==2){
				foulPlayer.setActive(false);
			}
		}
	}
	private void substitue(String teamName, String injuredPlayerName, String substituePlayerName) {
		Team subTeam = (teamName.equalsIgnoreCase(teamA.getTeamName()))?teamA:teamB;
		Player injuredPlayer = subTeam.getPlayer(injuredPlayerName);
		Player substituePlayer = subTeam.getPlayer(substituePlayerName);
		injuredPlayer.setActive(false);
		substituePlayer.setActive(true);
	}
	private void addGoal(String teamName, String goalPlayerName, String time) {
		Team goalTeam = (teamName.equalsIgnoreCase(teamA.getTeamName()))?teamA:teamB;
		Player goalPlayer = goalTeam.getPlayer(goalPlayerName);
		goalPlayer.setGoalCount(goalPlayer.getGoalCount()+1);
		goalPlayer.getGoalMap().put(goalPlayer.getGoalCount(),time);
		goalTeam.setGoalCount(goalTeam.getGoalCount()+1);
		String keyValue=goalPlayerName+","+time;
		goalTeam.getGoalMap().put(goalTeam.getGoalCount(), keyValue);
	}
	
	
}

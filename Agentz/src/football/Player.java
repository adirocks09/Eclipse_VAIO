package football;

import java.util.Map;

public class Player {

	private String name;
	private int age;
	private boolean isActive;
	private int yellowCard;
	private int redCard;
	private Map<Integer,String> goalMap;
	private int goalCount;
	
	public Player(String name, int age, boolean isActive, int goalCount, int yellowCard, int redCard, Map<Integer, String> goalMap) {
		super();
		this.name = name;
		this.age = age;
		this.isActive = isActive;
		this.goalCount= goalCount;
		this.yellowCard = yellowCard;
		this.redCard = redCard;
		this.goalMap = goalMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getGoalCount() {
		return goalCount;
	}

	public void setGoalCount(int goalCount) {
		this.goalCount = goalCount;
	}

	public int getYellowCard() {
		return yellowCard;
	}

	public void setYellowCard(int yellowCard) {
		this.yellowCard = yellowCard;
	}

	public int getRedCard() {
		return redCard;
	}

	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}

	public Map<Integer, String> getGoalMap() {
		return goalMap;
	}

	public void setGoalMap(Map<Integer, String> goalMap) {
		this.goalMap = goalMap;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", isActive=" + isActive + ", yellowCard=" + yellowCard
				+ ", redCard=" + redCard + ", goalMap=" + goalMap + ", goalCount=" + goalCount + "]";
	}

	
}

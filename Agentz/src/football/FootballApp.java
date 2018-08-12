package football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FootballApp {

	public static void main(String[] args) {
		
		Player a1= new Player("Ronaldo", 25, true, 0, 0, 0, new HashMap<Integer,String>());
		Player a2= new Player("Bale", 20, true, 0, 0, 0, new HashMap<Integer,String>());
		Player a3= new Player("Ramos", 21, true, 0, 0, 0, new HashMap<Integer,String>());
		
		Player b1= new Player("Messi", 23, true, 0, 0, 0, new HashMap<Integer,String>());
		Player b2= new Player("Suarez", 21, true, 0, 0, 0, new HashMap<Integer,String>());
		Player b3= new Player("Samuel", 19, true, 0, 0, 0, new HashMap<Integer,String>());
		
		List<Player> realMadridPlayerList = new ArrayList<Player>();
		realMadridPlayerList.add(a1);
		realMadridPlayerList.add(a2);
		realMadridPlayerList.add(a3);

		List<Player> barcelonaPlayerList = new ArrayList<Player>();
		barcelonaPlayerList.add(b1);
		barcelonaPlayerList.add(b2);
		barcelonaPlayerList.add(b3);
		
		Team realMadrid = new Team("Real Madrid", realMadridPlayerList, 0, new HashMap<Integer,String>());
		Team barcelona = new Team("Barcelona", barcelonaPlayerList, 0, new HashMap<Integer,String>());
		
		Game elClassico = new Game(realMadrid,barcelona);
		try {
			elClassico.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class CompartorTest {
	
	public static void main(String[] args) {
		
		List<SoccerPlayer> playerList = new ArrayList<SoccerPlayer>();
		
		SoccerPlayer p1 = new SoccerPlayer("messi","fw",  21);
		SoccerPlayer p2 = new SoccerPlayer("fessi","frw", 233);
		SoccerPlayer p3 = new SoccerPlayer("ressi","gtw", 53);
		SoccerPlayer p4 = new SoccerPlayer("zessi","qrw", 63);
		
		playerList.add(p1);
		playerList.add(p2);
		playerList.add(p3);
		playerList.add(p4);
		
		
//		Collections.sort(playerList);
		Collections.sort(playerList, new Comparator<SoccerPlayer>() {
			
			
			@Override
			public int compare(SoccerPlayer p1, SoccerPlayer p2) {
				// TODO Auto-generated method stub
				
				if(p1.getAge() >p2.getAge()) {
					return 1;
				}else if(p1.getAge() < p2.getAge()) {
					return -1;
				}else {
					return 0;
				}
			
			}

				
				
		});
		
		for(int i =0 ; i< playerList.size(); i++) {
			System.out.println(playerList.get(i) +" "+playerList.get(i).getName());
		}
		
		
	}

}


class SoccerPlayer  {
//class SoccerPlayer implements Comparable<SoccerPlayer> {
	
	private String name;
	private String posion;
	private int age;
	
	public SoccerPlayer(String name, String position, int age) {
		this.name = name;
		this.posion = position;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return this.posion;
	}
	public void setPosition(String pos) {
		this.posion = pos;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}

	
}

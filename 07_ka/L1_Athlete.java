package real;

import java.util.*;

public class L1_Athlete {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = { "kiki", "eden"};
	}
	public String solution(String[] participant, String[] completion) {
	    
		String answer = "";
	    Map<String, Integer> hm = new HashMap<>();
	    
	    for(String player: participant)
	    	hm.put(player, hm.getOrDefault(player, 0)+1);
	    
	    for(String player: completion)
	    	hm.put(player, hm.get(player)-1);
	    
	    for(String key : hm.keySet()) {
	    	if(hm.get(key) != 0) {
	    		answer=key;
	    	}
	    }
	    
	    return answer;
	
	}
}

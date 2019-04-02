package test;

import java.util.*;

public class L2_Cloth_map {

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		L2_Cloth_map a = new L2_Cloth_map();
		System.out.println(a.solution(clothes));
		
	}
	 public int solution(String[][] clothes) {
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	 
	        for (int i = 0; i < clothes.length; i++) {
	            if (map.containsKey(clothes[i][1]))
	                map.replace(clothes[i][1], map.get(clothes[i][1])+1);
	            else
	                map.put(clothes[i][1], 1);
	        }
	 
	        int answer = 1;
	        for (int value : map.values()) {
	            answer*=(value+1);
	        }
	        answer-=1;
	 
	        return answer;
	    }
}

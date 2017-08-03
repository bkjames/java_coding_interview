package Hashing;

import java.util.*;

public class Anagrams {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("dog");
		list.add("god");
		list.add("tac");
		
		System.out.println(anagrams(list));
	}

	
	public static ArrayList<ArrayList<Integer>> anagrams(List<String> list){
		
		HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			
			char[] charArray =  list.get(i).toCharArray();
			Arrays.sort(charArray);
			String str = new String(charArray);
			
			if(hashMap.get(str)== null){
				ArrayList<Integer> intList = new ArrayList<>();
				intList.add(i+1);
				hashMap.put(str, intList);
			}else{
				hashMap.get(str).add(i+1);
			}
		}
		
		for(ArrayList<Integer> val : hashMap.values()){
			result.add(val);
		}
		
		return result;
		
		
		
	}
}

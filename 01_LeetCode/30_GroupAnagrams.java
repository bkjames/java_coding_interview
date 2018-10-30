package code02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		String[] strArr =  {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strArr));
	}
	
	public static List<List<String>> groupAnagrams(String[] strs){
		List<List<String>>  result = new ArrayList<>();
		
		Map<String, ArrayList<String>> map = new HashMap<>();
		for(String str : strs) {
			char[] arr = new char[26];
			for(int i=0; i<str.length(); i++) {
				arr[str.charAt(i)-'a']++;
			}
			String ns = new String(arr);
			System.out.println("ns: "+ns);
			
			if(map.containsKey(ns)) {
				map.get(ns).add(str);
			}else {
				ArrayList<String> al = new ArrayList<>();
				al.add(str);
				map.put(ns, al);
			}
		}
		result.addAll(map.values());
		return result;
	}

}

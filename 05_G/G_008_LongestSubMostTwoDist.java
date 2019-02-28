package zGoo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist {


	public static void main(String[] args) {
		String s = "eceba";
//		String s = "aaccaabb";
		int k = 1;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}
	
	public int lengthOfLongestSubstringKDistinct2(String s, int k) {
	    if ( s == null|| s.length() == 0)
	      return 0;
	    
	    int ret  = 0;
	    Map<Character, Integer> map  = new HashMap<>();
	    // the left boundary or start index of each possible substring 
	    // containing at most k distinct characters   
	    int left = 0; 

	    for (int i = 0; i < s.length(); i++)
	    {
	        char visiting = s.charAt(i);
	        if (!map.containsKey(visiting))
	        {
	            map.put(visiting, 0);
	        }
	        map.put(visiting, map.get(visiting) + 1);
	        
	        while (map.size() > k)
	        {
	            char c = s.charAt(left++);
	            map.put(c, map.get(c) - 1);
	            if (map.get(c) == 0)
	            {
	                map.remove(c);
	            }
	        }
	        
	        ret = Math.max(ret, i - left + 1);
	    }
	    
	    return ret;
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
     
		if (k <= 0) return 0;

		if (s.length() <= k)  return s.length();
        
        
        HashMap<Character, Integer> charMap = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        
        while (end < s.length()  && ((s.length() - start + 1) > maxLen)) {
            Character c = s.charAt(end);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
//            if (!charMap.containsKey(c)) {
//                charMap.put(c, 1);
//            } else {
//                charMap.put(c, charMap.get(c) + 1);
//            }
            
            if (charMap.size() > k) {
                
                // Remove characters from string until constraint is met
                while (charMap.size() > k && start < end) {
                    Character startChar = s.charAt(start);
                    if (charMap.get(startChar) == 1) {
                        charMap.remove(startChar);
                    } else {
                        charMap.put(startChar, charMap.get(startChar) - 1);
                    }
                    
                    start++;
                }
            }
            
            if ((end - start + 1) > maxLen) {
                maxLen = (end - start + 1);
            }
            
            end++;
        }
        
        return maxLen;
    }
	
//	    public int lengthOfLongestSubstringTwoDistinct(String s) {
//	        Map<Character,Integer> map = new HashMap<>();
//	        int start = 0, end = 0, counter = 0, len = 0;
//	        while(end < s.length()){
//	            char c = s.charAt(end);
//	            map.put(c, map.getOrDefault(c, 0) + 1);
//	            if(map.get(c) == 1) counter++;//new char
//	            end++;
//	            while(counter > 2){
//	                char cTemp = s.charAt(start);
//	                map.put(cTemp, map.get(cTemp) - 1);
//	                if(map.get(cTemp) == 0){
//	                    counter--;
//	                }
//	                start++;
//	            }
//	            len = Math.max(len, end-start);
//	        }
//	        return len;
//	    }
	
}

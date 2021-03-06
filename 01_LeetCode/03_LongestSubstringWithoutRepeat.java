package zz05;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
	public static void main(String[] args) {
//		String str = "abcabcdbb";
		String str = "pwwkew";
		System.out.println(longestSub(str));
	}
	
	//java sliding window
      public static int lengthOfLongestSubstring2(String s) {
	        Queue<Character> queue = new LinkedList<>();
	        int res = 0;
	        for (char c : s.toCharArray()) {
	            while (queue.contains(c)) {
	                queue.poll();
	            }
	            queue.offer(c);
	            res = Math.max(res, queue.size());
	        }
	        return res;
	    }
	
	
	public static int lengthOfLongestSubstring(String s) {
	        
	        int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int ans =0, i=0, j=0;
	        
	        while(i<n && j<n){
	            
	            if( ! set.contains(s.charAt(j))){
	                set.add(s.charAt(j++));
	                ans = Math.max(ans, j-i);
	            }else{
	                
	                set.remove(s.charAt(i++));
	            }
	        }
	        return ans;
	    }
	
	
	
	
  public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
	
	
	
	public static int  longestSub(String s) {
		if(s==null || s.length()==0) return 0;
		
		int result =0;
		int k =0;
		HashSet<Character> set = new HashSet<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!set.contains(c)) {
				set.add(c);
				result = Math.max(result, set.size());
			}else {
				while(k<i) {
					if(s.charAt(k) ==c) {
						k++;
						break;
					}else {
						set.remove(s.charAt(k));
						k++;
					}
				}
			}
		}
		return result;
	}
}


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int head = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) + 1 > head) {
                	//	make sure head does not travel back
                    head = map.get(c) + 1;
                }
            }
           
            map.put(c, i);		
            String str = s.substring(head, i + 1);
            max = Math.max(max, str.length());
        }
        
        return max;
    }
}

/********************************The other way********************************************************/

public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
}

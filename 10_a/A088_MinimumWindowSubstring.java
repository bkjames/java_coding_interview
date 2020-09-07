package ama001;

import java.util.HashMap;
import java.util.Map;

public class A088_MinimumWindowSubstring {

	public static void main(String[] args) {
		
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s,t));
	}
	
	
    public static String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        while(end < s.length()){
            char c = s.charAt(end);
            System.out.println("c: "+c);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                System.out.println("tempc: "+tempc);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    System.out.println("len: "+len+" end: "+end+" begin: "+begin+" head: "+head);
                    head = begin;
                }
                System.out.println("substring begin: "+begin+ " end: "+end);
                begin++;
                
            }
           
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}
//
//	public static String minWindow(String s, String t) {
//	    if(s == null || s.length() < t.length() || s.length() == 0){
//	        return "";
//	    }
//	    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//	    for(char c : t.toCharArray()){
//	        if(map.containsKey(c)){
//	            map.put(c,map.get(c)+1);
//	        }else{
//	            map.put(c,1);
//	        }
//	    }
//	    int left = 0;
//	    int minLeft = 0;
//	    int minLen = s.length()+1;
//	    int count = 0;
//	    for(int right = 0; right < s.length(); right++){
//	        if(map.containsKey(s.charAt(right))){
//	            map.put(s.charAt(right),map.get(s.charAt(right))-1);
//	            if(map.get(s.charAt(right)) >= 0){
//	                count ++;
//	            }
//	            while(count == t.length()){
//	                if(right-left+1 < minLen){
//	                    minLeft = left;
//	                    minLen = right-left+1;
//	                }
//	                if(map.containsKey(s.charAt(left))){
//	                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
//	                    if(map.get(s.charAt(left)) > 0){
//	                        count --;
//	                    }
//	                }
//	                left ++ ;
//	            }
//	        }
//	    }
//	    if(minLen>s.length())  
//	    {  
//	        return "";  
//	    }  
//	    
//	    return s.substring(minLeft,minLeft+minLen);
//	}
//	
//	
//	 public String minWindow(String S, String T) {
//	        Map<Character, Integer> pattern = new HashMap<Character, Integer>();
//	        Map<Character, Integer> cur = new HashMap<Character, Integer>();
//	        Queue<Integer> queue = new LinkedList<Integer>();
//	        int min = Integer.MAX_VALUE;
//	        int begin = 0, end = 0;
//	        
//	        // fill in pattern by T
//	        for(int i = 0;i < T.length();i++) addToMap(pattern, T.charAt(i));
//	        
//	        // initialize current set
//	        for(int i = 0;i < T.length();i++) cur.put(T.charAt(i), 0);
//	        
//	        // go through S to match the pattern by minimum length
//	        for(int i = 0;i < S.length();i++){
//	            if(pattern.containsKey(S.charAt(i))){
//	                queue.add(i);
//	                addToMap(cur, S.charAt(i));
//	                // check if pattern is matched
//	                while(isMatch(pattern, cur)){  /* Important Code! */
//	                    if(i - queue.peek() < min){
//	                        min = i - queue.peek();
//	                        begin = queue.peek();
//	                        end = i+1;
//	                    }
//	                    cur.put(S.charAt(queue.peek()), cur.get(S.charAt(queue.peek()))-1);
//	                    queue.poll();
//	                }
//	            }
//	        }
//	        
//	        return end > begin?S.substring(begin, end):"";
//	    }
//	    
//	    private void addToMap(Map<Character, Integer> map, Character c){
//	        if(map.containsKey(c))
//	            map.put(c, map.get(c)+1);
//	        else
//	            map.put(c,1);
//	    }
//	    
//	    private boolean isMatch(Map<Character, Integer> p, Map<Character, Integer> cur){
//	        for(Map.Entry<Character, Integer> entry: p.entrySet())
//	            if(cur.get((char)entry.getKey()) < (int)entry.getValue()) return false;
//	        return true;
//	    }
//}


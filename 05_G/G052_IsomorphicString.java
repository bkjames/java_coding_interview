package zGoo1;

import java.util.*;
public class G052_IsomorphicString {
	
	public static void main(String[] args) {
		String s1 = "foo", s2 = "dda";
		System.out.println(isIsomorphic3(s1, s2));
	}
	
	public static boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
        	System.out.println(s1.charAt(i)+" "+s2.charAt(i));
        	System.out.println(m[s1.charAt(i)]+" "+(s2.charAt(i)+256));
            System.out.println("ascii "+(int)s1.charAt(i)+" "+(int)s2.charAt(i));
        	if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) {
        		return false;
        	}
           
        	m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
	
	public static boolean isIsomorphic3(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        for(Integer i = 0; i < s1.length(); i++) {

            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
            	System.out.println(m1.put(s1.charAt(i), i)+" "+m2.put(s2.charAt(i), i));
                return false;
            }
        }
        return true;
    }
	
	
	public boolean isIsomorphic2(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
        
    }

}

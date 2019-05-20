package Top50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T30_LetterCombinations {

	public static void main(String[] args) {
		String str = "23";
		List<String> val = letterCombinations_dfs(str);
		
		for(int i=0; i<val.size(); i++) {
			System.out.println(val.get(i));
		}
		
	}
	
	//3
		public static void DFS(String digits, List<String> result, StringBuffer s, int start,HashMap<Integer, String> map) {
				
				System.out.println(" s: "+s);
				if (start == digits.length())
					result.add(s.toString());
				else {
					String tmp = map.get(digits.charAt(start) - '0');
					for (int i = 0; i < tmp.length(); i++) {
						System.out.println(" 2s: "+s);
						s.append(tmp.charAt(i));
						DFS(digits, result, s, start + 1, map);
						s.deleteCharAt(s.length() - 1);
					}
				}
				System.out.println("end=====");
		}

		public static List<String> letterCombinations_dfs(String digits) {
			if (digits == null || digits.length() == 0)
				return new ArrayList<String>();
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			map.put(0, "");
			map.put(1, "");
			map.put(2, "abc");
			map.put(3, "def");
			map.put(4, "ghi");
			map.put(5, "jkl");
			map.put(6, "mno");
			map.put(7, "pqrs");
			map.put(8, "tuv");
			map.put(9, "wxyz");
			List<String> result = new ArrayList<String>();
			StringBuffer s = new StringBuffer();
			DFS(digits, result, s, 0, map);
			return result;
		}
	
	//1
	 private static String flatPad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	    
	    private static List<String> combine_1(String str, List<String> list) {
	        List<String> res = new ArrayList<>();
	        
	        char[] chr = str.toCharArray();
	        for (char c : chr) {
	            for (String s : list) {
	                res.add(s+c);
	            }
	        }
	        return res;       
	    }
	    
	    public static List<String> letterCombinations_1(String digits) {
	        List<String> ans = new ArrayList<>();
	        if (digits == null || digits.length() == 0) return ans;
	        
	        ans.add("");
	        int size = digits.length();
	        for (int i = 0; i < size; i++) {
	            ans = combine_1(flatPad[digits.charAt(i)-'0'], ans);
	        }
	        return ans;
	    }
	
	//1
	 public static List<String> letterCombinations2(String digits) {
         String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
         List<String> result = new ArrayList<String>();
 
         if (digits.length()==0) return result;
         
         result.add("");
         for (int i=0; i<digits.length(); i++) {
        	 System.out.println(digitletter[digits.charAt(i)-'0']);
             result = combine(digitletter[digits.charAt(i)-'0'],result);
         }
         
         return result;
     }
     
     public static List<String> combine(String digit, List<String> l) {
         List<String> result = new ArrayList<String>();
         
         for (int i=0; i<digit.length(); i++) 
             for (String x : l) {
            	 System.out.println("x: "+x);
                 result.add(x+digit.charAt(i));
             }
 
         return result;
     }
	
     
	
	//2
	public static List<String> letterCombinations3(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		while(ans.peek().length()!=digits.length()){
			String remove = ans.remove();
			String map = mapping[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				ans.addLast(remove+c);
			}
		}
		return ans;
	}
	
	
	
	 
	
	
//	public static List<String> letterCombinations(String digits) {
//        List<String> list = new LinkedList<>();
//        if(digits == null || digits.length() == 0) return list;
//        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
//        backtrack(digits,list,map,new StringBuilder(),0);
//        return list;
//    }
//	
//	
//	
//    private static void backtrack(String digits, List<String> list,char[][] map, StringBuilder sb, int start){
//        if(start == digits.length()) {
//            list.add(new String(sb));
//            return;
//        }
//        int num = digits.charAt(start) - '0';
//        for(int i = 0;i< map[num].length;i++){
//            sb.append(map[num][i]);
//            backtrack(digits,list,map,sb,start+1);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//    }
}

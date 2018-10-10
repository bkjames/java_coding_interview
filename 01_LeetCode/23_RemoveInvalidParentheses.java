package aExe07;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenteses {
	public static void main(String[] args) {
		
//		 String expression = "()())()"; 
		 String expression = "(a)())()";
		 System.out.println(removeInvalidParentheses(expression)); 
	}
	
	
	
	public static List<String> removeInvalidParentheses(String s) {
        List<String> rst = new ArrayList<>();
        int invalidL = 0, invalidR = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
       
            if (count < 0) {
                invalidR++;
                count = 0;
            }
        }
        invalidL = count;

        dfs(s, 0, invalidL, invalidR, rst);
        return rst;
    }

    private static void dfs(String s, int index, int invalidL, int invalidR, List<String> rst) {
        if (invalidL == 0 && invalidR == 0) {
         
            if (isValid(s)) {
                rst.add(s);
                return;
            }
        }

        for (int i = index; i < s.length(); i++) {
        
            if (i > index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == ')' && invalidR > 0) {
            
                String nextString = s.substring(0, i) + s.substring(i + 1);
                dfs(nextString, i, invalidL, invalidR - 1, rst);
            }
            if (s.charAt(i) == '(' && invalidL > 0) {
              
                String nextString = s.substring(0, i) + s.substring(i + 1);
                dfs(nextString, i, invalidL - 1, invalidR, rst);
            }
        }
    }


    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}

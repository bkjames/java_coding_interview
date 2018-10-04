package zz04;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
	
	public static List<String> generateParenthesis(int n) {
	    ArrayList<String> result = new ArrayList<String>();
	    dfs(result, "", n, n);
	    return result;
	}
	/*
	left and right represents the remaining number of ( and ) that need to be added. 
	When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops. 
	*/
	public static void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right)
	        return;
	 
	    if(left==0&&right==0){
	    	 System.out.println("s: "+s);
	        result.add(s);
	        return;
	    }
	    
//	    System.out.println("left: "+left+" right: "+right);
	    if(left>0){
	    	System.out.println("left: "+left+" right: "+right+" left>0 s: "+s);
	        dfs(result, s+"(", left-1, right);
	       
	    }
	 
	    if(right>0){
	    	System.out.println("left: "+left+" right: "+right+" right>0 s: "+s);
	        dfs(result, s+")", left, right-1);
	        
	    }
	}

}

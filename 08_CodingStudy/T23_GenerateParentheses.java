package Top50;
import java.util.*;
public class T23_GenerateParentheses {

	
	public static void main(String[] args) {
		T23_GenerateParentheses a = new T23_GenerateParentheses();
//		System.out.println(a.generateParenthesis_backTrac(3));
		System.out.println(a.generateParenthesis_dfs(3));
	}
	
	  int count =0;
	  public List<String> generateParenthesis_dfs(int n) {
	        List<String> res = new ArrayList<>();
	        dfs(res, "", n, n);
	        return res;
	    }
	    
	    private void dfs(List<String> list, String str, int left, int right) {
	     	count++;
	    	System.out.println("str\t"+str+"\t left: "+left+" right: "+right+" count: "+count);
	    	
	        if (left < 0 || left > right) {
	            return;
	        }
//	        System.out.println("str: "+str);
	        System.out.println("=str\t"+str+"\t left: "+left+" right: "+right+" count: "+count);
	        if (left == 0 && right == 0) {
	            list.add(str);
	            return;
	        }
	        dfs(list, str + '(', left - 1, right);
	        dfs(list, str + ')', left, right - 1);
	    }
	    
	    
	public List<String> generateParenthesis_backTrac(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
	
    public void backtrack(List<String> list, String str, int open, int close, int max){
    	count++;
    	System.out.println("str\t"+str+"\t open: "+open+" close: "+close+" max: "+max+" count: "+count);
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max) {
        	System.out.println("open < max:\t "+open+" \t"+ max);
            backtrack(list, str+"(", open+1, close, max);
        }
        if(close < open) {
        	System.out.println("close < open:\t "+close+" \t"+ open);
            backtrack(list, str+")", open, close+1, max);
        }
        System.out.println("end=========str\t"+str+"\t open: "+open+" close: "+close+" max: "+max);
    }
}

package test;
import java.util.*;

public class L2_BaseBall {

	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		L2_BaseBall a = new L2_BaseBall();
		
		System.out.println(a.solution(baseball));
		
	}
	    public static int solution(int[][] baseball) {
	        Stack<String> stack = new Stack<>();
	        for(int i = 1; i < 10; i++) {
	            for(int j = 1; j < 10; j++) {
	                for(int k = 1; k < 10; k++) {
	                    if(i != j && j != k && i != k) {
	                        stack.add(String.valueOf(i * 100 + j * 10 + k));
	                    }
	                }
	            }
	        }
        Stack<String> temp = new Stack<>();
        boolean result = true;
        while(!stack.isEmpty()) {
            String num = stack.pop();
            for(int i = 0; i < baseball.length && result; i++) {
                int strike = strike(num, String.valueOf(baseball[i][0]));
                int ball = ball(num, String.valueOf(baseball[i][0])) - strike;
                if(strike != baseball[i][1] || ball != baseball[i][2]) {
                	result = false;
                }
            }
            if(result) {
                temp.add(num);
            }
            result = true;
        }
        return temp.size();
    }
     
	    public static int strike(String num, String target) {
	        int cnt = 0;
	        for(int i = 0; i < target.length(); i++) {
	            cnt = num.charAt(i) == target.charAt(i) ? cnt + 1 : cnt;
	        }
	        return cnt;
	    }
	     
	    public static int ball(String num, String target) {
	        int cnt = 0;
	        for(int i = 0; i < target.length(); i++) {
	            cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt + 1 : cnt;
	        }
	        return cnt;
	    }
	
}

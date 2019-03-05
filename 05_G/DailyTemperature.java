package TopG100;

import java.util.Stack;


public class DailyTemperature {

	public static void main(String[] args) {
		int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		dailyTemperatures(nums);
	}
	public static int[] dailyTemperatures(int[] temperatures) {
	    Stack<Integer> stack = new Stack<>();
	    int[] ret = new int[temperatures.length];
	    for(int i = 0; i < temperatures.length; i++) {
	    	System.out.println(temperatures[i]);
	        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	        	System.out.println("b: "+temperatures[i]);
	            int index = stack.pop();
	            System.out.println("index: "+index);
	            ret[index] = i - index;
	        }
	        stack.push(i);
	    }
	    return ret;
	}
}

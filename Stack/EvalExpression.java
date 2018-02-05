package stack;

import java.util.*;

public class EvalTest01 {
	
	
	public static void main(String[] args) {
		
		ArrayList<String> listStr = new ArrayList<>();
		listStr.add("2");
		listStr.add("5");
		listStr.add("+");
		listStr.add("3");
		listStr.add("*");
		
		System.out.println(eval(listStr));
	}
	
	public static String eval(ArrayList<String> list){
		
		Stack<String> stack = new Stack<String>();
		String operators = "+-*/";
		
		for(int i=0 ; i<list.size(); i++){
			
			String str = list.get(i);
			
			if(!operators.contains(str)){
				
				stack.push(str);
			}else{
				
				int x = Integer.parseInt(stack.pop());
				int y = Integer.parseInt(stack.pop());
				
				int index = operators.indexOf(str);
				
				switch(index){
				
					case 0: stack.push(String.valueOf(x+y));
					break;
					
					case 1: stack.push(String.valueOf(y-x));
					break;
					
					case 2: stack.push(String.valueOf(x*y));
					break;
					
					case 3: stack.push(String.valueOf(y/x));
					break;
				
				}
				
			}
		}
		
		return String.valueOf(stack.peek());
		
	}
}

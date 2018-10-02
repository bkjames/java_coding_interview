package zz01;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		String exp ="{[)";
//		String exp = "{()}[]";
		System.out.println(isValid(exp));
	}
	
	public static boolean isValid(String str) {
		Map<Character, Character> map = new HashMap<>();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0 ; i< str.length(); i++) {
			char curr = str.charAt(i);
			if(map.keySet().contains(curr)) {
				stack.push(curr);
			}else if(map.values().contains(curr)) {
				if(!stack.empty() && stack.peek()== curr) {
					stack.pop();
				}else {
					return false;
				}
				
			}
		}
		return stack.empty();
		
	}

}



public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}

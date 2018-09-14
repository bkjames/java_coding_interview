package stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class ValidParethesis {
	
	public static void main(String[] args) 
    {
//        char exp[] = {'{','(',')','}','[',']'};
        
        String exp = "{()}[]";
          if (isValid(exp))
            System.out.println("Balanced ");
          else
            System.out.println("Not Balanced ");  
    }

	
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}
}

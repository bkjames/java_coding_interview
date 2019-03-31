package real;

import java.util.*;

public class StoneStick {

	public static void main(String[] args) {
		String str =  "()(((()())(())()))(())";
		System.out.println(solution(str));
	}
	public static int solution(String arrangement) {
        String arrArray = arrangement.replace("()", "0");
        int answer = 0;
        
        ArrayList<Character> newArray = new ArrayList<Character>();
        
        for(int i = 0; i < arrArray.length(); i++){ 
        	newArray.add(arrArray.charAt(i)); }
        
        ArrayList<Character> stack = new ArrayList<Character>();
        
        for(int i = 0; i < newArray.size(); i++){
            if(newArray.get(i) == '('){
                stack.add(newArray.get(i));
            }else if(newArray.get(i) == ')'){
                stack.remove(stack.size()-1);
                answer += 1;
            }else if(newArray.get(i) == '0'){
                answer += stack.size();
            }
        }
        return answer;
    }
	
	 public static int solution3(String arrangement) {
	        int answer = 0;
	        Stack<Integer> st = new Stack<>();
	        for (int i = 0; i < arrangement.length(); i++) {
	            if (arrangement.charAt(i) == '(') {
	                st.push(i);
	            } else if (arrangement.charAt(i) == ')') {
	                if (st.peek() + 1 == i) {
	                    st.pop();
	                    answer += st.size();
	                } else {
	                    st.pop();
	                    answer += 1;
	                }
	            }
	        }
	        return answer;
	    }
	 
	 
	
	 public int solution2(String arrangement) {

	        String replacedArrangement = arrangement.replaceAll("\\(\\)", "O");
	        Deque<Character> stack = new ArrayDeque<Character>();

	        char[] arrangementChar = replacedArrangement.toCharArray();
	        int pipeCount = 0;

	        for (int i=0;i<arrangementChar.length;i++) {
	            char value = arrangementChar[i];
	            switch (value) {
	                case '(':
	                    stack.addLast(value);
	                    pipeCount += 1;
	                    break;
	                case ')':
	                    stack.pop();
	                    break;
	                case 'O':
	                    pipeCount += stack.size();
	                    break;
	                default:
	                    break;
	            }
	        }

	        return pipeCount;

	    }
}

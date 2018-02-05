package stack;

import java.util.ArrayList;
import java.util.Stack;

public class EvalExpression {

	    public int evalRPN(String[] tokens) {
	 
	        int returnValue = 0;
	 
	        String operators = "+-*/";
	 
	        Stack<String> stack = new Stack<String>();
	 
	        for(String t : tokens){
	            if(!operators.contains(t)){
	            	System.out.println("t: "+t);
	                stack.push(t);
	            }else{
	                int a = Integer.valueOf(stack.pop());
	                int b = Integer.valueOf(stack.pop());
	                int index = operators.indexOf(t);
	                switch(index){
	                    case 0:
	                        stack.push(String.valueOf(a+b));
	                        break;
	                    case 1:
	                        stack.push(String.valueOf(b-a));
	                        break;
	                    case 2:
	                        stack.push(String.valueOf(a*b));
	                        break;
	                        
	                        
	                    case 3:
	                        stack.push(String.valueOf(b/a));
	                        break;
	                }
	            }
	        }
	 
	        returnValue = Integer.valueOf(stack.pop());
	 
	        return returnValue;
	 
	    }
	    
	    public static void main(String[] args){
//	        ArrayList<String> expression = new ArrayList<String>();
//	        expression.add("5");
//	        expression.add("1");
//	        expression.add("2");
//	        expression.add("+");
//	        expression.add("4");
//	        expression.add("*");
//	        expression.add("+");
//	        expression.add("3");
//	        expression.add("-");
	        
	        String[] tokens = {"2", "8", "+", "3", "*"} ;
//	        String[] tokens = {"4", "13", "5", "/", "+"};
	        
//	        ["4", "13", "5", "/", "+"] 
	        EvalExpression eval = new EvalExpression();
	        int val = eval.evalRPN(tokens);
	        System.out.println(val);
//	        System.out.println(evalRPN(expression));
	    }
	}

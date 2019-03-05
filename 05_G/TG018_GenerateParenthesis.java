package zGoo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	static int count=0;

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
	public static List<String> generateParenthesis(int n) {
	    List<String> list = new ArrayList<String>();
	    generateOneByOne("", list, n, n);
	    return list;
	}
	public static void generateOneByOne(String sublist, List<String> list, int left, int right){
		
		System.out.println(sublist+"     left: "+left+"  right: "+right);
	    if(left > right){
	    	System.out.println("Big left: "+left+"  right: "+right);
	        return;
	    }
	    if(left > 0){
	        generateOneByOne( sublist + "(" , list, left-1, right);
	    }
	    if(right > 0){
	        generateOneByOne( sublist + ")" , list, left, right-1);
	    }
	    if(left == 0 && right == 0){
	        list.add(sublist);
	        return;
	    }
	    count++;
	    System.out.println("======="+left+" "+right+"        "+count);
	}
}
	

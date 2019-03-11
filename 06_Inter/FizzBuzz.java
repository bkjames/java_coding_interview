package Inter;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		int n = 15;
		System.out.println(fizzBuzz(n));
	}
	 public static List<String> fizzBuzz(int n) {
	        List<String> ret = new ArrayList<String>(n);
	        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
	            fizz++;
	            buzz++;
	            if(fizz==3 && buzz==5){
	                ret.add("FizzBuzz");
	                fizz=0;
	                buzz=0;
	            }else if(fizz==3){
	                ret.add("Fizz");
	                fizz=0;
	            }else if(buzz==5){
	                ret.add("Buzz");
	                buzz=0;
	            }else{
	                ret.add(String.valueOf(i));
	            }
	        } 
	        return ret;
	    }
	 
	 
	 public List<String> fizzBuzz2(int n) {
	        List<String> list = new ArrayList<>();
	        for (int i = 1; i <= n; i++) {
	            if (i % 3 == 0 && i % 5 == 0) {
	                list.add("FizzBuzz");
	            } else if (i % 3 == 0) {
	                list.add("Fizz");
	            } else if (i % 5 == 0) {
	                list.add("Buzz");
	            } else {
	                list.add(String.valueOf(i));
	            }
	        }
	        return list;
	    }
}

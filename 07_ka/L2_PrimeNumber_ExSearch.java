package test;
import java.util.*;

public class L2_PrimeNumber {

	public static void main(String[] args) {
		L2_PrimeNumber a = new L2_PrimeNumber();
		String numbers = "17";
		System.out.println(solution(numbers));
	}
	 public static boolean[] prime() {
	        boolean[] primes = new boolean[10000000];
	        primes[0] = primes[1] = true;
	        for(int i = 2; i < primes.length; i++) {
	            if(!primes[i]) {
	                for(int j = 2; j * i < primes.length; j++) {
	                    primes[j * i] = true;
	                }
	            }
	        }
	         
	        return primes;
	    }
	     
	    public static int solution(String numbers) {
	        int answer = 0;
	        int[] arr = new int[numbers.length()];
	        for(int i = 0; i < arr.length; i++) 
	            arr[i] = numbers.charAt(i) - '0';
	         
	        Set<Integer> set = new HashSet<>();
	        for(int i = 1; i <= arr.length; i++) 
	            permutation(set, arr, 0, i);
	         
	        boolean[] primes = prime();
	        for(int num : set) {
	            answer = primes[num] ? answer : answer + 1;
	        }
	        return answer;
	    }
	     
	    public static void permutation(Set<Integer> set, int[] arr, int index, int r){
	        if(index == r){
	            set.add(createInteger(arr, r));
	        } else {
	            for(int i = 0; i + index < arr.length; i++){
	                swap(arr, index, index + i);
	                permutation(set, arr, index + 1, r);
	                swap(arr, index, index + i);
	            }   
	        }
	    }
	 
	    public static void swap(int[] arr, int a, int b){
	        int temp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }
	     
	    public static int createInteger(int[] arr, int r) {
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < r; i++) 
	            sb.append(arr[i]);
	         
	        return Integer.parseInt(sb.toString());
	    }
	
	
	
}

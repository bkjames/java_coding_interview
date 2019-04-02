package test;

import java.util.Arrays;

public class Hindex {

	
		public static int solution(int[] citations) {
	        int answer = 0;
	        Arrays.sort(citations);
	        for(int i = citations.length - 1; i >= 0; i--) {
	        	System.out.println(citations[i]+" "+answer);
	        	if(citations[i] < answer) 
	        		return answer;
	        	
	        	answer++;
	        }
	        
	        return answer;
	    }

		public static void main(String[] args) {
			int[] arr = {3, 0,6,1,5};
			System.out.println(solution(arr));
			
			int[] arr2 = {0, 0, 0, 0};
			System.out.println(solution(arr2));
		}

}

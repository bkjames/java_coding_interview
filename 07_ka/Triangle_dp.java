package prog;

public class Triangle {

	public static void main(String[] args) {
		
		int[][] nums = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		Triangle a = new Triangle();
		System.out.println(a.solution(nums));
	}
	
	public int solution(int[][] triangle) {
	     // 1. 기본값 초기화  //
	   int[][] dp = new int[triangle.length][triangle.length];
	     dp[0][0] = triangle[0][0];
	     for(int i = 1; i < triangle.length; i++) {
	    	
	        dp[i][0] = dp[i - 1][0] + triangle[i][0]; 
	        System.out.println("00: "+dp[i][0]+" dp["+(i)+"]["+0+"]"+" "+"dp["+(i- 1)+"]["+0+"]"+(dp[i - 1][0])+" triangle["+i+"]["+0+"]"+(triangle[i][0]));
	        dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
	    	System.out.println("zz: "+dp[i][i]+" dp["+(i)+"]["+(i)+"]"+" "+" dp["+(i- 1)+"]["+(i-1)+"]"+(dp[i - 1][i-1])+"  triangle["+i+"]["+i+"]"+(triangle[i][i]));
	     }
	      
	     // 2. 동적계획법 //
	     for(int i = 2; i < triangle.length; i++) 
	        for(int j = 1; j < i; j++) 
	           dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
	      
	     // 3. 최대값 반환 //
	     int max = 0;
	     for(int i = 0; i < dp.length; i++) 
	        max = Math.max(max, dp[dp.length - 1][i]);
	    
	   return max;
	 }
}

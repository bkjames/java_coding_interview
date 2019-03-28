package zGoo1;

public class maximalSquare_dp {

	public static void main(String[] args) {
//		char[][] grid ={
//			{0, 1, 1, 1, 0},
//			{1, 1, 1, 1, 1},
//		    {0 ,1, 1 ,1, 1},
//		   {0, 1, 1, 1, 1},
//		   {0, 0, 1, 1, 1}
//		};
		char[][] grid= {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
				};
		System.out.println(maximalSquare(grid));
	}
	
	
	public static int maximalSquare(char[][] matrix) {
	  int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
	  int[][] dp = new int[rows + 1][cols + 1];
	  int maxsqlen = 0;
	  for (int i = 1; i <= rows; i++) {
	      for (int j = 1; j <= cols; j++) {
	          if (matrix[i-1][j-1] == '1'){
	              dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
	              maxsqlen = Math.max(maxsqlen, dp[i][j]);
	          }
	      }
	  }
	  return maxsqlen * maxsqlen;
}

public int maximalSquare(char[][] matrix) {
	        // corner case
	        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
	            return 0;
	        }
	        
	        int m = matrix.length;
	        int n = matrix[0].length;

	        // M[i][j] represents the length of largest square of 1's if assume matrix[i][j] is the bottom-right point
	        int[][] M = new int[m][n];

	        // initialization:
	        // M[0][0]/M[0][j]/M[i][0] = matrix[0][0] - '0'
	        
	        // induction rule:
	        // if matrix[i][j] = '0', then M[i][j] = 0
	        // if '1', then M[i][j] = min(M[i][j - 1], M[i - 1][j - 1], M[i - 1][j]) + 1
	        int res = 0;
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(i == 0 || j == 0){
	                    M[i][j] = matrix[i][j] - '0';
	                }else{
	                    if(matrix[i][j] == '0') M[i][j] = 0;
	                    else{
	                        M[i][j] = Math.min(M[i][j - 1], M[i - 1][j - 1]);
	                        M[i][j] = Math.min(M[i][j], M[i - 1][j]) + 1;
	                    }
	                }
	                
	                // update result
	                res = Math.max(res, M[i][j]*M[i][j]);
	            }
	        }
	        
	        return res;
	    }
	
	public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
	

}

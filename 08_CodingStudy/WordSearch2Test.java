package zTest02;


public class G049_LongestIncreasingInaMat {
	
	public static void main(String[] args) {
		int[][] matrix = {{65,66,84,84,84},
						  {84,67,68,69,84},
						  {84,84,84,70,84},
						  {66,65,72,71,70},
						  {67,68,69,70,71}
		};

		G049_LongestIncreasingInaMat a = new G049_LongestIncreasingInaMat();
//		a.print(matrix);
//		System.out.println(a.longestIncreasingPath(matrix));
		System.out.println(a.longestIncreasingPath_memo(matrix));
		a.print(matrix);
	}
	
    final int[][] dirs= {{0,1},{1,0}, {0,-1},{-1,0}};
    int m, n;
    
    public int longestIncreasingPath_memo(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
            	System.out.println("========i: "+i+" j: "+j);
                int len = dfs(matrix, i, j, dp);
                System.out.println("========i: "+i+" j: "+j+" len "+len);
                max = Math.max(max, len);
            }
        	System.out.println();
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
    	System.out.println("dp["+i+"]["+j+"] "+dp[i][j]);
        if (dp[i][j] != 0) return dp[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
//            System.out.println("x:"+x+" y:"+y+" i:"+i+" j:"+j);
            if (0 <= x && x < m && 0 <= y && y < n && check(matrix[x][y] , matrix[i][j])) {
            	System.out.println("matrix["+x+"]["+y+"] "+matrix[x][y]+" matrix["+i+"]["+j+"] "+matrix[i][j]);
            	dp[i][j] = Math.max(dp[i][j], dfs(matrix, x, y, dp));
              
//                System.out.println("==dp===");
                print(dp);
            }
        }
//    	System.out.println("return cache["+i+"]["+j+"] "+cache[i][j]);
        return ++dp[i][j];
    }
    
    public boolean check(int after, int before) {
    	boolean result = false;
    	int count =0;
    	System.out.println("====================count: "+count);
    	if(after>before && count <2) {
    		result =true;
    		count--;
    		System.out.println("=======33333333333=============count: "+count);
    	}else {
    		count++;
    	}
		return result;
    	
    }
    
	public int longestIncreasingPath(int[][] matrix) {
		 if(matrix.length==0) return 0;
		 
		 m = matrix.length;
		 n = matrix[0].length;
		 int ans =0;
		 for(int i=0; i< m; ++i) {
			 for(int j=0; j<n; ++j) {
				 ans= Math.max(ans, dfs(matrix, i, j));
			 }
		 }
		 return ans;
	 }
	int dfs(int[][] matrix, int i, int j) {
		int ans =0;
		for(int[] d : dirs) {
			int x = i+d[0], y = j+d[1];
			System.out.println("x:"+x+" y:"+y+" i:"+i+" j:"+j);
			if(0 <= x && x<m && 0<=y && y<n && matrix[x][y] > matrix[i][j]) {
				System.out.println("matrix["+x+"]["+y+"] "+matrix[x][y]+" matrix["+i+"]["+j+"] "+matrix[i][j]);
				ans = Math.max(ans, dfs(matrix,x,y));
				System.out.println("=========================ans: "+ans);
			}
		}
		return ++ans;
	}
	
	
	
	
	
	
	
	void print(int[][] grid) {
		for(int i=0; i<grid.length; i++) {
//			System.out.print("grid["+i+"] "+grid[i].length+"\t");
			for(int j=0; j<grid[i].length; j++) {
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println();
		}
	}

}

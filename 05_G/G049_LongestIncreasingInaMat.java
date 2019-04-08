package zGoo1;


public class G049_LongestIncreasingInaMat {
	
	public static void main(String[] args) {
		int[][] matrix = {{9,9,4},
						  {6,6,8},
						  {2,1,1}
		};
		G049_LongestIncreasingInaMat a = new G049_LongestIncreasingInaMat();
		a.print(matrix);
//		System.out.println(a.longestIncreasingPath(matrix));
		System.out.println(a.longestIncreasingPath_memo(matrix));
		a.print(matrix);
	}
	
    final int[][] dirs= {{0,1},{1,0}, {0,-1},{-1,0}};
    int m, n;
    
    public int longestIncreasingPath_memo(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, cache));
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            System.out.println("x:"+x+" y:"+y+" i:"+i+" j:"+j);
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
            	System.out.println("matrix["+x+"]["+y+"] "+matrix[x][y]+" matrix["+i+"]["+j+"] "+matrix[i][j]);
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];
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
			System.out.print("grid["+i+"] "+grid[i].length+"\t");
			for(int j=0; j<grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

}

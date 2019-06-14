package test;

public class LongestIncreasingInaMatrix {

	public static void main(String[] args) {
		int[][] grid = {{8,9,4},
						{6,6,8},
						{2,1,5}
				};
		LongestIncreasingInaMatrix a = new LongestIncreasingInaMatrix();
		System.out.println("result "+a.longestIncreasingPath_memo(grid));
	}
	int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
	int m , n ;
	
	public int longestIncreasingPath_memo(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length; n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        int k  =1;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
//            	System.out.println();
                ans = Math.max(ans, dfs(matrix, i, j, cache, k));
                System.out.println("====dp=======");
                print(cache);
            }
        return ans;
    }

	int p=0;
	int dfs(int[][] grid, int i, int j, int[][] cache, int k) {
	
		if(cache[i][j] != 0 ) return cache[i][j];
		for(int[] dir :  dirs) {
			int x = i+dir[0];
			int y = j+dir[1];
			if(0 <= x && x<m && 0 <=y && y<n ) {
				if(check(grid[x][y] ,grid[i][j]) && p<2){
			 	System.out.println("grid["+x+"]["+y+"] "+grid[x][y]+" grid["+i+"]["+j+"] "+grid[i][j]);
				cache[i][j] = Math.max(cache[i][j], dfs(grid, x, y, cache,  k));
				}
			}
		}
		System.out.println("k: "+k);
		return ++cache[i][j];
	}
	
	 public boolean check(int after, int before) {
	    	boolean result = false;
	    	

		    	if(after-before>0 ) {
		    		result =true;
		
		    	}else {
		    		p++;
		    	}

			return result;
	    	
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

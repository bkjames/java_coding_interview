package aaa_ama_6mon;

public class UniquePath3 {

	public static void main(String[] args) {
//			int[][] grid = {
//					  {0,0,0},
//					  {0,1,0},
//					  {0,0,0}
//					};

//			[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]

		int[][] grid = {
				  {1,0,0,0},
				  {0,0,0,0},
				  {0,0,2,-1}
				};
		
		UniquePath3 a = new UniquePath3();
		System.out.println(a.uniquePathsIII(grid));
	}

	int res = 0, empty = 1, sx, sy, ex, ey;

	public int uniquePathsIII(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == 0)
					empty++;
				else if (grid[i][j] == 1) {
					sx = i;
					sy = j;
				} else if (grid[i][j] == 2) {
					ex = i;
					ey = j;
				}
			}
		}
		System.out.println("sx: "+sx+" sy: "+sy+" empty: "+empty);
		System.out.println("=================");
		dfs(grid, sx, sy);
		return res;
	}

	public void dfs(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0)
			return;
		if (x == ex && y == ey) {
			if (empty == 0)
				res++;
			return;
		}
		grid[x][y] = -2;
		System.out.println("x: "+x+" y: "+y+" empty: "+empty);
		empty--;
		dfs(grid, x + 1, y);
		dfs(grid, x - 1, y);
		dfs(grid, x, y + 1);
		dfs(grid, x, y - 1);
		grid[x][y] = 0;
		empty++;
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

}

package basic;

	public class SkyLine {
		
		public static void main(String[] args) {
			int[][] grid= { {3, 0, 8, 4}, 
			                {2, 4, 5, 7},
			                {9, 2, 6, 3},
			                {0, 3, 1, 0} };
			System.out.println(maxIncreaseKeepingSkyline(grid));
		}

		
		 public static int maxIncreaseKeepingSkyline(int[][] grid) {
		        int[] rowMaxes = new int[grid.length];
		        int[] colMaxes = new int[grid[0].length];
		        for (int i = 0; i < rowMaxes.length; ++i) {
		            rowMaxes[i] = getRowMax(grid, i);
		        }
		        for (int j = 0; j < colMaxes.length; ++j) {
		            colMaxes[j] = getColMax(grid, j);
		        }
		        int dif = 0;
		        for (int i = 0; i < rowMaxes.length; ++i) {
		            for (int j = 0; j < colMaxes.length; ++j) {
		            	System.out.println("rowMaxes[i]: "+rowMaxes[i]);
		            	System.out.println("colMaxes[j]: "+colMaxes[j]);
		            	System.out.println("grid[i][j]: "+grid[i][j]);
		                dif += Math.min(rowMaxes[i], colMaxes[j]) - grid[i][j];
		            }
		        }
		        return dif;
		    }
		    private static int getColMax(int[][] grid, int j) {
		        int max=0;
		        for (int i = 0; i < grid.length; ++i) {
		            max=max<grid[i][j]?grid[i][j]:max;
		        }
		        return max;
		    }

		    private static int getRowMax(int[][] grid, int i) {
		        int[] row = grid[i];
		        int max=0;
		        for (int k : row) {
		            max = max < k ? k : max;
		        }
		        return max;
		    }
		
//		  public int maxIncreaseKeepingSkyline(int[][] grid) {
//		        int n = grid.length;
//		        int[] col = new int[n], row = new int[n];
//		        for (int i = 0; i < n; i++) {
//		            for (int j = 0; j < n; j++) {
//		                row[i] = Math.max(row[i], grid[i][j]);
//		                col[j] = Math.max(col[j], grid[i][j]);
//		            }
//		        }
//		        int res = 0;
//		        for (int i = 0; i < n; i++)
//		            for (int j = 0; j < n; j++)
//		                res += Math.min(row[i], col[j]) - grid[i][j];
//		        return res;
//		    }
	}



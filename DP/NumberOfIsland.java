package zz03;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		
		char[][]M = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		numberOfIsland(M);
		print(M);
	}
	
	
	public static void print(char[][] T) {
		int m = T.length;
		int n = T[0].length;
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int numberOfIsland(char[][] grid) {
		if(grid== null|| grid.length==0 || grid[0].length==0)
			return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int count =0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]=='1') {
					count++;
					merge(grid,i,j);
				}
			}
		}
		return count;
	}
	public static void merge(char[][] grid, int i , int j) {
		int m = grid.length;
		int n = grid[0].length;
		
		if(i<0|| i>=m||j<0|| j>=n||grid[i][j] !='1') return;
		
		grid[i][j]='X';
		
		merge(grid, i-1, j);
		merge(grid, i+1, j);
		merge(grid, i, j-1);
		merge(grid, i, j+1);
	}
	

}

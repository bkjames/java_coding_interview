package zGoo001;
import java.util.*;
public class G084_NumberOfDistinctIslands {
	
	public static void main(String[] args) {
		
		int[][] grid = {
						{1,1,0,1,1},
						{1,0,0,0,0},
						{0,0,0,0,1},
						{1,1,0,1,1}
						};
		
		G084_NumberOfDistinctIslands a = new G084_NumberOfDistinctIslands();
		System.out.println(a.numDistictIsland(grid));
		
	}
	
	int numDistictIsland(int[][] grid) {
		Set<String> set = new HashSet<>();
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j< grid[i].length; j++) {
				System.out.println("Before grid["+i+"]["+j+"] "+grid[i][j]);
				if(grid[i][j] != 0) {
					System.out.println("grid["+i+"]["+j+"] "+grid[i][j]);
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, "o");
					grid[i][j]=0;
					System.out.println("====sb===="+sb);
					set.add(sb.toString());
					print(grid);
				}
			}
		
		}
		return set.size();
	}
	void dfs(int[][] grid, int i, int j , StringBuilder sb,String dir) {
	
		System.out.println("init dfs grid["+i+"]["+j+"] ");
		if(i<0||i==grid.length||j<0||j==grid[i].length||grid[i][j]==0)
			return;
		sb.append(dir);
		System.out.println("dfs  grid["+i+"]["+j+"] "+grid[i][j]);
		grid[i][j] =0;
		dfs(grid, i-1, j, sb, "u");
		dfs(grid, i+1, j, sb, "d");
		dfs(grid, i, j-1, sb, "l");
		dfs(grid, i, j+1, sb, "r");
		System.out.println("=======end======");
		sb.append("b");
		
	}
	
	void print(int[][] dp) {
		System.out.println("===================================dp==");
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("===================================dp==");
	}
		

}

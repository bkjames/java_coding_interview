package p1;
import java.util.*;

public class G044_NumberOfIslands_Bfs {
	
	public static void main(String[] args) {

		char[][] grid= {
						{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}
					   };
		
		G044_NumberOfIslands_Bfs a = new G044_NumberOfIslands_Bfs();
		System.out.println(a.numsIslands(grid));
	}
	
	int numsIslands(char[][] grid) {
		if(grid==null || grid.length==0)return 0;
		int count=0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j]=='1') {
					count++;
					bfs(grid, i,j);
				}
			}
		}
		return count;
	}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	void bfs(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x,y));
		while(queue.size()>0) {
			int size = queue.size();
			Point p = queue.poll();
			for(int i=0; i< size; i++) {
				for(int[] dir: dirs) {
					int x1 = p.x +dir[0];
					int y1 = p.y +dir[1];
					if(x1>=0 && y1>=0 && x1<grid.length &&
					   y1< grid[0].length && grid[x1][y1]=='1') {
						grid[x1][y1]='0';
						queue.offer(new Point(x1,y1));
					}
				}
			}
		}
		
	}
	class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

package p3;

import java.util.*;

public class G252_MinPathSum {

	
	public static void main(String[] args) {
		int[][] grid = {
				  {1,3,1},
				  {1,5,1},
				  {4,2,1}
				};
		G252_MinPathSum a = new G252_MinPathSum();
		System.out.println(a.minPathSum_dijkstra(grid));
		
	}
	//1
	
		
	public int minPathSum_dijkstra(int[][] grid) {
	    if(grid == null || grid.length == 0) return 0;
	    int m = grid.length;
	    int n = grid[0].length;
	    
	    boolean[][] visited = new boolean[m][n];
	    int[][] dist = new int[m][n];
	    
	    for(int x = 0; x < m; x++){
	        for(int y = 0; y < n; y++){
	            dist[x][y] = Integer.MAX_VALUE;
	        }
	    }
	    
	    dist[0][0] = grid[0][0];
	    System.out.println("=========");
	    print(dist);
	    
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>( m*n, new PointComparator(dist));
	    
	    pq.add(new int[]{0, 0});
	    
	    while(!pq.isEmpty()){
	        
	    	int[] pointPeek = pq.peek();
//	    	System.out.println(pointPeek[0]+" "+pointPeek[1]);
	        int[] point = pq.poll();
	        int x = point[0];
	        int y = point[1];
	        int d = dist[x][y];
	    	System.out.println(pointPeek[0]+" "+pointPeek[1]+" "+dist[x][y]);
	        if(x == n-1 && y == m-1){
	            return d;
	        }
	        
	        visited[x][y] = true;
	        
	        if((y+1 < n) && !visited[x][y+1]){
	            dist[x][y+1] = min(dist[x][y+1],d + grid[x][y+1]);
	            pq.add(new int[]{x, y+1});
	        }
	        
	        if((x+1 < m ) && !visited[x+1][y]){
	            dist[x+1][y] = min(dist[x+1][y],d + grid[x+1][y]);
	            pq.add(new int[]{x+1, y});
	        }
	    }
	    return 0;
	    
	}
   
	void print(int[][] grid) {
		for(int i =0; i< grid.length; i++) {
			for(int j=0; j<grid[i].length ; j++) {
				System.out.print("  grid["+i+"]["+j+"] "+grid[i][j]+"\t ");
			}
			System.out.println();
		}
	}
	private int min(int i1, int i2){
		return i1 < i2 ? i1 : i2;
	}
	
	class PointComparator implements Comparator<int[]>{
		int[][] dist;
		public PointComparator(int[][] dist){
			this.dist = dist;
		}
		@Override
		public int compare(int[] o1, int[] o2) {
			int[] point1 = (int[])o1;
	        int[] point2 = (int[])o2;
	        return Integer.valueOf(dist[point1[0]][point1[1]]).compareTo(Integer.valueOf(dist[point2[0]][point2[1]]));
	    }
	}
	
	
	//2
	private int getDist(int[][] dist, int x, int y){
		if(x < 0 || y < 0){
			return Integer.MAX_VALUE;
		}
		
		return dist[x][y];		
	}

	private int min2(int i1, int i2){
		return i1 < i2 ? i1 : i2;
	}


	public int minPathSum_dp(int[][] grid) {

		if(grid == null || grid.length == 0) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] dist = new int[m][n];
		
				
		
		for(int x = 0; x < m; x++){
			for(int y = 0; y < n; y++){
				
				if(x == 0 && y == 0){
					dist[0][0] = grid[0][0];
				}else{
					dist[x][y] = min2(getDist(dist, x-1, y), getDist(dist, x, y-1))  + grid[x][y];					
				}
			}			
		}

		return dist[m-1][n-1];
				
	}
	
	//1
	public int minPathSum_dp2(int[][] grid) {
		int m = grid.length;// row
		int n = grid[0].length; // column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
							+ grid[i][j];
				}
			}
		}

		return grid[m - 1][n - 1];
	}
}

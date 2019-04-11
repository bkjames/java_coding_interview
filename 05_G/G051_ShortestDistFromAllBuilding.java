package zGoo1;
import java.util.*;
public class G051_ShortestDistFromAllBuilding {

	public static void main(String[] args) {
		int[][] grid= {{1,0,2,0,1},
			       {0,0,0,0,0},
			       {0,0,1,0,0}};
		G051_ShortestDistFromAllBuilding a = new G051_ShortestDistFromAllBuilding();
		a.shortestDistance(grid);

	}
	final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int shortestDistance(int[][] grid) {
	    int n = grid.length;
	    int m = grid[0].length;
	    int[][] dp = new int[n][m];
	    int[][] reach = new int[n][m];
	    int countBuilding = 0;
	    Queue<int[]> queue = new LinkedList<>();

	    // step 1
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (grid[i][j] == 1) {
	                queue.offer(new int[]{i, j});
	                bfs(queue, grid, dp, reach, n, m);
	                countBuilding++;
	            }
	        }
	    }

	    // step 2
	    int result = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
	            if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
	                result = Math.min(result, dp[i][j]);
	            }
	        }
	    }
	    return result == Integer.MAX_VALUE ? -1 : result;
	}

	public void bfs(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach, int n, int m) {
	    int level = 1;
	    // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
	    boolean[][] visited = new boolean[n][m];
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            int[] curPoint = queue.poll();
	            int x = curPoint[0];
	            int y = curPoint[1];
	            for (int j = 0; j < 4; j++) {
	                int dx = x + dir[j][0];
	                int dy = y + dir[j][1];
	                if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || grid[dx][dy] != 0 || visited[dx][dy]) {
	                    continue;
	                }
	                queue.offer(new int[]{dx, dy});
	                visited[dx][dy] = true;
	                dp[dx][dy] += level;
	                reach[dx][dy]++;
	            }
	        }
	        level++;
	    }
	}
	
	
	
	
	//1
	
	
	
	int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public int shortestDistance3(int[][] grid) {
	    int m = grid.length, n = grid[0].length;
	    int[][] dist = new int[m][n];
	    // Initialize building list and accessibility matrix `grid`
	    List<Tuple> buildings = new ArrayList<>();
	    for (int i = 0; i < m; ++i)
	        for (int j = 0; j < n; ++j) {
	            if (grid[i][j] == 1)
	                buildings.add(new Tuple(i, j, 0));
	            grid[i][j] = -grid[i][j];
	        }
	    // BFS from every building
	    for (int k = 0; k < buildings.size(); ++k)
	        bfs2(buildings.get(k), k, dist, grid, m, n);
	    // Find the minimum distance
	    int ans = -1;
	    for (int i = 0; i < m; ++i)
	        for (int j = 0; j < n; ++j)
	            if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans)) {
	            	System.out.println("========dist["+i+"]["+j+"] "+dist[i][j]);
	                ans = dist[i][j];
	            }
	    return ans;
	}

	public void bfs2(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
	    Queue<Tuple> q = new ArrayDeque<>();
	    q.add(root);
	    while (!q.isEmpty()) {
	        Tuple b = q.poll();
	        System.out.println("b.y: "+b.y+" b.x: "+b.x+" dist: "+b.dist);
	        dist[b.y][b.x] += b.dist;
	        System.out.println("dist["+(b.y)+"]["+(b.x)+"] "+ dist[b.y][b.x]);
	        for (int i = 0; i < 4; ++i) {
	            int x = b.x + dx[i], y = b.y + dy[i];
	            if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
	            	System.out.println("$$$$ grid["+y+"]["+x+"] "+grid[y][x] +" k: "+k);
	                grid[y][x] = k + 1;
	                q.add(new Tuple(y, x, b.dist + 1));
	            }
	        }
	    }
	    System.out.println("###################################");
	}
	class Tuple {
	    public int y;
	    public int x;
	    public int dist;

	    public Tuple(int y, int x, int dist) {
	        this.y = y;
	        this.x = x;
	        this.dist = dist;
	    }
	}
	
	
	
	
	
	
	//2
	final int[][] dir3 = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int shortestDistance2(int[][] grid) {
	    int n = grid.length;
	    int m = grid[0].length;
	    int[][] dp = new int[n][m];
	    int[][] reach = new int[n][m];
	    int countBuilding = 0;
	    Queue<int[]> queue = new LinkedList<>();

	    // step 1
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (grid[i][j] == 1) {
	                queue.offer(new int[]{i, j});
	                bfs(queue, grid, dp, reach, n, m);
	                countBuilding++;
	            }
	        }
	    }

	    // step 2
	    int result = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
	            if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
	                result = Math.min(result, dp[i][j]);
	            }
	        }
	    }
	    return result == Integer.MAX_VALUE ? -1 : result;
	}

	public void bfs3(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach, int n, int m) {
	    int level = 1;
	    // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
	    boolean[][] visited = new boolean[n][m];
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            int[] curPoint = queue.poll();
	            int x = curPoint[0];
	            int y = curPoint[1];
	            for (int j = 0; j < 4; j++) {
	                int dx = x + dir[j][0];
	                int dy = y + dir[j][1];
	                if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || grid[dx][dy] != 0 || visited[dx][dy]) {
	                    continue;
	                }
	                queue.offer(new int[]{dx, dy});
	                visited[dx][dy] = true;
	                dp[dx][dy] += level;
	                reach[dx][dy]++;
	            }
	        }
	        level++;
	    }
	}
}

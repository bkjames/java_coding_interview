package zGoo1;
import java.util.*;
public class G163_NumberOfIsland2 {
	
	public static void main(String[] args) {
		int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
		int m =3, n=3;
		
		G163_NumberOfIsland2 a = new G163_NumberOfIsland2();
		a.print(positions);
		System.out.println("result: "+a.numIslands3(m,n, positions ));
		a.print(positions);
	}
	
	List<Integer> numIslands3(int m, int n, int[][] posi){
		List<Integer> ans = new ArrayList<>();
		char[][] grid = new char[m][n];
		for(char[] row: grid) {
			Arrays.fill(row, '0');
		}
		for(int[] pos: posi) {
			grid[pos[0]][pos[1]] ='1';
			ans.add(numIslands4(grid));
		}
		return ans;
	}
	

	int numIslands4(char[][] grid) {
		if(grid==null || grid.length==0)
			return 0;
		int nr = grid.length;
		int nc = grid[0].length;
		boolean[][] visited = new boolean[nr][nc];
		for(boolean[] row: visited) {
			Arrays.fill(row, false);
		}
		int num_islands =0;
		
		for(int r =0; r<nr; ++r) {
			for(int c=0; c<nc; ++c) {
				if(grid[r][c]=='1' && !visited[r][c]) {
					++num_islands;
					dfs(grid, r, c, visited);
				}
			}
		}
		return num_islands;
	}
	
	void dfs(char[][] grid, int r, int c, boolean[][] visited) {
		int nr = grid.length;
		int nc = grid[0].length;
		if(r<0||c<0|| r>=nr|| c>=nc|| grid[r][c]=='0'||visited[r][c])
			return;
		visited[r][c] = true;
		dfs(grid, r-1, c, visited);
		dfs(grid, r+1, c, visited);
		dfs(grid, r, c-1, visited);
		dfs(grid, r, c+1, visited);
	}
	
	
	
	
	void print(int[][] pos) {
		for(int i=0; i<pos.length; i++) {
			for(int j=0; j<pos[i].length; j++) {
				System.out.println("pos["+i+"]["+j+"]:"+pos[i][j]);
			}
		}
	}
	
	
	// 2
	int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
	    List<Integer> result = new ArrayList<>();
	    if(m <= 0 || n <= 0) return result;

	    int count = 0;                      // number of islands
	    int[] roots = new int[m * n];       // one island = one tree
	    Arrays.fill(roots, -1);            

	    for(int[] p : positions) {
	        int root = n * p[0] + p[1];     // assume new point is isolated island
	        roots[root] = root;             // add new island
	        count++;

	        for(int[] dir : dirs) {
	        	System.out.println("dir[0] "+dir[0]+ " dir[1] "+dir[1]);
	            int x = p[0] + dir[0]; 
	            int y = p[1] + dir[1];
	            int nb = n * x + y;
	          
	            if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
	            System.out.println("nb: "+nb+" root["+nb+"] "+roots[nb]);
	            int rootNb = findIsland(roots, nb);
	            if(root != rootNb) {        // if neighbor is in another island
	                roots[root] = rootNb;   // union two islands 
	                root = rootNb;          // current tree root = joined tree root
	                count--;               
	            }
	        }

	        result.add(count);
	    }
	    return result;
	}

	public int findIsland(int[] roots, int id) {
	    while(id != roots[id]) {
	    	id = roots[id];
	    	System.out.println("id: "+id+" roots["+id+"] "+roots[id]);
	    }
	    System.out.println("id: "+id);
	    return id;
	}
}

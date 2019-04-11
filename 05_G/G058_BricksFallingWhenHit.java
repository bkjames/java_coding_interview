package zGoo1;
import java.util.*;

public class G058_BricksFallingWhenHit {

	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0},{1,1,1,0}};
		int[][] hits = {{1,0}};
	}
	public int[] hitBricks(int[][] grid, int[][] hits) {
        // O(m). Reverse the step, and first get the final board status
        for(int i = 0; i < hits.length; i++) {
            grid[hits[i][0]][hits[i][1]] -= 1;
        }

        HashSet<Integer> nonDrop = new HashSet<>();
        // O(m). Check which grid is still sticked to the top eventually.
        for(int i = 0; i < grid[0].length; i++) {
            if(grid[0][i] == 1)
                dfs(nonDrop, 0, i, grid);
        }

        int[] output = new int[hits.length];
        // O(m)
        for (int i = hits.length - 1; i >= 0; i--) {
            int size = nonDrop.size();
            grid[hits[i][0]][hits[i][1]] += 1;
            // The added grid should be connected to at least one non drop grid or it is one of the top grids.
            if(grid[hits[i][0]][hits[i][1]] == 1) {
                if ((hits[i][0] - 1 >= 0 && nonDrop.contains((hits[i][0] - 1) * grid[0].length + hits[i][1])) 
                   || (hits[i][0] + 1 < grid.length && nonDrop.contains((hits[i][0] + 1) * grid[0].length + hits[i][1]))
                   || (hits[i][1] - 1 >= 0 && nonDrop.contains(hits[i][1] - 1 + (hits[i][0]) * grid[0].length))
                   || (hits[i][1] + 1 < grid[0].length && nonDrop.contains((hits[i][0]) * grid[0].length + hits[i][1] + 1))
                   || hits[i][0] == 0) {
                    dfs(nonDrop, hits[i][0], hits[i][1], grid); //  O(n) in total
                    output[i] = nonDrop.size() - size - 1;  // -1 because the added grid is not counted;
                }
            }
        }

        return output;
    }

    // Because every nodes will be visted at most 5 times, so in total the dfs is O(n)
    public void dfs(HashSet<Integer> nonDrop, int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] != 1 || nonDrop.contains(i*grid[0].length + j))
            return;
        else {
            nonDrop.add(i * grid[0].length + j);
            dfs(nonDrop, i - 1, j, grid);
            dfs(nonDrop, i + 1, j, grid);
            dfs(nonDrop, i, j - 1, grid);
            dfs(nonDrop, i, j + 1, grid);
        }
    }
}

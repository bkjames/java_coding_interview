package zGoo1;
import java.util.*;
public class G054_NumberOfCornerRectangles {

	public static void main(String[] args) {
		int[][] grid = {{1, 0, 0, 1, 0},
				 {0, 0, 1, 0, 1},
				 {0, 0, 0, 1, 0},
				 {1, 0, 1, 0, 1}};
		System.out.println(countCornerRectangles_straight(grid));
	}
	
	public static int countCornerRectangles_straight(int[][] grid) {
	      if (grid == null || grid.length < 2) {
	        return 0;
	      }
	      int m = grid.length;
	      int n = grid[0].length;
	      int count = 0;
	      for (int i = 0; i < m - 1; i++) {
	        for (int j = 0; j < n - 1; j++) {
	          if (grid[i][j] == 1) {
	        	  System.out.println("first i: "+i+" j: "+j);
	            for (int jNext = j + 1; jNext < n; jNext++) {
	              if (grid[i][jNext] == 1) {
	            	  System.out.println("i: "+i+" jNext: "+jNext);
	                for (int iNext = i + 1; iNext < m; iNext++) {
	                  if (grid[iNext][j] == 1 && grid[iNext][jNext] == 1) {
	                	  System.out.println("iNext: "+iNext+" j: "+j+" iNext: "+iNext+" jNext: "+jNext);
	                    count++;
	                  }
	                }
	              }
	            }
	          }
	        }
	      }
	      return count;
	    }
	
	public static int countCornerRectangles(int[][] grid) {
	    int n = grid.length;
	    int m = grid[0].length;
	    int result = 0;

	    // traverse all possible combination of two horizontal lines x1 and x2
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = i + 1; j < n; j++) {
	            int count = 0;
	            // scan from left to right, count number of valid vertical lines between two i and j
	            for (int k = 0; k < m; k++) {
	                if (grid[i][k] == 1 && grid[j][k] == 1) {
	                    count++;
	                }
	            }
	            
	            // calculate number of new corner rectangles 
	            result += count * (count - 1) / 2;
	        }
	    }
	    return result;
	}
	
	  public static int countCornerRectangles2(int[][] grid) {
	        Map<Integer, Integer> count = new HashMap();
	        int ans = 0;
	        for (int[] row: grid) {
	            for (int c1 = 0; c1 < row.length; ++c1) if (row[c1] == 1) {
	                for (int c2 = c1+1; c2 < row.length; ++c2) if (row[c2] == 1) {
	                    int pos = c1 * 200 + c2;
	                    int c = count.getOrDefault(pos, 0);
	                    ans += c;
	                    count.put(pos, c+1);
	                }
	            }
	        }
	        return ans;
	    }
}

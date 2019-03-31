package zGoo1;
import java.util.*;

public class G125_MostStoneRemoveWithSameRowCol {

	public static void main(String[] args) {
		G125_MostStoneRemoveWithSameRowCol a = new G125_MostStoneRemoveWithSameRowCol();
		int[][] stones=  {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println(a.removeStones(stones));
		
	}
	// Ans = # of stones – # of islands
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
               dfs(s1, visited, stones); 
               numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }
    
    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
				// stone with same row or column. group them into island
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}

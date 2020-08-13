package a_20200813;
import java.util.*;

public class A068_FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},
				         {1,1,0},
				         {1,0,1}};
		int	sr = 1, sc = 1, newColor = 2;
		int[][] result = floodFill_bfs(image, sr, sc, newColor);
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	//dfs
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private static void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
    
    static int[][] dirs ={{-1,0},{1,0},{0,-1},{0,1}};
    static int m;
	static int n;
    public static int[][] floodFill_bfs(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        int val = image[sr][sc];
        image[sr][sc]= newColor;
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            visited[p[0]][p[1]] =true;
            for(int[] dir : dirs){
                int dx = p[0]+dir[0];
                int dy = p[1]+dir[1];
                if(dx<0 || dy<0 || dx>=m || dy>=n || image[dx][dy]!=val || visited[dx][dy]) continue;
                image[dx][dy]=newColor;
                queue.offer(new int[]{dx,dy});
            }
        }
        return image;
    }
    
    //bfs
	  public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
          int[] directions = new int[]{0, 1, 0, -1, 0};
          int m = image.length;
          int n = image[0].length;
          int originalValue = image[sr][sc];
          image[sr][sc] = newColor;

          boolean[][] visited = new boolean[m][n];

          Queue<int[]> queue = new LinkedList<>();
          queue.offer(new int[]{sr, sc});
          while (!queue.isEmpty()) {
              int[] curr = queue.poll();
              visited[curr[0]][curr[1]] = true;
              for (int i = 0; i < directions.length - 1; i++) {
                  int nextR = curr[0] + directions[i];
                  int nextC = curr[1] + directions[i + 1];
                  if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || image[nextR][nextC] != originalValue || visited[nextR][nextC]) {
                      continue;
                  }
                  image[nextR][nextC] = newColor;
                  queue.offer(new int[]{nextR, nextC});
              }
          }
          return image;
      }
}

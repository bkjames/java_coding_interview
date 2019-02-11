package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTree {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		list.add(1);list.add(2);list.add(3);
		list2.add(0);list2.add(0);list2.add(4);
		list3.add(7);list3.add(6);list3.add(5);
		
		List<List<Integer>> list4 = new ArrayList<>();
		list4.add(list);list4.add(list2);list4.add(list3);
 		
		System.out.println(cutOffTree(list4));
	}
	
	
	//1.
	  int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int cutOffTree(List<List<Integer>> forest) {
        //create a list of int[] {value, x, y}
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int value = forest.get(i).get(j);
                if (value > 1) trees.add(new int[]{i, j, value});
            }
        }
        
        Collections.sort(trees, (a, b)->(a[2]-b[2]));
        int res = 0, x = 0, y = 0;
        for (int[] tree: trees) {
            int dist = bfs(forest, x, y, tree[0], tree[1]);
            if (dist < 0) return -1;
            else {
                res += dist;
                x = tree[0];
                y = tree[1];
            }
        }
        return res;
    }
    private int bfs(List<List<Integer>> forest, int x, int y, int tx, int ty) {
        int m = forest.size(), n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                if (cur[0] == tx && cur[1] == ty) return dist;
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0]+dirs[i][0];
                    int ny = cur[1]+dirs[i][1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || 
                        visited[nx][ny] || forest.get(nx).get(ny) <= 0) continue;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
            dist++;
        }
        return -1;
    }
	
	
//2.
	   static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

	    public static int cutOffTree(List<List<Integer>> forest) {
	        if (forest == null || forest.size() == 0) return 0;
	        int m = forest.size(), n = forest.get(0).size();

	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	            	System.out.println("aa: "+i+" "+j);
	                if (forest.get(i).get(j) > 1) {
	                	System.out.println("    "+i+" "+j+" : "+forest.get(i).get(j));
	                    pq.add(new int[] {i, j, forest.get(i).get(j)});
	                }
	            }
	            System.out.println();
	        }

	        int[] start = new int[2];
	        int sum = 0;
	        while (!pq.isEmpty()) {
	            int[] tree = pq.poll();
	            int step = minStep(forest, start, tree, m, n);

	            if (step < 0) return -1;
	            sum += step;

	            start[0] = tree[0];
	            start[1] = tree[1];
	        }

	        return sum;
	    }

	    private static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
	        int step = 0;
	        boolean[][] visited = new boolean[m][n];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(start);
	        visited[start[0]][start[1]] = true;

	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                int[] curr = queue.poll();
	                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

	                for (int[] d : dir) {
	                    int nr = curr[0] + d[0];
	                    int nc = curr[1] + d[1];
	                    if (nr < 0 || nr >= m || nc < 0 || nc >= n 
	                        || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
	                    queue.add(new int[] {nr, nc});
	                    visited[nr][nc] = true;
	                }
	            }
	            step++;
	        }

	        return -1;
	    }
}

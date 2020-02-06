package ama;

public class CampusBikes {

	
	public static void main(String[] args) {
		int[][] workers = {{0,0},{2,1}}, bikes = {{1,2},{3,3}};
		CampusBikes a = new CampusBikes();
		System.out.println(a.assignBikes(workers, bikes));
	}
	int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(new boolean[bikes.length], workers, 0, bikes, 0);
        return min;
    }
    public void dfs(boolean[] visit, int[][] workers, int i, int[][] bikes, int distance) {
        if (i >= workers.length) {
            min = Math.min(distance, min);
            return ;
        }
        if (distance > min) {
            return ;
        }
        for (int j = 0; j < bikes.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            dfs(visit, workers, i + 1, bikes, distance + dis(bikes[j], workers[i]));
            visit[j] = false;
        }
        
    }
    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

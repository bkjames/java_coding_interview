package exam;
import java.util.*;

public class Flights {
	
	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
//		int[][] times = {{1,2,3},{1,4,4},{2,3,1},{2,5,2},{3,5,1},{4,5,2}   };
		int src = 0, dst = 2, k = 1;
		Flights a = new Flights();
	
		System.out.println(a.findCheapestPrice(n, flights, src, dst, k));
		System.out.println(a.findCheapestPrice_dji(n, flights, src, dst, k));
	}
	//
	    private int res = Integer.MAX_VALUE;
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	        Map<Integer, List<int[]>> graph = new HashMap<>();
	        for (int[] f: flights) {
	            int s = f[0], d = f[1], w = f[2];
	            if (!graph.containsKey(s)) {
	                graph.put(s, new ArrayList<>());
	            }
	            graph.get(s).add(new int[] {d, w});
	        }
	        dfs(graph, new HashSet<>(), dst, 0, src, 0, K);
	        return res == Integer.MAX_VALUE ? -1 : res;
	    }
	    
	    public void dfs(Map<Integer, List<int[]>> graph, Set<Integer> visited, int dst,
	                    int curPrice, int curNode, int cnt, int K) {
	        if (curNode == dst) {
	            res = Math.min(res, curPrice);
	            return;
	        }
	        if (cnt >= K + 1 || curPrice > res) {
	            return;
	        }
	        if (graph.containsKey(curNode)) {
	            for (int[] next: graph.get(curNode)) {
	                int v = next[0], p = next[1];
	                if (!visited.contains(v)) {
	                    visited.add(v);
	                    dfs(graph, visited, dst, curPrice + p, v, cnt + 1, K);
	                    visited.remove(v);
	                }
	            }            
	        }

	    }
	
	//2
	public int findCheapestPrice_dji(int n, int[][] flights, int src, int dst, int K) {
        int[][] costs = new int[n][n];
        for(int i=0; i< costs.length; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        for(int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            costs[start][end] = flight[2];
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] temp = {0, 0, src};
        pq.offer(temp);
        
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int cost = info[0]; int step = info[1]; int place = info[2];
            if(place == dst) {
                return cost;
            }
            if(step > K){continue;}
            for(int reach = 0; reach < n; reach ++ ){
                if(costs[place][reach] == Integer.MAX_VALUE) {
                    continue;
                }
                int[] temp2 = {cost + costs[place][reach], step + 1, reach};
                pq.offer(temp2);
            }
        }
        return -1;
    }
//1
	 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	        int[][][] graph = new int[n][n][2];        
	        for(int[] curr:flights){
	            int u = curr[0];
	            int v = curr[1];
	            int p = curr[2];
	            graph[u][v][0] = 1;
	            graph[u][v][1] = p;
	        }
	        if(K == 0){
	            return (graph[src][dst][0] == 1) ? graph[src][dst][1] : -1;
	        }
	        Queue<Integer> index = new LinkedList<>();
	        int[] dist = new int[n];
	        Arrays.fill(dist,Integer.MAX_VALUE);
	        index.add(src);
	        dist[src] = 0;
	        int step = 0, res = Integer.MAX_VALUE;
	        while(!index.isEmpty()){
	            int sz = index.size();
	            for(int i=0;i<sz;i++){
	                int loc = index.poll();
	                if(step > K)
	                    break;
	                for(int j=0;j<n;j++){
	                    if(graph[loc][j][0] == 1 && dist[j] > dist[loc] + graph[loc][j][1]){                       
	                        index.add(j);
	                        dist[j] = dist[loc] + graph[loc][j][1];
	                    }
	                }
	            }            
	            step++;
	            if(step > K)
	                break;
	        }
	        return (dist[dst] != Integer.MAX_VALUE) ? dist[dst] : -1;
	    }
}

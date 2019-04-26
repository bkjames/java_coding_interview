package test;
import java.util.*;

public class CheapestFlightWithinKStops {

	public static void main(String[] args) {
		CheapestFlightWithinKStops a = new CheapestFlightWithinKStops();
		int n = 3,src = 0, dst = 2, k = 1;
		int[][] flights	 = {{0,1,100},{1,2,100},{0,2,500}};
		
		System.out.println(a.findCheapestPrice_1(n, flights, src, dst, k));
	}
	
	public  int findCheapestPrice_1(int n, int[][] flights, int src, int dst, int K) {
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
            int cost = info[0]; 
            int step = info[1]; 
            int place = info[2];
            System.out.println("cost: "+cost+" "+step+" "+place);
            if(place == dst) {
            	System.out.println("cost: "+cost);
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
	
 
	
	 public int findCheapestPrice_di1(int n, int[][] flights, int src, int dst, int k) {
	        Map<Integer, List<Node>> edges = new HashMap<> ();
	        for (int i = 0; i < flights.length; i++) {
	            int[] edge = flights[i];
	            edges.computeIfAbsent (edge[0], label -> new ArrayList<> ()).add (new Node (edge[1], edge[2]));
	        }
	        PriorityQueue<Node> pq = new PriorityQueue<> ((a, b) -> a.dist - b.dist);
	        int[][] dist = new int[n][k + 2];
	        for (int i = 0; i < dist.length; i++) for (int j = 0; j < dist[0].length; j++)
	            dist[i][j] = i == src ? 0 : Integer.MAX_VALUE;
	        pq.offer (new Node (src, 0));
	        while (!pq.isEmpty ()) {
	            Node cur_node = pq.poll ();
	            if (cur_node.label == dst)
	                return cur_node.dist;
	            if (edges.containsKey (cur_node.label)) {
	                for (Node neighbor : edges.get (cur_node.label)) {
	                    int new_step = cur_node.step + 1, new_dist = cur_node.dist + neighbor.dist;
	                    if (new_step <= k + 1 && new_dist < dist[neighbor.label][new_step]) {
	                        dist[neighbor.label][new_step]= new_dist;
	                        pq.offer (new Node (neighbor.label, new_dist, new_step));
	                    }
	                }
	            }
	        }
	        return -1;
	    }

	    static class Node {
	        int label;
	        int dist;
	        int step = 0;
	        Node (int l, int d) {label = l; dist = d; }
	        Node (int l, int d, int s) {label = l; dist = d; step = s; }
	        public String toString () {
	            return String.format ("[%d, %d, %d]", label, dist, step);
	        }
	    }
	    
	    //3
	    
	    private class City implements Comparable<City>{
	        int id;
	        int costFromSrc;
	        int stopFromSrc;
	        public City(int id, int costFromSrc, int stopFromSrc){
	            this.id = id;
	            this.costFromSrc = costFromSrc;
	            this.stopFromSrc = stopFromSrc;
	        }
	        public boolean equals(City c){
	            if(c instanceof City)
	                return this.id == c.id;
	            return false;
	        }
	        public int compareTo(City c){
	            return this.costFromSrc - c.costFromSrc;
	        }
	    }
	    public int findCheapestPrice_dij2(int n, int[][] flights, int src, int dst, int K) {
	        int[][] srcToDst = new int[n][n];
	        for(int i = 0; i < flights.length; i++)
	            srcToDst[flights[i][0]][flights[i][1]] = flights[i][2]; 
							
	        PriorityQueue<City> minHeap = new PriorityQueue();
	        minHeap.offer(new City(src,0,0));
					
	        int[] cost = new int[n];
	        Arrays.fill(cost, Integer.MAX_VALUE);
	        cost[src] = 0;
	        int[] stop = new int[n];
	        Arrays.fill(stop, Integer.MAX_VALUE);
	        stop[src] = 0;
					
	        while(!minHeap.isEmpty()){
	            City curCity = minHeap.poll();
	            if(curCity.id == dst) return curCity.costFromSrc;
	            if(curCity.stopFromSrc == K + 1) continue;
	            int[] nexts = srcToDst[curCity.id];
	            for(int i = 0; i < n; i++){
	                if(nexts[i] != 0){
	                    int newCost = curCity.costFromSrc + nexts[i];
	                    int newStop = curCity.stopFromSrc + 1;
	                    if(newCost < cost[i]){
	                        minHeap.offer(new City(i, newCost, newStop));
	                        cost[i] = newCost;
	                    }
	                    else if(newStop < stop[i]){
	                        minHeap.offer(new City(i, newCost, newStop));
	                        stop[i] = newStop;
	                    }
	                }
	            }
	        }
	        
	        return cost[dst] == Integer.MAX_VALUE? -1:cost[dst];
	    }
	
	
	
	 public int reachableNodes_dijkstr1(int[][] edges, int M, int N) {
	        int[][] graph = new int[N][N];
	        for (int i = 0; i < N; i++) {
	            Arrays.fill(graph[i], -1);
	        }
	        for (int[] edge : edges) {
	            graph[edge[0]][edge[1]] = edge[2];
	            graph[edge[1]][edge[0]] = edge[2];
	        }
	        int result = 0;
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
	        boolean[] visited = new boolean[N];
	        pq.offer(new int[]{0, M});
	        while (!pq.isEmpty()) {
	            int[] cur = pq.poll();
	            int start = cur[0];
	            int move = cur[1];
	            if (visited[start]) {
	                continue;
	            }
	            visited[start] = true;
	            result++;
	            for (int i = 0; i < N; i++) {
	                if (graph[start][i] > -1) {
	                    if (move > graph[start][i] && !visited[i]) {
	                        pq.offer(new int[]{i, move - graph[start][i] - 1});
	                    }
	                    graph[i][start] -= Math.min(move, graph[start][i]);
	                    result += Math.min(move, graph[start][i]);
	                }
	            }
	        }
	        return result;
	    }
}

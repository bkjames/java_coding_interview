package Top50;
import java.util.*;

public class T27_NetworkDelayTime {

	public static void main(String[] args) {
		int[][] times = {{2,1,1},{2,3,1},{3,4,6}};
		int N =4;
		int K =2;
		T27_NetworkDelayTime a = new T27_NetworkDelayTime();
		System.out.println(a.networkDelayTime_djik(times, N, K));
		System.out.println(a.networkDelayTime(times, N, K));
		
	}
	
	  // standard Dijkstra question  time O(2V + E), spcace O(V + E)
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        // construct graph
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) graph.put(time[0], new HashMap<Integer, Integer>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((Pair p1, Pair p2) -> {
            return p1.dist - p2.dist;
        });
        
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new Pair(K, 0));
        int res = 0;
        
        
        // first poll the pair and check if the pair has been added into minHeap
        // If so -> the shortest distnace from root to curNode has been evaluated then skip the node
        // else -> evalue the distance to curNode and it must be the shortest distance 
        // then check if curNode has neighbours
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            
            if (visited.contains(cur.label)) continue;
            visited.add(cur.label);
            res = Math.max(res, cur.dist);
            // check if curNode has neighbours
            if (!graph.containsKey(cur.label)) continue;
            
            for (int neigh : graph.get(cur.label).keySet()) {
                minHeap.offer(new Pair(neigh, cur.dist + graph.get(cur.label).get(neigh)));
            }
        }
        return visited.size() == N ? res : -1;
    }
    
    class Pair {
        int label; int dist;
        
        public Pair(int label, int dist) {
            this.label = label;
            this.dist = dist;
        }
    }
	
	 static class Pair_d {
	        int dest, time;
	        Pair_d(int dest, int time) {
	            this.dest = dest;
	            this.time = time;
	        }
	    }

	    public int networkDelayTime_djik(int[][] times, int N, int K) {
	        Map<Integer, Set<Pair_d>> map = new HashMap<>();
	        for (int[] time: times) {
	            if (!map.containsKey(time[0]))
	                map.put(time[0], new HashSet<>());
	            map.get(time[0]).add(new Pair_d(time[1], time[2]));
	        }
	        int[] dp = new int[N + 1];
	        Arrays.fill(dp, Integer.MAX_VALUE);
	        dp[0] = dp[K] = 0;
	        Queue<Integer> q = new LinkedList<>();
	        q.offer(K);
	        while (!q.isEmpty()) {
	            int n = q.poll();
	            if (!map.containsKey(n))
	                continue;
	            for (Pair_d p: map.get(n)) {
	                int time = dp[n] + p.time;
	                if (dp[p.dest] > time) {
	                    q.offer(p.dest);
	                    dp[p.dest] = time;
	                }
	            }
	        }
	        int delay = 0;
	        for (int n: dp)
	            delay = Math.max(delay, n);
	        return delay == Integer.MAX_VALUE ? -1 : delay;
	    }
	
	 
    
	
	
   
}

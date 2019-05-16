package Top50;
import java.util.*;

public class T27_NetworkDelayTime {

	public static void main(String[] args) {
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		int N =4;
		int K =2;
		T27_NetworkDelayTime a = new T27_NetworkDelayTime();
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
}

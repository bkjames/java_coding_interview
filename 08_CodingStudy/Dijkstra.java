import java.util.*;
public class Dijkstra {

	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
		int src = 0, dst = 2, k = 1;
		Dijkstra a = new Dijkstra();
		System.out.println(a.findCheapestPriceFinal(n, flights, src, dst, k));
//		System.out.println(a.findCheapestPrice(n, flights, src, dst, k));
	}
	
	
	//1
	  public static class Edge {
	        int node;
	        int cost;
	        int stop;

	        public Edge(int n, int c, int s){
	            node = n;
	            cost = c;
	            stop = s;
	        }

	        @Override
	        public String toString(){
	            return this.node +" "+this.cost+" "+this.stop;
	        }
	    }
	    public int findCheapestPriceFinal(int n, int[][] flights, int src, int dst, int K) {
	        Map<Integer,List<Edge>> graph = new HashMap<>();

	        for(int i=0; i<flights.length; i++){
	            int[] curr = flights[i];
	            List<Edge> edges = graph.getOrDefault(curr[0], new ArrayList<Edge>());
	            edges.add(new Edge(curr[1], curr[2],-1));
	            graph.put(curr[0],edges);
	        }

	        Set<Integer> visited = new HashSet<>();
	        Queue<Edge> pq = new PriorityQueue<>((node1, node2) -> node1.cost - node2.cost );

	        // K is number of stop without adding source and destination - so we need to add k+1
	        pq.add(new Edge(src, 0, K+1)); // add source

	        while(!pq.isEmpty()){
	            Edge curr = pq.poll();
	            if(curr.node == dst) {
	                return curr.cost;
	            }
	            visited.add(curr.node);

	            List<Edge> currEdges = graph.getOrDefault(curr.node,new ArrayList<Edge>());
	            if(curr.stop > 0){ // No need to go further and add into queue if the no.stops already crossed for curr
	                for(Edge e: currEdges){
	                    if(!visited.contains(e.node)){
	                        pq.add(new Edge(e.node, curr.cost + e.cost, curr.stop - 1));
	                    }
	                }
	            }
	        }

	        return -1;
	    }

package Basic;

import java.util.*;
public class Dijkstra {

	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
		int src = 0, dst = 2, k = 1;
		Dijkstra a = new Dijkstra();
		System.out.println(a.findCheapestPriceFinal(n, flights, src, dst, k));
	}
	
	//2
		
		    class Node {
        int weight;
        int src;
        int K;
        List<Integer> path;
        Node(int weight, int src, int K, List<Integer> path) {
            this.weight = weight;
            this.src = src;
            this.K = K;
            this.path = new ArrayList<Integer>();
            this.path.addAll(path);
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(flights.length == 0) return -1;
        Map<Integer, Map<Integer, Integer>> hash = new HashMap<>();
        for(int i = 0; i < flights.length; i++) {
            Map<Integer, Integer> tem = hash.getOrDefault(flights[i][0], new HashMap<>());
            tem.put(flights[i][1], flights[i][2]);
            hash.put(flights[i][0], tem);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Node(0, src, K+1, Arrays.asList(src)));
        while(!pq.isEmpty()) {
            Node top = pq.poll();
            if(top.K < 0) continue;
            if(top.src == dst) {
                for(Integer val: top.path) {        
                    System.out.print(val + " ");
                } 
                return top.weight;
            }
            Map<Integer, Integer> map = hash.getOrDefault(top.src, new HashMap<>());
            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                Node node = new Node(top.weight + entry.getValue(), entry.getKey(), top.K-1, top.path);
                node.path.add(entry.getKey());
                pq.offer(node);
            }
        }
        return -1;
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
	    
	    
	//1
//	  class Node{
//	        int dst;
//	        int fee;
//	        Node(int i, int j){
//	            dst = i;
//	            fee = j;
//	        }
//	    }
//	    
//		int curmin = 99999999;
//		
//	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//	        Map<Integer, List<Node>> mp = new HashMap<>();
//	        
//	        for(int[] arr: flights){
//	            int from = arr[0];
//	            int to = arr[1];
//	            int fee = arr[2];
//	            mp.putIfAbsent(from, new ArrayList<Node>());
//	            Node nd = new Node(to, fee);
//	            mp.get(from).add(nd);
//	        }
//	        
//	        dfs(mp,flights,src,dst,K,0,0);
//	        if(curmin==99999999){
//	            return -1;
//	        }        
//	        return curmin;
//	    }
//	    
//	    public void dfs(Map<Integer, List<Node>> mp, int[][] flights, int src, int dst, int K, int step, int fee){
//	        //之前的没有判断curmin，导致超时
//	        if(step>K+1 || fee>curmin ){
//	            return;
//	        }
//	        
//	        if(src==dst){
//	        	curmin = Math.min(curmin, fee);
//	            return;
//	        }
//	        if(!mp.containsKey(src)) return;
//	        
//	        List<Node> destins = mp.get(src);
//	        
//	        for(Node n:destins){
//	            
//	            int curfee = n.fee;
//	            int mudi = n.dst;            
//	            dfs(mp,flights,mudi,dst,K,step+1,fee+curfee);
//	        }
//	        
//	    }
//	    
//	    //2
//	    class Node {
//	        int weight;
//	        int src;
//	        int K;
//	        List<Integer> path;
//	        Node(int weight, int src, int K, List<Integer> path) {
//	            this.weight = weight;
//	            this.src = src;
//	            this.K = K;
//	            this.path = new ArrayList<Integer>();
//	            this.path.addAll(path);
//	        }
//	    }
//	    
//	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//	        if(flights.length == 0) return -1;
//	        Map<Integer, Map<Integer, Integer>> hash = new HashMap<>();
//	        for(int i = 0; i < flights.length; i++) {
//	            Map<Integer, Integer> tem = hash.getOrDefault(flights[i][0], new HashMap<>());
//	            tem.put(flights[i][1], flights[i][2]);
//	            hash.put(flights[i][0], tem);
//	        }
//	        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
//	        pq.add(new Node(0, src, K+1, Arrays.asList(src)));
//	        while(!pq.isEmpty()) {
//	            Node top = pq.poll();
//	            if(top.K < 0) continue;
//	            if(top.src == dst) {
//	                for(Integer val: top.path) {        
//	                    System.out.print(val + " ");
//	                } 
//	                return top.weight;
//	            }
//	            Map<Integer, Integer> map = hash.getOrDefault(top.src, new HashMap<>());
//	            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
//	                Node node = new Node(top.weight + entry.getValue(), entry.getKey(), top.K-1, top.path);
//	                node.path.add(entry.getKey());
//	                pq.offer(node);
//	            }
//	        }
//	        return -1;
//	    }
//	    
//	    //다소 오류 Java Real (Dijkstra's) PriorityQueue Sol
//	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//	        Map<Integer, Map<Integer, Integer>> map = new HashMap<>(); 
//	        for(int i = 0; i < n; i++) {
//	            map.put(i, new HashMap<>());
//	        }
//	        for(int[] flight : flights) {
//	            int flight1 = flight[0];
//	            int flight2 = flight[1];
//	            int price = flight[2];
//	            map.get(flight1).put(flight2, price);
//	        }
//	        PriorityQueue<City> pq = new PriorityQueue<>(new Comparator<City>(){
//	            @Override
//	            public int compare(City city1, City city2) {
//	                int price1 = city1.price;
//	                int price2 = city2.price;
//	                if(price1 == price2)
//	                    return 0;
//	                return price1 < price2 ? -1 : 1;
//	            }
//	        });
//			// map for keep tracking the citys in pq
//	        Map<Integer, City> cityMap = new HashMap<>();
//	        City startCity = new City(src, 0, K);
//	        pq.offer(startCity);
//	        cityMap.put(src, startCity);
//	        while(!pq.isEmpty()) {
//	            City cur = pq.poll();
//	            int city = cur.city;
//	            int price = cur.price;
//	            int stop = cur.stop;
//	            if(city == dst) {
//	                return price;
//	            }
//	            if(stop >= 0) {
//	                Map<Integer, Integer> neis = map.get(city);
//	                for(int nei : neis.keySet()) {
//	                    int cost = neis.get(nei);
//	                    if(!cityMap.containsKey(nei) || **cityMap.get(nei).stop != stop - 1**) {
//	                        City next = new City(nei, price + cost, stop - 1);
//	                        cityMap.put(nei, next);
//	                        pq.offer(next);
//	                    } else {
//	                        City next = cityMap.get(nei);
//	                        if(next.price > price + cost) {
//								// if we have a smaller cost so far, we update the pq by deleteing and re-inserting
//	                            pq.remove(next);
//	                            next.price = price + cost;
//	                            next.stop = stop - 1;
//	                            pq.offer(next);
//	                            cityMap.put(nei, next);
//	                        }
//	                    }
//	                }
//	            }
//	        }
//	        return -1;
//	    }
//	    public class City {
//	        private int city;
//	        private int price;
//	        private int stop;
//	        public City(int city, int price, int stop) {
//	            this.city = city;
//	            this.price = price;
//	            this.stop = stop;
//	        }
//	    }
//	    
//	    // 댓글
//	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//	        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
//	        HashSet<Integer> visited = new HashSet<>();
//	        for(int i = 0; i < flights.length; i++) {
//	            HashMap<Integer, Integer> stops = map.getOrDefault(flights[i][0], new HashMap<>());
//	            stops.put(flights[i][1], flights[i][2]);
//	            map.put(flights[i][0], stops);
//	        }
//	        
//	        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[0], b[0])));
//	        if(map.containsKey(src)) pq.offer(new int[] {0, src, K+1});
//	        int count = 0;
//	        int cost = 0;
//	        
//	        while(!pq.isEmpty()) {
//	            int[] top = pq.poll();
//	            int price = top[0];
//	            int city = top[1];
//	            int stops = top[2];
//	            if(city == dst) return price;
//	            if(stops > 0) {
//	                Map<Integer, Integer> adj = map.get(city);
//	                for(int next: adj.keySet()) {
//	                    pq.add(new int[] {price+adj.get(next), next, stops-1});
//	                }
//	            }
//	        }
//	        return -1;
//	    }
}

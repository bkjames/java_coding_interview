package test;
import java.util.*;

public class CheapestFlightWithinKStops {

	public static void main(String[] args) {
		int n = 3,src = 0, dst = 2, k = 1;
		int[][] flights	 = {{0,1,100},{1,2,100},{0,2,500}};
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}
	
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
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
}

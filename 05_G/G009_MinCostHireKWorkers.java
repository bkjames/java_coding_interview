package zGoo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class G009_MinCostHireKWorkers {

	
	public static void main(String[] args) {
		int [] quality = {10,20,5};
		int [] wage = {70,50,30};
		int K = 2;
		System.out.println(mincostToHireWorkers(quality, wage, K));
	}
	
	package test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class G009_MinCostHireKWorkers {

	
	public static void main(String[] args) {
		int [] quality = {10,20,5};
		int [] wage = {70,50,30};
		int K = 2;
		System.out.println(mincostToHireWorkers_2(quality, wage, K));
	}
	
	 static class Node{
	        int q; // quality
	        double rate; // wage/quality
	        public Node(int quality,int wage){
	            q = quality;
	            rate = wage/(double)quality;
	        }
	    }
	    
	    public static double mincostToHireWorkers_2(int[] quality, int[] wage, int K) {
	        
	        //corner case
	        if(quality.length==1) return wage[0]; //length == 1 
	        
	        Node[] arr = new Node[quality.length];
	        
	        for(int i=0;i<arr.length;i++){
	            arr[i] = new Node(quality[i],wage[i]);
	        }
	        
	        Arrays.sort(arr,(a,b)->{       //O(n logn)
	            if(a.rate==b.rate){
	                return a.q - b.q;
	            }else{
	                
	                if(a.rate<b.rate){
	                    return -1; 
	                }else if(a.rate>b.rate){
	                    return 1;
	                }else{
	                    return 0;
	                }
	            }
	        });
	        
	        Queue<Integer> pq = new PriorityQueue<Integer>(K,(a,b)->b-a);
	        
	        int q_sum = 0;
	        
	        double min = Double.MAX_VALUE;
	        
	        for(int i=0;i<arr.length;i++){  // O(n logk)
	            
	            if(pq.size()==K){
	                q_sum-=pq.poll();     //O(log k)
	            }
	            pq.offer(arr[i].q);     //O(log k)
	            q_sum+=arr[i].q;
	            
	            if(i>=K-1){
	                //update the min
	                min = Math.min(min, q_sum*arr[i].rate);
	            }
	        }
	        
	        return min;
	        
	    }
	
}
	public static double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}

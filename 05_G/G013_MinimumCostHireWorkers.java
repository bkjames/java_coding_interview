package zGoo1;

import java.util.*;

public class G013_MinimumCostHireWorkers {

	public static void main(String[] args) {
		
		G013_MinimumCostHireWorkers a = new G013_MinimumCostHireWorkers();
		int[] quality = {10,20,5}, wage = {70,50,30};
		int K = 2;
		System.out.println(a.mincostToHireWorkers(quality, wage, K));
	}
	
   public double mincostToHireWorkers(int[] q, int[] w, int K) {
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
   
   public double mincostToHireWorkers2(int[] quality, int[] wage, int K) {       
       int numWorkers = quality.length;
       
       /* qualityRatio[i] = {quality, wage[i] / quality[i]}. */
       double[][] qualityRatio = new double[numWorkers][2];
       
       for (int i = 0; i < numWorkers; i++) {
           qualityRatio[i][0] = quality[i];
           qualityRatio[i][1] = (double) wage[i] / quality[i];
       }
       
       Arrays.sort(qualityRatio, (a, b) -> Double.compare(a[1], b[1]));
       double minSumSalary = Integer.MAX_VALUE;
       int sumQuality = 0;;
       
       /* Always remove maximum quality. */
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
       
       for (int i = 0; i < numWorkers; i++) {
           maxHeap.add((int)qualityRatio[i][0]);
           sumQuality += qualityRatio[i][0];
           if (maxHeap.size() > K) {
               int qualityPolled = maxHeap.poll();
               sumQuality -= qualityPolled;
           }        
           if (maxHeap.size() == K) {
               
               /* Calculate sumSalary. */
               double curRatio = qualityRatio[i][1];
               minSumSalary = Math.min(minSumSalary, sumQuality * curRatio);
           }
       }
       
       return minSumSalary;
   }
}

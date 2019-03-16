import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TG43_SkyLine {

	public static void main(String[] args) {
		int[][] nums = { {2, 9, 10}, {3 ,7, 15}, {5 ,12, 12}, {15, 20, 10}, {19, 24, 8} };
		List<int[]> result = getSkyline(nums);
		print(result);
	}
	public static void print(List<int[]> val) {
		for(int i=0; i<val.size();i++) {
			int[] result = val.get(i);
			for(int aa : result) {
				System.out.print("val : "+aa);
			}
			System.out.println();
		}
	}
	
	 public List<int[]> getSkyline(int[][] buildings) {
	        return merge(buildings, 0, buildings.length-1);
	    }
	    
	    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
	        LinkedList<int[]> res = new LinkedList<>();
	        if(lo > hi) {
	            return res;
	        } else if(lo == hi) {
	            res.add(new int[]{buildings[lo][0], buildings[lo][2]});
	            res.add(new int[]{buildings[lo][1], 0});
	            return res;
	        } 
	        int mid = lo+(hi-lo)/2;
	        LinkedList<int[]> left = merge(buildings, lo, mid);
	        LinkedList<int[]> right = merge(buildings, mid+1, hi);
	        int leftH = 0, rightH = 0;
	        while(!left.isEmpty() || !right.isEmpty()) {
	            long x1 = left.isEmpty()? Long.MAX_VALUE: left.peekFirst()[0];
	            long x2 = right.isEmpty()? Long.MAX_VALUE: right.peekFirst()[0];
	            int x = 0;
	            if(x1 < x2) {
	                int[] temp = left.pollFirst();
	                x = temp[0];
	                leftH = temp[1];
	            } else if(x1 > x2) {
	                int[] temp = right.pollFirst();
	                x = temp[0];
	                rightH = temp[1];
	            } else {
	                x = left.peekFirst()[0];
	                leftH = left.pollFirst()[1];
	                rightH = right.pollFirst()[1];
	            }
	            int h = Math.max(leftH, rightH);
	            if(res.isEmpty() || h != res.peekLast()[1]) {
	                res.add(new int[]{x, h});
	            }
	        }
	        return res;
	    }
	    
	    
	 public List<int[]> getSkyline(int[][] buildings) {
	        List<int[]> res = new ArrayList<>();
	        List<int[]> height = new ArrayList<>();
	        for (int[] building : buildings) {
	            // start point has negative height value
	            height.add(new int[]{building[0], -building[2]});
	            // end point has normal height value
	            height.add(new int[]{building[1], building[2]});
	        }
	        Collections.sort(height, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	                if (a[0] == b[0]) {
	                    return a[1] - b[1];
	                } else {
	                    return a[0] - b[0];
	                }
	            }
	        });
	        // Use a maxHeap to store possible heights
	        // But priority queue does not support remove in lgn time
	        // treemap support add, remove, get max in lgn time, so use treemap here
	        // key: height, value: number of this height
	        TreeMap<Integer, Integer> pq = new TreeMap<>();
	        pq.put(0, 1);
	        // Before starting, the previous max height is 0;
	        int prev = 0;
	        // visit all points in order
	        for (int[] h : height) {
	            // a start point, add height
	            if (h[1] < 0) {
	                pq.put(-h[1], pq.getOrDefault(-h[1], 0) + 1);
	            } else {  // a end point, remove height
	                if (pq.get(h[1]) > 1) {
	                    pq.put(h[1], pq.get(h[1]) - 1);
	                } else {
	                    pq.remove(h[1]);
	                }
	            }
	            int cur = pq.lastKey();
	            // compare current max height with previous max height, update result and 
	            // previous max height if necessary
	            if (cur != prev) {
	                res.add(new int[]{h[0], cur});
	                prev = cur;
	            }
	        }
	        return res;
	    }
	
	public static List<int[]> getSkyline(int[][] buildings) {
	    List<int[]> result = new ArrayList<>();
	    List<int[]> height = new ArrayList<>();
	    for(int[] b:buildings) {
	        height.add(new int[]{b[0], -b[2]});
	        height.add(new int[]{b[1], b[2]});
	    }
	    Collections.sort(height, (a, b) -> {
	            if(a[0] != b[0]) 
	                return a[0] - b[0];
	            return a[1] - b[1];
	    });
	    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
	    pq.offer(0);
	    int prev = 0;
	    for(int[] h:height) {
	        if(h[1] < 0) {
	            pq.offer(-h[1]);
	        } else {
	            pq.remove(h[1]);
	        }
	        int cur = pq.peek();
	        if(prev != cur) {
	            result.add(new int[]{h[0], cur});
	            prev = cur;
	        }
	    }
	    return result;
	}
}

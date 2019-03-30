package zGoo1;
import java.util.*;

public class G012_KClosest {
	
	public static void main(String[] args) {
		int[][] points = {{1,3},{-2,2}};
		int k =1;
		G012_KClosest a = new G012_KClosest();
		int[][] result = a.kClosest(points, k);
		a.print(result);
	}
	public void print(int[][] result) {
		for(int i=0; i< result.length; i++) {
			for(int j=0; j< result[0].length; j++) {
				System.out.println(result[i][j]);
			}
		}
	}
	
	 public int[][] kClosest(int[][] points, int K) {
	        int [][] result = new int[K][];
	        Arrays.sort(points, new Comparator<int[]>()
	        {
	            @Override public int compare(int[] ints, int[] t1)
	            {
	                return (ints[0]*ints[0] + ints[1]*ints[1]) - (t1[0]*t1[0] + t1[1]*t1[1]);
	            }
	        });
	        for(int i = 0 ; i < K ; i ++) {
	            result[i] = points[i];
	        }
	        return result;
	    }

//	 public int[][] kClosest(int[][] points, int K) {
//	        Queue<int[]> queue=new PriorityQueue<>((a, b) -> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
//	        int[][] res=new int[K][2];
//	        int index=0;
//	        for(int[] arr:points) {
//	            queue.add(arr);
//	        }
//	        while(index<K) {
//	            res[index]=queue.poll();
//	            index++;
//	        }
//	        return res;
//	    }
}

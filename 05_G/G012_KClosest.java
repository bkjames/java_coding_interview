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

import java.util.*;

public class KClosest {

	public static void main(String[] args) {
		int[][] points = {{1,3},{-2,2}};
		int K =1;
		KClosest a = new KClosest();
//		int[][] result = a.kClosest(points, k);
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=0; i<points.length; i++) {
			List<Integer> sList= new ArrayList<Integer>();
			for(int j=0; j<points[i].length; j++) {
				sList.add(points[i][j]);
			}
			list.add(sList);
		}
		a.kClosest(list, K);
//		a.print(points);
	}
	
	public int[][] kClosest(List<List<Integer>> list, int K) {
       
		print(list);
		Collections.sort(list, comp);
		System.out.println("=====");
		print(list);
       
        return null;
    }
	
	void print(List<List<Integer>> list) {
		for(int i=0; i<list.size();i++) {
			List<Integer> sList =list.get(i);
			for(int j=0; j<sList.size(); j++) {
				Integer ii= sList.get(j);
				System.out.println("ii: "+ii);
			}
		}
	}
	
	Comparator<List<Integer>> comp = new Comparator<List<Integer>>() {

		@Override
		public int compare(List<Integer> a, List<Integer> b) {
			// TODO Auto-generated method stub
			return a.get(0)* a.get(0)+ a.get(1)*a.get(1)-
					b.get(0)*b.get(0) + b.get(1)*b.get(1);
		}
		
	};

	public void print(int[][] result) {
		for(int i=0; i< result.length; i++) {
			for(int j=0; j< result[0].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}


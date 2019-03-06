package TopG100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {
		
		int [][] nums = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(nums);
	}
	  public static int[][] reconstructQueue(int[][] people) {
	        Arrays.sort(people, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                if (a[0] != b[0]) {
	                    return a[0] - b[0];
	                } else {
	                    return b[1] - a[1];
	                }
	            } 
	        });
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < people.length; i++) {
	            list.add(i);
	        }
	        int[][] res = new int[people.length][2];
	        for (int i = 0; i < people.length; i++) {
	            int index = list.get(people[i][1]);
	            res[index][0] = people[i][0];
	            res[index][1] = people[i][1];
	            list.remove(people[i][1]);
	        }
	        return res;
	    }
}

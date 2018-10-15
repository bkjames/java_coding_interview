package code04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconByHeight {

	public static void main(String[] args) {
		int[][] nums = {
				{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}	
		};
		int[][] result = reconstructQueue(nums);
		print(result);
	}
	public static void print(int[][] array) {
	     // 2차원 배열 array를 출력합니다.
        for(int i = 0 ; i < array.length; i++) {
            System.out.print( (i+1) + " print >");
            for(int j = 0; j< array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println("");
        }
    }
	
	

	public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return b[0] - a[0];
                else return a[1] - b[1];
            }
        });
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            tmp.add(people[i][1], people[i]);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < tmp.size(); i++) {
            res[i][0] = tmp.get(i)[0];
            res[i][1] = tmp.get(i)[1];
        }
        return res;
	}
	
	public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] p1, int[] p2) -> {
            if (p1[0] != p2[0]) {
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        LinkedList<int[]> ret = new LinkedList<>();
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            int[] p = people[i];
            while (p[1] < ret.size()) {
                stack.push(ret.pop());
            }
            while (p[1] > ret.size()) {
                ret.push(stack.pop());
            }
            ret.push(p);
        }
        while (!stack.isEmpty()) {
            ret.push(stack.pop());
        }
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            result[i] = ret.pollLast();
        }
        return result;
    }
}

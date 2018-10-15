package code04;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber2(nums));
	}
	
	public static int singleNumber(int[] A) {
		int x = 0;
		for (int a : A) {
			x = x ^ a;
		}
		return x;
	}
	
	public static int singleNumber2(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : A) {
			if (!set.add(n))
				set.remove(n);
		}
		Iterator<Integer> it = set.iterator();
		return it.next();
	}
}

package Basic;

import java.util.Collections;
import java.util.HashMap;

public class A001_FruitIntoBasket {
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,2};
		totalFruit(nums);
	}
	
	public static int totalFruit(int[] tree) {
        int start = 0;
        int n = tree.length;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < n; end++) {
            map.put(tree[end], end);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(tree[minIndex]);
                start = minIndex + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

//	public int totalFruit(int[] tree) {
//	    int max = 0, count = 0;
//	    for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
//	        count++;
//	        if (tree[i] == tree[first]) {
//	            first = i;
//	        } else if (second == -1 || tree[i] == tree[second]) {
//	            second = i;
//	        } else {
//	            max = Math.max(count - 1, max);
//	            count = Math.abs(first - second) + 1;
//	            first = i - 1;
//	            second = i;
//	        }
//	    }
//	    return Math.max(count, max);
//	}
//	
//	public int totalFruit(int[] tree) {
//        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
//        int res = 0, i = 0;
//        for (int j = 0; j < tree.length; ++j) {
//            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
//            while (count.size() > 2) {
//                count.put(tree[i], count.get(tree[i]) - 1);
//                if (count.get(tree[i]) == 0) count.remove(tree[i]);
//                i++;
//            }
//            res = Math.max(res, j - i + 1);
//        }
//        return res;
//    }
}

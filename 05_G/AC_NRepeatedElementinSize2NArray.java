package Problems;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,3};
		repeatedNTimes(nums);
	}
	public static int repeatedNTimes(int[] A) {
        Set<Integer> uniqueNums = new HashSet<>();
        int result = 0;
        for (int num : A){
            if (uniqueNums.contains(num)) {
                result = num;
                break;
            }
            uniqueNums.add(num);
        }
        return result;
    }
}

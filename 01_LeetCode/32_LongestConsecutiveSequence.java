package aExe07;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));
	}
	
	
public int longestConsecutive(int[] nums) {
    if(nums.length==0) return 0;
    //num -> length;
    Map<Integer, Integer> map = new HashMap<>();
    int max = 1;
    for(int num:nums)
    {
        if(map.containsKey(num)) continue;
        int left = 0, right = 0, len = 0;
        if(map.containsKey(num-1)&&map.containsKey(num+1))
        {
            left = num - map.get(num-1);
            right = num + map.get(num+1);
            len = right - left + 1;
            map.put(left, len);
            map.put(right, len);
            map.put(num, 1);
        }else if(map.containsKey(num-1))
        {
            left = num - map.get(num-1);
            len = map.get(num-1) + 1;
            map.put(left, len);
            map.put(num, len);
        }else if(map.containsKey(num+1))
        {
            right = num + map.get(num+1);
            len = map.get(num+1) + 1;
            map.put(num, len);
            map.put(right, len);
        }else
            map.put(num, 1);          
        max = Math.max(max, len);
    }
    return max;        
}

	public static int longestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
	 
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
	 
		for (int e : num)
			set.add(e);
	 
		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
	 
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
	 
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
	 
			max = Math.max(count, max);
		}
	 
		return max;
	}
}

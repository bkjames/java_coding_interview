package Problems;

import java.util.*;

public class TG28_SummaryRanges {
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		System.out.println(summaryRanges(nums));
	}
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> list=new ArrayList();
		if(nums.length==1){
			list.add(nums[0]+"");
			return list;
		}
		for(int i=0;i<nums.length;i++){
			int a=nums[i];
			System.out.println("a: "+a);
			while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
				i++;
				System.out.println("i: "+i);
			}
			if(a!=nums[i]){
				System.out.println("a: "+a+" nums[i]: "+nums[i]);
				list.add(a+"->"+nums[i]);
			}else{
				list.add(a+"");
			}
		}
		return list;
	 }
}

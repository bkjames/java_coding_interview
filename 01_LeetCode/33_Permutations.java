import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums= {1,2,3};
		Permutations a = new Permutations();
		System.out.println(a.permute3(nums));
	}
	
	
	public  List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null)
			return res;

		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[0]); // Add the first element into the list;
		res.add(list);
		for (int i = 1; i < nums.length; i++) {
			// Keep track of the size of current result;
			int size = res.size();
			for (int j = 0; j < size; j++) {
				int size2 = res.get(0).size();
				for (int k = 0; k <= size2; k++) {
					List<Integer> temp = new ArrayList(res.get(0));
					temp.add(k, nums[i]);
					res.add(temp);
				}
				res.remove(0);
			}
		}
		return res;
	}
	
	
	 int count=-1;
	
	public  List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums,count);
		   return list;
		}

		private  void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int count){
			count++;
		    System.out.println("count: "+count);
		   
		    if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		    	  System.out.println("i: "+i+" nums["+i+"] "+nums[i]);
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);

		         backtrack(list, tempList, nums, count);
		         tempList.remove(tempList.size() - 1);
		         System.out.println(tempList+"====end====="+i+"=count="+count);
		         System.out.println();
		      }
		   }
		} 
		
		
		
		
		public  List<List<Integer>> permute2(int[] num) {
		    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		    res.add(new ArrayList<Integer>());
		    for (int n : num) {
		        int size = res.size();
		        for (; size > 0; size--) {
		            List<Integer> r = res.pollFirst();
		            for (int i = 0; i <= r.size(); i++) {
		                List<Integer> t = new ArrayList<Integer>(r);
		                t.add(i, n);
		                res.add(t);
		            }
		        }
		    }
		    return res;
		}
}



package aExe04;

import java.util.ArrayList;

public class Permutation {
	public static void main (String[] args) {
		Permutation p = new Permutation();
		int[] nums = {1,2,3};
		System.out.println(p.permute(nums));
	}
	
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}
	 
	void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}

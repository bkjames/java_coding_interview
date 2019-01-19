package ama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	static int count=0; 
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		subsets(nums);
		subsets2(nums);
	}
	
	   public static List<List<Integer>> subsets2(int[] S) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        dfs(S, 0, new ArrayList<Integer>(), result);
	        return result;
	    }

	    public static void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
	        result.add(new ArrayList<Integer>(path));

	        for(int i = index; i < s.length; i++){
	            path.add(s[i]);
	            dfs(s, i+1, path, result);
	            path.remove(path.size()-1);
	        }
	    }
	

	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		count++;
		System.out.println("count: "+count);
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
//	    	System.out.println("start: "+start);
	        tempList.add(nums[i]);
	        System.out.println("tempList: "+tempList);
	        backtrack(list, tempList, nums, i + 1);
	        System.out.println("tempList.size()  "+tempList+" "+(tempList.size() - 1));
	        tempList.remove(tempList.size() - 1);
	    }
	}
	}

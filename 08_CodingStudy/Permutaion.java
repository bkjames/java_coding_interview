
import java.util.*;

public class Test {

	public static void main(String[] args) {
		Test a = new Test();
		int[] nums = {1,2,3};
		System.out.println(a.permute_backTrack(nums));
	}
	
	public List<List<Integer>> permute_backTrack(int[] nums) {
	    List<List<Integer>> lists = new ArrayList<>();
	    if (nums == null || nums.length == 0) {
	        return lists;
	    }

	    dfs(nums, lists, new ArrayList<Integer>());
	    return lists;
	}
int kk =0;
private void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
		
		//System.out.println("--start--"+cur);
		
	    if (cur.size() == nums.length) {
	        List<Integer> list = new ArrayList<>(cur);
	        lists.add(list);
	    }
	   //System.out.println("--lists--"+lists);
	    for (int i = 0; i < nums.length; i++) {
	   	    System.out.println("i: "+i+" nums[" + i + "]=" + nums[i]);
	    
	    	
	        if (cur.contains(nums[i])) {
	            continue;
	        }
	     
//	        if (cur.size() == nums.length) {
//	        	continue;
//		    }
	        kk++;
	 	    System.out.println("size = " + lists + " : " + cur+" kk "+kk);
	 
	    	
	        cur.add(nums[i]);
	        dfs(nums, lists, cur);
	        System.out.println("cur = " + cur );
	        cur.remove(cur.size() - 1);
	        System.out.println("cur.remove = " + cur );
	        
	    }
	   
	    //System.out.println("--end--"+cur);
	    System.out.println("--end-");
	}
	
	
	
	
}

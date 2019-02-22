import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		CombinationSum a = new CombinationSum();
		System.out.println(a.combinationSum(candidates, target));
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] subres = new int[candidates.length];
        combo(candidates, target, res, subres, 0, 0);
        return res;
    }
    
    private void combo(int[] candidates, int target, List<List<Integer>> res, int[] subres, int sum, int index) {
    	System.out.println("combo sum: "+sum);
        if (sum > target) {
//        	System.out.println("return value: "+ subres);
        	return;
        }
        
        if (sum >= target) {
            List<Integer> list = new ArrayList<>();
          
            for (int i = 0; i < subres.length; i++) {
                for (int j = 0; j < subres[i]; j++) {
                	System.out.println("subres[i]: "+subres[i]+" candidates["+i+"] "+ candidates[i]);
                    list.add(candidates[i]);
                    System.out.println("$$$$$Stored==="+list);
                }
            }
            
            res.add(list);
            return;
        }
        
        for (int i = index; i < subres.length; i++) {
        	System.out.println("==i==="+i);
            subres[i]++;
            System.out.println("sum+can[i]:"+(sum + candidates[i])+"  sum: "+sum+" candidates["+i+"] "+ candidates[i]+" subres: "+subres[i]);
            combo(candidates, target, res, subres, sum + candidates[i], i);
            subres[i]--;
        }
        System.out.println("====end===index=="+index);
        System.out.println();
    }
//	  public List<List<Integer>> combinationSum(int[] candidates, int target) {
//	        return combinationSum(candidates, target, 0);
//	    }
//	    
//	    public List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
//	        
//	        List<List<Integer>> res = new ArrayList<List<Integer>>();
//	        Arrays.sort(candidates);
//	        for (int i = start; i < candidates.length; i++) {
//	        	System.out.println(i+" candidates["+i+"] "+candidates[i]+" target: "+target);
//	            if (candidates[i] <target) {
//	                for (List<Integer> ar : combinationSum(candidates, target - candidates[i], i)) {
//	                    ar.add(0, candidates[i]);
//	                    res.add(ar);
//	                }
//	            } else if (candidates[i] == target) {
//	                List<Integer> lst = new ArrayList<>();
//	                lst.add(candidates[i]);
//	                res.add(lst);
//	            } else
//	                break;
//	        }
//	        return res;
//	    }
}

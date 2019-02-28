package Accept;

import java.util.HashMap;

public class FindAnagramsMapping {
	
	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		int [] result = anagramMappings(A, B);
		print(result);
	}
	
	public static void print(int[] result) {
		for(int i=0; i< result.length; i++) {
			System.out.println(result[i]);
		}
	}

	    public static int[] anagramMappings(int[] A, int[] B) {
	        int l = A.length;
	        int[] res = new int[l];
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<l;i++){
	            map.put(B[i],i);
	        }
	        for(int i=0;i<l;i++){
	            res[i] = map.get(A[i]);
	        }        
	        return res;
	    }
	    
//	    
//	    public int[] anagramMapping(int[] A, int[] B) {
//	    	int l = A.length;
//	    	int[] res = new int[l];
//	    	
//	    	HashMap<Integer, Integer> map  = new HashMap<>();
//	    	for(int i=0; i< l; i++) {
//	    		map.put(B[i], i);
//	    	}
//	    	for(int i=0; i<l; i++) {
//	    		res[i] = map.get(A[i]);
//	    	}
//	    	
//	    	return res;
//	    }
	
}

package p1;

public class G099_ValidMountainArray {

	public static void main(String[] args) {
		int[] A = {0,3,2,1};
		System.out.println(validMountainArray(A));
	}
	 public static boolean validMountainArray(int[] A) {
	        if(A.length<3) return false;
	        int max_index = 0;
	        for(int i=1;i<A.length;i++){
	        	
	        	System.out.println("A["+i+"] "+(A[i])+" A["+max_index+"] "+A[max_index]);
	            if(A[i]>A[max_index]) {
	            	System.out.println("===A["+i+"] "+(A[i])+" A["+max_index+"] "+A[max_index]);
	            	max_index = i;
	            }
	        }
	        if(max_index == 0 || max_index == A.length-1) return false;
	        
	        for(int i=0;i<max_index;i++){
	           if(A[i]<A[i+1]) continue;
	           else return false; 
	        }
	            
	        for(int i=max_index;i<A.length-1;i++){
	            if(A[i]>A[i+1]) continue;
	            else return false;
	        }
	            
	        return true;
	    }
}

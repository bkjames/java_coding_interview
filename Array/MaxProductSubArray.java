package aF01;

public class MaxProductSubArray {
	
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,-2,4};
		
		MaxProductSubArray a = new MaxProductSubArray();
		System.out.println(a.maxProduct(arr));
	}
	
	public int maxProduct(int[] A) {
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<A.length; i++) {
			for(int l=0; l<A.length; l++) {
				if(i+l <A.length) {
					int product = calProduct(A, i, l);
					max = Math.max(product, max);
				}
				
			}
			
		}
		return max;
	}
	
	public int calProduct(int[] A, int i, int j){
		int result = 1;
		for(int m=i; m<=j; m++){
			result = result * A[m];
		}
		return result;
		}
	
	

}

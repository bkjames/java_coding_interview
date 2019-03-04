package Basic;

public class FlippingAnImage {
	
	public static void main(String[] args) {
		
//		int[][] nums =  {{1,1,0},{1,0,1},{0,0,0}};
		int[][] nums = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		FlippingAnImage a = new FlippingAnImage();
		int[][] result = a.flipAndInvertImage(nums);
		a.print(result);
	}
	
	public void print(int[][] result) {
		int m = result.length;
		int n = result[0].length;
		
		for(int i=0 ; i< m ; i++) {
			for(int j=0; j< n; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
	
	 public int[][] flipAndInvertImage(int[][] A) {
	        int invertedImage[][] = new int[A.length][];
	        for(int i = 0; i < A.length; i++)
	        {
	           int rev[] = reverseNum(A[i]);
	           int inv[] = inverseNum(rev);
	           invertedImage[i] = inv;  
	        }
	        return invertedImage;
	    }
	    
	    private int[] reverseNum(int num[])
	    {
	        for(int i = 0; i < (num.length)/2; i++)
	        {
	        	System.out.println("num["+i+"] "+ num[i]);
	            int temp = num[i];
	            num[i]  = num[num.length - i - 1];
	            num[num.length - i - 1] = temp;
	        }
	        return num;
	    }
	    
	    private int[] inverseNum(int num[])
	    {
	        for(int i = 0; i < num.length; i++)
	        {
	             num[i] = num[i]^1;
	        }
	        return num;
	    }
	    
	    
	    public int[][] flipAndInvertImage2(int[][] A) {
	        int m = A.length, n = A[0].length;
	        for(int i = 0; i < m; i++){
	            swap(A[i]);
	        }
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(A[i][j] == 0){
	                    A[i][j] = 1;
	                }else{
	                    A[i][j] = 0;
	                }
	            }
	        }
	        return A;
	    }
	    private void swap(int[] a){
	        int left = 0, right = a.length - 1;
	        while(left <= right){
	            int t = a[left];
	            a[left] = a[right];
	            a[right] = t;
	            left++; right--;
	        }
	    }
	    
	    

//	public int[][] flipAndInvertImage(int[][] A) {
//        for (int i = 0; i < A.length; i++) {
//            int lo = 0, hi = A[0].length - 1;
//            while (lo <= hi) {
//                if (A[i][lo] == A[i][hi]) {
//                    A[i][lo] = 1 - A[i][lo];
//                    A[i][hi] = A[i][lo];
//                }
//                lo++;
//                hi--;
//            }
//        }
//        
//        return A;
//    }
}

package code;

public class secArray {


	    public static void main(String[] args) {
	        int [][] array = {{1,0,0,0}, {1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
	        
	        // 2차원 배열 array를 출력합니다.
	        for(int i = 0 ; i < array.length; i++) {
	            System.out.print( (i+1) + " print >");
	            for(int j = 0; j< array[i].length; j++) {
	                System.out.print(array[i][j]+" ");
	            }
	            System.out.println("");
	        }
	    }
	
}

package array;

public class MoveZero_end {

	    public static void main(String args[]) {
	        //1
	        int[] inputArray = {3, 2, 1, 0, 4, 0, 0, 2, 7, 0, 50, 0, 6, 8, 9, 0, 9, 1, 0, 8, 5};
	        //2
	        int currentIndex = 0;
	        //3
	        for (int i = 0; i < inputArray.length; i++) {
	           //4
	            if (inputArray[i] != 0) {
	                inputArray[currentIndex] = inputArray[i];
	                currentIndex++;
	            }
	        }
	        //5
	        while (currentIndex < inputArray.length) {
	            inputArray[currentIndex] = 0;
	            currentIndex++;
	        }
	        //6
	        for (int i = 0; i < inputArray.length; i++) {
	            System.out.print(inputArray[i]+",");
	        }
	    }
	}

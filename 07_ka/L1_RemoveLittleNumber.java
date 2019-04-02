package real;

public class L1_RemoveLittleNumber {
	
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		
		L1_RemoveLittleNumber a = new L1_RemoveLittleNumber();
		int[] r = a.solution(arr);
		for(Integer i: r)
			System.out.println(i);
	}
	
	 public int[] solution(int[] arr) {
	      int[] answer;
	      if(arr.length==1) {
	    	  return new int[]{-1};
	      }
	      
	      answer = new int[arr.length-1];
	      
	      int min = Integer.MAX_VALUE;
	      int index =0;
	      for(int i=0; i< arr.length; i++) {
	    	  if(arr[i]<min) {
	    		  min =arr[i];
	    		  index = i;
	    	  }
	      }
	      
	      for(int i=0, j=0; i<answer.length; i++, j++) {
	    	  if(index==i) j++;
	    	  answer[i]= arr[j];
	      }
	      
	      return answer;
	  }
	 
	 public int[] solution2(int[] arr) {
	      if (arr.length == 1) {
	            arr[0] = -1;
	            return arr;
	        } else {
	            ArrayList<Integer> arrayList = new ArrayList<Integer>();
	            for (int a : arr) {
	                arrayList.add(a);
	            }
	            Integer minimum = Collections.min(arrayList);
	            arrayList.remove(minimum);
	            int[] resultArray = new int[arr.length - 1];
	            for (int i = 0; i < arrayList.size(); ++i) {
	                resultArray[i] = arrayList.get(i);
	            }
	            return resultArray;
	        }
	  }
	 
	 public int[] solution3(int[] arr) {
	      if(arr.length <= 1) return new int[]{-1};
	      int minIndex = 0;
	      for(int i = 1; i < arr.length; i++){
	          if(arr[minIndex] > arr[i]){
	              minIndex = i;
	          }
	      }
	      int[] answer = new int[arr.length - 1];
	      int i = 0;
	      int j = 0;
	      while(i < answer.length){
	          if(j == minIndex){
	            j++;
	            continue;  
	          } 
	          answer[i++] = arr[j++];
	      }
	      return answer;
	  }

}

package real;
import java.util.*;

public class L1_NotSameNumber {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		L1_NotSameNumber a = new L1_NotSameNumber();
		int[] res = a.solution(arr);
		for(int i : res)
			System.out.println(i);
		
	}
	
	public int[] solution(int []arr) {
      
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0 ; i< arr.length; i++) {
        	
        	if(map.containsKey(arr[i])) {
//        		map.get(arr[i])
        	}else {
        		map.put(arr[i], 1);
        	}
        }
        int index =0;
        int mapSize = map.size();
        int[] answer = new int[mapSize];
        for(Integer i : map.keySet())
        	if(map.get(i) ==1) {
        		answer[index++]=i;
        	}
        
//        for(int i=0; i<mapSize ;i++) {
//        	answer[i]=answer[i];
//        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
	}
	
	 public int[] solution(int []arr) {
		    int[] answer = {};
		 
		        List<integer> a = new ArrayList<integer>();//가변 배열 설정
		 
		        a.add(arr[0]);//비교 기준점 설정
		 
		        for(int i=0;i<arr.length;i++) {
		            if(a.get(a.size()-1)!=arr[i]) {
		                a.add(a.size(), arr[i]);
		            }
		        }
		        answer = new int[a.size()];
		 
		        int j=0;
		        for(int n:a) {                     
		            answer[j++]=n;          
		        }
		        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		        System.out.println("Hello Java");
		 
		        return answer;
		    }
	
	 public int[] solution(int []arr) {
	        ArrayList<integer> tempList = new ArrayList<integer>();
	        int preNum = 10;
	        for(int num : arr) {
	            if(preNum != num)
	                tempList.add(num);
	            preNum = num;
	        }       
	        int[] answer = new int[tempList.size()];
	        for(int i=0; i<answer.length; i++) {
	            answer[i] = tempList.get(i).intValue();
	        }
	        return answer;
	    }
}

package real;
import java.util.*;
public class L2_Truck {

	public static void main(String[] args) {
		int bridge_length=2,  weight=10;
		int[] truck_weights = {7,4,5,6};
		L2_Truck a = new L2_Truck();
		System.out.println(a.solution(bridge_length, weight, truck_weights));
	}
	
	
  public int solution(int bridge_length, int weight, int[] truck_weights) {
	  int answer = 0;
	  Queue<Integer> bridQ = new LinkedList<>();
	  Queue<Integer> waitQ = new LinkedList<>();
	  int wCnt=0;
	  for (int i = 0; i < bridge_length; i++) {
	      bridQ.offer(0);
	  }
	  for (int i = 0; i < truck_weights.length; i++) {
	      waitQ.offer(truck_weights[i]);
	      while(!waitQ.isEmpty()) {
	          answer++;
	          wCnt -= bridQ.poll();
	
	          if(wCnt + waitQ.peek() > weight) {
	              bridQ.offer(0);
	          }else {
	              wCnt += waitQ.peek();
	              bridQ.offer(waitQ.poll());
	          }
	//        System.out.println(answer + " : " +bridQ.toString());
	      }
	  }
	  while(!bridQ.isEmpty()) {
	//    System.out.println(answer + " : " +bridQ.toString());
	      bridQ.poll();
	      answer++;
	  }
	//  System.out.println(answer);
	  return answer;
}
	
//	class Truck{
//		
//		int weight;
//		int time;
//		Truck(int weight, int time){
//			this.weight = weight;
//			this.time = time;
//		}
//	}
//	 public int solution(int bridge_length, int weight, int[] truck_weights) {
//	        int time = 0;
//	        int weightLeft = weight;
//	        Truck truck = null;
//	        
//	        Queue<Truck> outside = new LinkedList<Truck>();
//	        List<Truck> inside = new ArrayList<Truck>();
//	 
//	        for (int t : truck_weights) {
//	            outside.add(new Truck(t, bridge_length));
//	        }
//	 
//	        while (!(inside.isEmpty()&& outside.isEmpty())) {
//	            time++;
//	            
//	            if (!inside.isEmpty() && inside.get(0).time <= 0) {
//	                weightLeft += inside.get(0).weight;
//	                inside.remove(0);
//	            }
//	            
//	            if (!outside.isEmpty() && weightLeft - outside.peek().weight >= 0) {
//	                weightLeft -= outside.peek().weight;
//	                inside.add(outside.poll());
//	            }
//	            
//	            for (int i = 0; i < inside.size(); i++) {
//	                truck = inside.get(i);
//	                truck.time--;
//	            }
//	        }
//	        return time;
//	    }
}


//import java.util.*;
//class Solution {
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        int answer = 0;
//        Queue<Integer> bridQ = new LinkedList<>();
//        Queue<Integer> waitQ = new LinkedList<>();
//        int wCnt=0;
//        for (int i = 0; i < bridge_length; i++) {
//            bridQ.offer(0);
//        }
//        for (int i = 0; i < truck_weights.length; i++) {
//            waitQ.offer(truck_weights[i]);
//            while(!waitQ.isEmpty()) {
//                answer++;
//                wCnt -= bridQ.poll();
//
//                if(wCnt + waitQ.peek() > weight) {
//                    bridQ.offer(0);
//                }else {
//                    wCnt += waitQ.peek();
//                    bridQ.offer(waitQ.poll());
//                }
////              System.out.println(answer + " : " +bridQ.toString());
//            }
//        }
//        while(!bridQ.isEmpty()) {
////          System.out.println(answer + " : " +bridQ.toString());
//            bridQ.poll();
//            answer++;
//        }
////        System.out.println(answer);
//        return answer;
//    }
//}

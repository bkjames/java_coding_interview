package aaa_ama_6mon;

import java.util.*;

class Interval {
	int start;
	int end;

	public Interval(int _start, int _end) {
		start = _start;
		end = _end;
	}
}

public class EmployeeTime {
	
	public static void main(String[] args) {
		
//		{{{1,2},{5,6}},{{1,3}},{{4,10}}}
		Interval in1 = new Interval(1,2);
		Interval in2 = new Interval(5,6);
		Interval in3 = new Interval(1,3);
		Interval in4 = new Interval(4,10);
		List<Interval> list = new ArrayList<>();
		list.add(in1);
		list.add(in2);
		list.add(in3);
		list.add(in4);
		List<List<Interval>> list2 = new ArrayList<>();
		list2.add(list);
		EmployeeTime a = new EmployeeTime();
		List<Interval> result = a.employeeFreeTime2(list2);
		a.print(result);
	}
	public void print(List<Interval> result) {
		
		for(int i=0; i<result.size(); i++) {
			Interval in = result.get(i);
			System.out.println(in.start+" "+in.end);
		}
	}
	
	  public List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
	        List<Interval> list = new ArrayList<>();
			
			//put all interval in the list and sort them
	        for(int i = 0 ; i < schedule.size(); i++){
	            List<Interval> perList = schedule.get(i);
	            for(int j = 0 ; j < perList.size() ; j++){
	                list.add(perList.get(j));
	            }
	        }
	        Collections.sort(list, new Comparator<Interval>(){
	            @Override
	            public int compare(Interval a, Interval b){
	                if(a.start < b.start){
	                    return -1;
	                }else if(a.start > b.start){
	                    return 1;
	                }else{
	                    return b.end - a.end ;
	                }
	            }
	        });
	        
	        List<Interval> inter = new ArrayList<>();
	        int prev = list.get(0).end;
	        
			//check those free intervals and put them in a list
	        for(int i = 1 ; i < list.size() ; i++){
	            Interval cur = list.get(i);
	            if(cur.start > prev){
	                inter.add(new Interval(prev,cur.start));
	            }
	            if(cur.end > prev){
	                prev = cur.end;
	            }
	        }   
	        
	        return inter;
	      
	    }
	
//	public List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {
//	List result = new ArrayList<>();
//
//    Queue queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
//    schedule.forEach(e -> queue.addAll(e));
//    int end = queue.poll().end;
//    while(!queue.isEmpty()) {
//        if(end < queue.peek().start) {
//            Interval interval = queue.poll();
//            result.add(new Interval(end, interval.start));
//            end = interval.end;
//        }else {
//            end = Math.max(end, queue.poll().end);
//        }
//    }
//    return result;
//}


}

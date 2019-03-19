package test01;

import java.util.*;
import java.util.Comparator;

class Interval{
	int start, end;
	Interval(){
		this.start =0;
		this.end =0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class MeetingRoom2 {

	public static void main(String[] args) {
		Interval in1 = new Interval(0, 30);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(15, 20);
		
		Interval[] intervals = {in1, in2, in3};
		MeetingRoom2 a = new MeetingRoom2();
//		System.out.println(a.minMeetingRoom(intervals));
		System.out.println(a.minMeetingRooms(intervals));
		
	}
	
	class Element{
        int val;
        boolean start;
        Element(int val, boolean start){
            this.val = val;
            this.start = start;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int max = 1;
        List<Element> lists = new ArrayList<Element>();
        for(int i = 0; i < intervals.length; i++){
            lists.add(new Element(intervals[i].start, true));
            lists.add(new Element(intervals[i].end, false));
        }
        int curr = 0;
        Collections.sort(lists, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                if(e1.val < e2.val){
                    return -1;
                }else if(e1.val > e2.val){
                    return 1;
                }else{
                    return e1.start == false ? -1 : 1;  
                }
            }
        });
        for(Element ele : lists){
            if(ele.start){
                curr++;
                max = Math.max(max, curr);
            }else{
                curr--;
            }
        }
        return max;
    }
    
    
	
	
	 private class Time {
	        int t;
	        Character type;
	        Time(int t, Character type) {
	            this.t = t;
	            this.type = type;
	        }
	    }

	    public int minMeetingRooms(Interval[] intervals) {

	        ArrayList<Time> list = new ArrayList<>();

	        for (int i = 0; i < intervals.length; i++) {
	            list.add(new Time(intervals[i].start, 's'));
	            list.add(new Time(intervals[i].end, 'e'));
	        }

	        Collections.sort(list, new Comparator<Time>() {
	            @Override
	            public int compare(Time o1, Time o2) {
	                if (o1.t != o2.t) {
	                    return o1.t - o2.t;
	                }
					// If time is the same, start time should be infront of end time in the sorting
	                if (o1.type == 's') {
	                    return 1;
	                } else {
	                    return -1;
	                }
	            }
	        });
	        int num = 0;
	        int res = 0;

	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).type == 's') {
	                num++;
	            } else {
	                num--;
	            }
	            res = Math.max(res, num);
	        }

	        return res;
	    }
	    
	    
//	    PQ
	    public int minMeetingRooms_PQ(Interval[] intervals) {
	        if(intervals == null || intervals.length == 0) {
	            return 0;
	        }
	        
	        Arrays.sort(intervals, new Comparator<Interval>() {
	            @Override
	            public int compare(Interval int1, Interval int2) {
	                return Integer.compare(int1.start, int2.start);
	            }
	        });
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        pq.add(intervals[0].end);
	        int roomRequired = 1;
	        
	        for(int i = 1; i<intervals.length; i++) {
	            Interval cur = intervals[i];
	            while(!pq.isEmpty() && cur.start >= pq.peek()) {
	                pq.poll();
	            }
	            pq.add(cur.end);
	            roomRequired = pq.size() > roomRequired ? pq.size() : roomRequired;
	        }
	        
	        return roomRequired;
	    }
	    
	
//	int minMeetingRoom(Interval[] intervals) {
//		Arrays.sort(intervals, comp);
//		
//		return helper(new ArrayList(Arrays.asList(intervals)));
//		
//	}
//	
//	int helper(List<Interval> list) {
//		if(list.size()==0) 
//			return 0;
//		Interval pre = list.get(0);
//		List<Interval> nextList = new ArrayList();
//		for(int i=1; i<list.size(); i++) {
//			Interval inter = list.get(i);
//			if(inter.start < pre.end) {
//				nextList.add(inter);
//			}else {
//				pre = inter;
//			}
//		}
//		System.out.println("nextList: "+nextList);
//		return 1+helper(nextList);
//		
//	}
//	
//	Comparator<Interval> comp = new Comparator<Interval>() {
//
//		@Override
//		public int compare(Interval a, Interval b) {
//			
//			return a.start-b.start;
//		}
//		
//	};
}

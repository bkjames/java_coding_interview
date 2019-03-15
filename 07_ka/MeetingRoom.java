package real;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


class Interval{
	int start, end;
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

class TimePoint implements Comparable<TimePoint>{
	int time, flag;
	TimePoint(int time, int flag){
		this.time = time;
		this.flag = flag;
	}
	@Override
	public int compareTo(TimePoint p) {
		// TODO Auto-generated method stub
		return this.time - p.time ==0?
				this.flag -p.flag: this.time-p.time;
	}
	
}

	public class MeetingRoom {

		public static void main(String[] args) {
			int[][] nums = {{0,4}, {5,10},{15,20}};
			Interval in = new Interval(0,4);
			Interval in2 = new Interval(5,10);
			Interval in3 = new Interval(15,20);
			
			List<Interval> list = new ArrayList<>();
			list.add(in);
			list.add(in2);
			list.add(in3);
			
//			Interval[] intervals = {in,in2,in3};
			
			System.out.println(canAttendMeeting(list));
		}
		
		public static boolean canAttendMeeting(List<Interval> intervals) {
			List<TimePoint> list = new LinkedList<>();
//			for(Interval interval: intervals) {
//				list.add(new TimePoint(interval.start, 1));
//				list.add(new TimePoint(interval.end,  -1));
//			}
		     for (Interval interval :intervals) {
		    	   list.add(new TimePoint(interval.start, 1));
		           list.add(new TimePoint(interval.end, -1));
		        }
		     Collections.sort(list);
		     
		     int count=0;
		     for(TimePoint p : list) {
		    	 System.out.println("start "+p.time+" "+p.flag);
		    	 count+= p.flag;
		    	 
		    	 if(count==2) return false;
		     }
		     
			return true;
			
		}
		
	}
	
    //2
    public static int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return 0;
        Collections.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
        pq.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++) {
            if(intervals.get(i).start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(intervals.get(i));
        }
        return pq.size();
    }
    
    public static int minMeetingRooms_array(Interval[] intervals) {
	      if(intervals == null || intervals.length == 0) return 0;
	      Arrays.sort(intervals,(a,b)->a.start-b.start);
	      PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
	      pq.add(intervals[0]);
	      for(int i=1; i<intervals.length; i++) {
	          if(intervals[i].start >= pq.peek().end) {
	              pq.poll();
	          }
	          pq.offer(intervals[i]);
	      }
	      return pq.size();
	      
	
	//1
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
        
        Comparator<Element> comp = new Comparator<Element>() {

			@Override
			public int compare(Element a, Element b) {
				// TODO Auto-generated method stub
				
				if(a.)
				return 0;
			}
        	
        };
        
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
    
    //2
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
        pq.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
    
    
    //3
    public int minMeetingRooms(Interval[] intervals) {
        if ( intervals.length < 2 ) return intervals.length;
        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval o1,Interval o2){
                return o1.start - o2.start;
            }
        });
        //min heap to track the min time of overrlapping intervals
        PriorityQueue <Interval> heap = new PriorityQueue<Interval>(intervals.length,new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.end - o2.end;
            }
        });
        heap.offer(intervals[0]);
        for (int i = 1; i<intervals.length;i++){
            Interval tmp = heap.poll();
            if (intervals[i].start<tmp.end){//if not disjoint time
                heap.offer(tmp);//need to put back since overlapping time
            }
            heap.offer(intervals[i]);
        }
        return heap.size();
    }

    
    //4
    public int minMeetingRooms(Interval[] intervals) {
    	if (intervals.length == 0) {
    		return 0;
    	}
    	// sort
    	Arrays.sort(intervals, new Comparator<Interval>() {
    		@Override
    		public int compare(Interval a, Interval b) {
    			return a.start - b.start;
    		}
    	});
    	// PriorityQueue
    	PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
    	ends.offer(intervals[0].end);
    	for (int i = 1; i < intervals.length; i++) {
    		if (intervals[i].start >= ends.peek()) { // no overlap, then should update smallest end.
    			ends.poll();
    		} 
    		ends.offer(intervals[i].end);
    	}
    	return ends.size();
    }

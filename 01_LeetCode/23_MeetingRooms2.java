package coding02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


class Interval{
	int start;
	int end;
	Interval(){
		start=0;
		end=0;
	}
	Interval(int s, int e){
		start=s;
		end=e;
	}
}

class TimePoint implements Comparable<TimePoint> {
    int time, flag;

    TimePoint(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }


    public int compareTo(TimePoint p) {
        return this.time - p.time == 0 ? this.flag - p.flag : this.time - p.time;
    }
}

public class MeetingRoom2 {
	
	public static void main(String[] args) {
		int[][] nums = {{0,30},{5,10},{15,20}};
		Interval in = new Interval(0,30);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(15,20);
		List<Interval> list = new ArrayList<>();
		list.add(in);
		list.add(in2);
		list.add(in3);
//		System.out.println(minMeetingRooms(list));
		
		Interval[] intervals = {in, in2,in3};
		System.out.println(minMeetingRooms2(intervals));
		
	}
	
	public static int minMeetingRooms2(Interval[] intervals) {
	    if(intervals==null||intervals.length==0)
	        return 0;
	 
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            return i1.start-i2.start;
	        }
	    });
	 
	    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	    int count=1;
	    queue.offer(intervals[0].end);
	 
	    for(int i=1; i<intervals.length; i++){
	        if(intervals[i].start<queue.peek()){
	            count++;
	 
	        }else{
	            queue.poll();
	        }
	 
	        queue.offer(intervals[i].end);
	    }
	 
	    return count;
	}
	
	public static int minMeetingRooms(List<Interval> intervals) {
        List<TimePoint> list = new LinkedList<>();
        for (Interval interval :intervals) {
            list.add(new TimePoint(interval.start, 1));
            list.add(new TimePoint(interval.end, -1));
        }
        Collections.sort(list);

        int rst = 0;
        int count = 0;
        for (TimePoint p : list) {
            count += p.flag;
            rst = Math.max(rst, count);
        }
        return rst;
    }

   
}

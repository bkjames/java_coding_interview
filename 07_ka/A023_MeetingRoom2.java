package zGoo1;

import java.util.*;


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
public class A023_MeetingRoom2 {

	public static void main(String[] args) {
		int[][] nums= {{0,4}, {5,10}, {15,20}};
		Interval in = new Interval(0,4);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(15,20);
		
		Interval[] intervals = {in, in2, in3};
		List<Interval> list = new ArrayList<>();
		list.add(in);
		list.add(in2);
		list.add(in3);
		A023_MeetingRoom2 a = new A023_MeetingRoom2();
		int val = a.minMeetingRooms(list);
		System.out.println(val);
	}
	
	
	public  int minMeetingRooms(List<Interval> intervals) {
        List<TimePoint> list = new LinkedList<>();
        for (Interval interval :intervals) {
            list.add(new TimePoint(interval.start, 1));
            list.add(new TimePoint(interval.end, -1));
        }
        Collections.sort(list);

        int rst = 0;
        int count = 0;
        for (TimePoint p : list) {
        	System.out.println("p.time: "+p.time+" p.flag: "+p.flag);
            count += p.flag;
            rst = Math.max(rst, count);
        }
        return rst;
    }

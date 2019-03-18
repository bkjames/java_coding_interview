package Problems;

import java.util.*;
class Interval{
	int start, end;
	Interval(){
		this.start=0;
		this.end = 0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
	
}
public class TG23_MeetingRoom2 {
	
	public static void main(String[] args) {
//		 [[0, 30],[5, 10],[15, 20]]
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
		
		
	}

	 public int minMeetingRooms(Interval[] intervals) {
	        Arrays.sort(intervals, new Comparator<Interval>(){
	           public int compare(Interval o1, Interval o2){
	               return o1.start - o2.start;
	           } 
	        });
	        return helper(new ArrayList(Arrays.asList(intervals)));
	    }
	    
	    private int helper(List<Interval> li){
	        if(li.size() == 0)
	            return 0;
	        Interval pre = li.get(0);
	        List<Interval> nextLi = new ArrayList();
	        for(int i=1;i<li.size();i++){
	            Interval inter = li.get(i);
	            if(inter.start < pre.end){
	                nextLi.add(inter);
	            }else{
	                pre = inter;
	            }
	        }
	        return 1 + helper(nextLi);
	    }
}

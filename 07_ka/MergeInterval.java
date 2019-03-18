package Test;

import java.util.*;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
 

public class MergeInterval {
	
	public static void main(String[] args) {
		
//		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval in1 = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		MergeInterval a = new MergeInterval();
		List<Interval> list = a.merge(intervals);
		a.print(list);
	}
	void print(List<Interval> list) {
		for(int i=0 ; i<list.size(); i++ ) {
			Interval in = list.get(i);
			System.out.println(in.start+" "+in.end);
		}
	}

	Comparator comp =  new Comparator<Interval>() {
		public int compare(Interval a, Interval b) {
			// TODO Auto-generated method stub
			return a.start - b.start;
		}
	};
	
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;

		Collections.sort(intervals,comp);
		
		

		List<Interval> ans = new LinkedList<Interval>();
		Interval hold = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (hold.end >= current.start) {
				hold.end = Math.max(current.end, hold.end);
			} else {
				ans.add(hold);
				hold = current;
			}
		}

		if (!ans.contains(hold))
			ans.add(hold);

		return ans;
	}
}

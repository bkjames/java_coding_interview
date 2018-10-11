package zz07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
	int start;
	int end;
	Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		
		List<Interval> intervals = new ArrayList<>();
		Interval i4 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i1 = new Interval(15,18);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		
		m.merge(intervals);
		System.out.println("===============");
		printIntervals(intervals);
		
	}
	
	
	public List<Interval> merge(List<Interval> intervals){
		List<Interval> result = new ArrayList<>();
		if(intervals== null|| intervals.size()==0)
			return result;
		printIntervals(intervals);
		
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				// TODO Auto-generated method stub
				if(i1.start != i2.start)
					return i1.start-i2.start;
				else
					return i1.end-i2.end;
			}
		});
		System.out.println("====================");
		printIntervals(intervals);
		
		Interval pre = intervals.get(0);
		for(int i=0; i<intervals.size();i++) {
			Interval curr = intervals.get(i);
			if(curr.start >pre.end) {
				result.add(pre);
				pre = curr;
			}else {
				Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
				pre = merged;
			}
		}
		result.add(pre);
		
		
		return result;
		
	}
	
	public static void printIntervals(List<Interval> intervals) {
		if(intervals != null && !intervals.isEmpty()) {
			for(Interval interval : intervals) {
				if(interval != null) {
					System.out.println(interval.start+" "+interval.end);
				}
			}
		}
	}
	
	
}

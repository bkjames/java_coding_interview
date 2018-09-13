

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
		
		public List<Interval> mergeIntervals(List<Interval> intervals) {
		    List<Interval> result = new ArrayList<Interval>();
		 
		    if(intervals==null||intervals.size()==0)
		        return result;
		    
		    System.out.println("111=====================");
			Interval.printIntervals(intervals);
			System.out.println("=====================");
			
		 
			
//			The compareTo() method returns an int with the following characteristics:
//
//				negative If thisObject < anotherObject
//				zero If thisObject == anotherObject
//				positive If thisObject > anotherObject
				
				
		    Collections.sort(intervals, new Comparator<Interval>(){
		        public int compare(Interval i1, Interval i2){
		            if(i1.start!=i2.start)
		                return i1.start-i2.start;
		            else
		                return i1.end-i2.end;
		        }
		    });
		 
		    System.out.println("=====================");
			Interval.printIntervals(intervals);
			
			
		    Interval pre = intervals.get(0);
		    for(int i=0; i<intervals.size(); i++){
		        Interval curr = intervals.get(i);
		        if(curr.start>pre.end){
		            result.add(pre);
		            pre = curr;
		        }else{
		            Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
		            pre = merged;
		        }
		    }
		    result.add(pre);
		 
		    return result;
		}
		
		/*
		 * Private utility method to setup data
		 */
		private List<Interval> setupData() {
			List<Interval> intervals = new ArrayList<Interval>();
		
			Interval i4 = new Interval(1,3);
			Interval i2 = new Interval(2,6);
			Interval i3 = new Interval(8,10);
			Interval i1 = new Interval(15,18);
			
			intervals.add(i1);
			intervals.add(i2);
			intervals.add(i3);
			intervals.add(i4);

			return intervals;
		}
		
		public static void main(String args[]) {
			MergeInterval mergeInterval = new MergeInterval();
			List<Interval> intervals = mergeInterval.setupData();
			List<Interval> result = mergeInterval.mergeIntervals(intervals);
			System.out.println("====결과값=========");
			Interval.printIntervals(result);
			
		}
	}

	/**
	 * Interval class
	 * @author megha krishnamurthy
	 *
	 */
	class Interval {
		int start;
		int end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		/*
		 * Utility method to print intervals
		 */
		static void printIntervals(List<Interval> intervals) {
			if(intervals != null && !intervals.isEmpty()) {
				for(Interval interval: intervals) {
					if(interval != null) {
						System.out.println("[" + interval.start + "," + interval.end + "]");
					}
				}
			}
		}
	}


package test0322;

import java.util.*;


public class MergeInterval {
	
	static class Interval{
		int start, end;
		Interval(){
			this.start=0;
			this.end =0;
		}
		Interval(int s, int e){
			this.start = s;
			this.end = e;
		}
	}

	
	public static void main(String[] args) {
		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		
		Interval in = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> list = new ArrayList<>();
		list.add(in);
		list.add(in2);
		list.add(in3);
		list.add(in4);
		
		MergeInterval a = new MergeInterval();
		a.merge(list);
	}
	 public List<Interval> merge(List<Interval> intervals){
		 List<Interval> resList  = new ArrayList<>();
		 if(intervals.size() < 2) return intervals;
		 print(intervals);
		 
		 Collections.sort(intervals, comp);
		 
		 Interval hold = intervals.get(0);
		 for(int i=1; i< intervals.size(); i++) {
			 Interval curr = intervals.get(i);
			
			 if(hold.end >= curr.start) {
				
				 hold.end = Math.max(hold.end, curr.end);
		
			 }else {
				 resList.add(hold);
				 hold = curr;
			 } 
		 }
		 resList.add(hold);
		 System.out.println("===sort ===");
		 print(resList);
		 return resList;
		 
	 }
	 
	 public void print(List<Interval> list) {
		 int size = list.size();
		 for(int i =0; i<size; i++) {
			 Interval interval = list.get(i);
			 System.out.println(interval.start +" "+ interval.end);
		 }
	 }
	 
	 Comparator<Interval> comp = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start- o2.start;
		}
	 };

}

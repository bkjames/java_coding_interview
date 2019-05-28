package Top50;
import java.util.*;


import java.util.*;

class Interval{
	int start, end;
	Interval(){
		this.startpackage Top50;
import java.util.*;


import java.util.*;

class Interval{
	int start, end;
	Interval(){
		this.start = 0;
		this.end = 0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class T04_MergeInterval {

	public static void main(String[] args) {
		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval in = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> list = new ArrayList<>();
		list.add(in);
		list.add(in4);
		list.add(in3);
		list.add(in2);
		T04_MergeInterval a = new T04_MergeInterval();
//		a.merge(list);
		a.merge_8(list);
	}
	//lambda
	public List<Interval> merge_8(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	    	System.out.println("interval.start: "+interval.start+" end "+end);
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
	
	//1
	public List<Interval> merge(List<Interval> list){
		List<Interval> resList = new ArrayList<>();
		if(list.size() <2) return list;
		print(list);
		
		Collections.sort(list, Comp);
		System.out.println("==========");
		print(list);
		
		Interval hold = list.get(0);
		for(int i=1; i< list.size(); i++) {
			Interval curr = list.get(i);
			if(hold.end >= curr.start) {
				hold.end = Math.max(hold.end, curr.end);
				
			}else {
				resList.add(hold);
				hold = curr;
			}
		}
		resList.add(hold);
		System.out.println("======sort====");
		print(resList);
		
		return resList;
		
	}
	
	Comparator<Interval> Comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			if(o1.start > o2.start) {
				return 1;
			}else if(o1.start < o2.start) {
				return -1;
			}else {
				return 0;
			}
			
//			System.out.println("o1.start: "+o1.start+" o2.start "+o2.start+"  o1.start- o2.start: "+ (o1.start- o2.start));
//			return o1.start - o2.start;
		}
		
	};
	
	public void print(List<Interval> list) {
		for(int i=0; i< list.size() ; i++) {
			Interval inter = list.get(i);
			System.out.println(inter.start+" "+inter.end);
		}
	}
	
	
	
}

 = 0;
		this.end = 0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class T04_MergeInterval {

	public static void main(String[] args) {
		int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
		Interval in = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> list = new ArrayList<>();
		list.add(in);
		list.add(in4);
		list.add(in3);
		list.add(in2);
		T04_MergeInterval a = new T04_MergeInterval();
		a.merge(list);
	}
	public List<Interval> merge(List<Interval> list){
		List<Interval> resList = new ArrayList<>();
		if(list.size() <2) return list;
		print(list);
		
		Collections.sort(list, Comp);
		System.out.println("==========");
		print(list);
		
		Interval hold = list.get(0);
		for(int i=1; i< list.size(); i++) {
			Interval curr = list.get(i);
			if(hold.end >= curr.start) {
				hold.end = Math.max(hold.end, curr.end);
				
			}else {
				resList.add(hold);
				hold = curr;
			}
		}
		resList.add(hold);
		System.out.println("======sort====");
		print(resList);
		
		return resList;
		
	}
	
	Comparator<Interval> Comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			if(o1.start > o2.start) {
				return 1;
			}else if(o1.start < o2.start) {
				return -1;
			}else {
				return 0;
			}
			
//			System.out.println("o1.start: "+o1.start+" o2.start "+o2.start+"  o1.start- o2.start: "+ (o1.start- o2.start));
//			return o1.start - o2.start;
		}
		
	};
	
	public void print(List<Interval> list) {
		for(int i=0; i< list.size() ; i++) {
			Interval inter = list.get(i);
			System.out.println(inter.start+" "+inter.end);
		}
	}
	
	
	
}


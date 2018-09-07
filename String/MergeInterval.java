package sangmin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
     int start;
     int end;
     Interval() { 
    	 start = 0;
    	 end = 0; 
    	}
     Interval(int s, int e) {
    	 start = s; 
    	 end = e; 
    	 }
 }


public class MergeInterval {
	
	public static void main(String[] args) {
		
		List<Interval> list  = new ArrayList<>();
		Interval it = new Interval(1,3);
		Interval it2 = new Interval(2,6);
		Interval it3 = new Interval(8,10);
		Interval it4 = new Interval(15,18);
	
		list.add(it);
		list.add(it2);
		list.add(it3);
		list.add(it4);
		
		MergeInterval mm = new MergeInterval();
		List<Interval> result = mm.merge(list);
		
		for(int i=0; i< result.size(); i++) {
			System.out.println(i);
			Interval it1 = result.get(i);
			System.out.println(it1.start +" "+ it1.end);
		}
	}
	
	
	public List<Interval> merge(List<Interval> intervals) {
	    List<Interval> result = new ArrayList<Interval>();
	 
	    if(intervals==null||intervals.size()==0)
	        return result;
	 
	    Collections.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval i1, Interval i2){
	            if(i1.start!=i2.start)
	                return i1.start-i2.start;
	            else
	                return i1.end-i2.end;
	        }
	    });
	 
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

}

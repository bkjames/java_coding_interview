package part1;

import java.util.*;

class Interval{
	int start, end;
	Interval(){
		this.start =0;
		this.end =0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}
public class MeetingRoom {
	public static void main(String[] args) {
		Interval in1 = new Interval(0, 30);
		Interval in2 = new Interval(5, 10);
		Interval in3 = new Interval(15, 20);
		
		Interval[] intervals = {in1, in2, in3};
		MeetingRoom a = new MeetingRoom();
		System.out.println(a.minMeetingRooms_pq(intervals));
		System.out.println(a.minMeetingRooms(intervals));
	}
	
	
	 public int minMeetingRooms_pq(Interval[] intervals) {
			if (intervals.length <= 1)
				return intervals.length;
		
			Arrays.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2) {
					return i1.start - i2.start;
				}
			});

	
			PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
				public int compare(Interval i1, Interval i2) {
					return i1.end - i2.end;
				}
			});

			
			pq.add(intervals[0]);
			for (int i = 1; i < intervals.length; i++) {
				if (pq.peek().end <= intervals[i].start) { 
					pq.poll();
				}
				pq.add(intervals[i]); 
				
			}

		
			return pq.size(); 
		}
	    
	  public int minMeetingRooms(Interval[] intervals) {
	        if (intervals.length == 0)
	            return 0;
	        if (intervals.length == 1)
	            return 1;
	        Arrays.sort(intervals,new Comparator<Interval>(){
	            public int compare(Interval a, Interval b){
	                if (a.start == b.start)
	                    return 0;
	                if (a.start > b.start)
	                    return 1;
	                else
	                    return -1;
	            }
	        });
	        
	        int max = intervals[0].end;
	        Interval last = intervals[0];
	        int sum = 1;
	        for (int i=1;i<intervals.length;i++){
	            if (intervals[i].start >= max){
	                max = intervals[i].end;
	                last.start = intervals[i].start;
	                last.end = intervals[i].end;
	            }
	            else{
	                max = Math.max(intervals[i].end,max);
	                if (intervals[i].start < last.end)
	                    sum ++;
	                last.start = intervals[i].start;
	                last.end = intervals[i].end;
	            }
	        }
	        return sum;
	    }
	
	 public int minMeetingRooms_PQ(Interval[] intervals) {
	        if(intervals == null || intervals.length == 0) {
	            return 0;
	        }
	        
	        Arrays.sort(intervals, new Comparator<Interval>() {
	            @Override
	            public int compare(Interval int1, Interval int2) {
	                return Integer.compare(int1.start, int2.start);
	            }
	        });
	        
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        pq.add(intervals[0].end);
	        int roomRequired = 1;
	        
	        for(int i = 1; i<intervals.length; i++) {
	            Interval cur = intervals[i];
	            while(!pq.isEmpty() && cur.start >= pq.peek()) {
	                pq.poll();
	            }
	            pq.add(cur.end);
	            roomRequired = pq.size() > roomRequired ? pq.size() : roomRequired;
	        }
	        
	        return roomRequired;
	    }
	 
	
	
	
	public int solve(Interval[] intervals) {
		
		Arrays.sort(intervals, comp);
		return helper(new ArrayList(Arrays.asList(intervals)));
	}
	public int helper(List<Interval> list) {
		if(list.size() ==0) return 0;
		System.out.println("list: "+list.size());
		Interval prev = list.get(0);
		List<Interval> nextList = new ArrayList<>();
		for(int i=1; i<list.size(); i++) {
			Interval curr = list.get(i);
			if(curr.start < prev.end) {
				nextList.add(curr);
			}else {
				prev = curr;
			}
		}
		int val = 1+helper(nextList);
		return val;
		
	}
	
	Comparator<Interval> comp = new Comparator<Interval>() {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start -b.start;
		}
		
	};
	
}
	

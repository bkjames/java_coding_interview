package real;

import java.util.ArrayList;
import java.util.Collections;




public class K2017_ShuttlBus2 {
	
	class Node {
	    int m;
	    int sec;
	    int maxSec;

	    public Node(int m, int sec) {
	        this.m = m;
	        this.sec = sec;
	    }

	    @Override
	    public String toString() {
	        return "Node [m=" + m + ", sec=" + sec + ", maxSec=" + maxSec + "]";
	    }
	}

    public static void main(String[] args) {
        // 1    1   5   ["08:00", "08:01", "08:02", "08:03"]    09:00
        // 2    10  2   ["09:10", "09:09", "08:00"]
        //  2, 1, 2, ["09:00", "09:00", "09:00", "09:00"]
        int n = 2;
        int t = 1;
        int m = 2;
        String[] s = {"09:00", "09:00", "09:00", "09:00"};


        new K2017_ShuttlBus2().solution(n, t, m, s);
    }

	    public int getMin(String s) {
	        String[] time = s.split(":");
	        int hour = Integer.parseInt(time[0]);
	        int min = Integer.parseInt(time[1]);
	        return hour * 60 + min;
	    }

	    public String getFmt(int t) {
	        int hour = t / 60;
	        int min = t % 60;
	        return String.format("%02d:%02d", hour, min);
	    }

	    public String solution(int n, int t, int m, String[] timetable) {
	        ArrayList<Node> bus = new ArrayList<>();
	        ArrayList<Integer> times = new ArrayList<>();
	        for (String time : timetable)
	            times.add(getMin(time));

	        boolean[] visit = new boolean[times.size()];

	        Collections.sort(times);

	        bus.add(new Node(0, getMin("09:00")));
	        for (int i = 0; i < n - 1; i++) {
	            int nextSec = bus.get(bus.size() - 1).sec + t;
	            bus.add(new Node(0, nextSec));
	        }

	        for (int i = 0; i < bus.size(); i++) {
	            for (int j = 0; j < times.size() && bus.get(i).m < m; j++) {
	                if (bus.get(i).sec >= times.get(j) && !visit[j]) {
	                    bus.get(i).m++;
	                    bus.get(i).maxSec = times.get(j);
	                    visit[j] = true;
	                }
	            }
	        }

	        Node last = bus.get(bus.size() - 1);
	        // System.out.println(bus.toString());
	        int result = 0;
	        if (last.m == m)
	            result = last.maxSec - 1;
	        else result = last.sec;
	        System.out.println(getFmt(result));
	        return getFmt(result);
	    }


	

}

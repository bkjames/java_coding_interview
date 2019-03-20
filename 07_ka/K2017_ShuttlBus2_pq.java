package real;

public class K2017_ShuttlBus2_pq {

	
	import java.util.PriorityQueue;

	class Solution {
	 static String solution(int n, int t, int m, String[] timetable) {

	PriorityQueue<Time> pq = new PriorityQueue<>();
	for (String time : timetable) pq.add(new Time(time));

	// conTime : 콘이 버스 정류장에 가장 늦게 도착할 수 있는 시간
	Time conTime = new Time("00:00");

	for (int i = 0; i < n; i++) {

	Time busTime = new Time("09:00");
	busTime.add(i, t);

	conTime = busTime;

	int capacity = m;

	// 버스에 사람 태우기
	while (!pq.isEmpty() && capacity > 0 && pq.peek().compareTo(busTime) <= 0) {

	Time crewTime = pq.poll();

	if (capacity == 1) {

	conTime = crewTime;
	conTime.add(1, -1);
	}

	capacity--;
	}
	}

	return conTime.toString();
	}
	}

	class Time implements Comparable<Time> {

	int h, m;

	Time(String time) {

	this.h = Integer.parseInt(time.substring(0, 2));
	this.m = Integer.parseInt(time.substring(3, 5));
	}

	void add(int n, int t) {

	int addHour = (n * t) / 60;
	int addMin = (n * t) % 60;

	h += addHour;
	m += addMin;

	if (m >= 60) {

	h++;
	m %= 60;
	} else if (m < 0) {

	h--;
	m = 60 + m;
	}
	}

	@Override
	public String toString() {

	return String.format("%02d:%02d", this.h, this.m);
	}

	@Override
	public int compareTo(Time o) {

	return this.h < o.h ? -1 : this.h > o.h ? 1 : this.m < o.m ? -1 : this.m > o.m ? 1 : 0;
	}

	}
}


import java.util.PriorityQueue;

class Solution {
  public String solution(int n, int t, int m, String[] timeTable) {
      // n 버스 t 배차시간 m 최대 탑승 인원
        PriorityQueue<Time> pq = new PriorityQueue<Time>();
        for(String time : timeTable) {
            pq.add(new Time(time));
        }

        // conTime : 콘이 버스 정류장에 가장 늦게 도착할 수 있는 시간.
        Time conTime = new Time("00:00");

        for(int i=0; i<n; i++) {
            Time busTime = new Time("09:00");
            busTime.add(i, t);

            conTime = busTime;

            int capacity = m;
            // 버스에 사람을 태우자
            while(!pq.isEmpty() && capacity > 0 && pq.peek().compareTo(busTime) <= 0) { // 대입한 시간이 크거나 같음.
                Time crewTime = pq.poll();

                if(capacity == 1) {
                    conTime = crewTime;
                    conTime.add(1, -1);
                }

                capacity--;
            }

        }

        return conTime.toString();
  }
}

class Time implements Comparable<Time>{
    int h, m;

    Time(String time) {
        this.h = Integer.parseInt(time.substring(0,2));
        this.m = Integer.parseInt(time.substring(3,5));
    }

    // n은 버스 갯수, t는 시간
    void add(int n, int t) {
        int addHour = (n*t)/60;
        int addMin = (n*t)%60;

        h += addHour;
        m += addMin;

        if(m >= 60) {
            h++;
            m -= 60;
        } else if(m < 0) {
            h--;
            m += 60;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.h, this.m);
    }

    @Override
    public int compareTo(Time o) {
            if(this.h < o.h) {      // 대입한 시간이 더큼
                return -1;
            } else if(this.h > o.h) {   // 기존 시간이 더큼
                return 1;
            } else if(this.m < o.m) {   // 시간은 같고, 대입한 시간이 더큼
                return -1;
            } else if(this.m > o.m) {   // 시간은 같고, 기존 시간이 더큼
                return 1;
            } else {    // 시간, 분 모두 같은 경우
                return 0;
            }
    }
}

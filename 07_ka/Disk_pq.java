package test0325;

import java.util.*;

 class Disk {
    public int requestTime;
    public int processTime;

    public Disk(int requestTime, int processTime) {
        this.requestTime = requestTime;
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "requestTime=" + requestTime +
                ", processTime=" + processTime +
                '}';
    }
}

public class Disk_pq {

	public static void main(String[] args) {
		
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		Disk_pq a = new Disk_pq();
		System.out.println(a.solution(jobs));
	}
	public int solution(int[][] jobs) {
//        Queue<Disk> queue = new PriorityQueue<Disk>(Collections.reverseOrder((o1, o2) -> (o2.processTime - o1.processTime)));
		System.out.println("test");
        Queue<Disk> queue = new PriorityQueue<Disk>(proceeTimeComp);
        List<Disk> disks = new ArrayList<>();
        int totalTime = 0;
        for (int i = 0; i < jobs.length; i++)
            disks.add(new Disk(jobs[i][0], jobs[i][1]));

//        Collections.sort(disks, Collections.reverseOrder((o1, o2) -> (o2.requestTime - o1.requestTime)));
//        Queue<Disk> queue = new PriorityQueue<Disk>(disks.sort(proceeTimeComp));
        Collections.sort(disks,Comp);
        int settingTime = disks.get(0).requestTime;
        for (Disk disk : disks) {
            disk.requestTime -= settingTime;
            totalTime += (disk.processTime + disk.requestTime);
        }

        int index = 0;
        int time = 0;
        int sum = 0;
        int job = 0;
        for (int i = 0; i <= totalTime; i++) {
            while(index < disks.size() && i == disks.get(index).requestTime)
                queue.add(disks.get(index++));

            if(job == 0 && !queue.isEmpty()) {
                Disk disk = queue.poll();
                job = disk.processTime; // 본인처리시간
                sum += (disk.processTime - disk.requestTime + time); // 본인처시간 - 본인요청시간 + 이전꺼 처리시간
            }

            if(job > 0) job--;

            time++;

        }

        return (sum) / jobs.length;
    }
	
	Comparator<Disk> proceeTimeComp = new Comparator<Disk>() {

		@Override
		public int compare(Disk o1, Disk o2) {
			// TODO Auto-generated method stub
			return (o1.processTime - o2.processTime);
		}
		
	};
	
	Comparator<Disk> Comp = new Comparator<Disk>() {

		@Override
		public int compare(Disk o1, Disk o2) {
			// TODO Auto-generated method stub
			return (o1.requestTime - o2.requestTime);
		}
		
	};

    
}

package Test100;

import java.util.Arrays;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int  n = 2;
		System.out.println(leastInterval(tasks, n));
	}
	
	
	public static int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
        	System.out.println("task: "+task);
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
	
	 public static int leastInterval2(char[] tasks, int n) {

	        int[] c = new int[26];
	        for(char t : tasks){
	            c[t - 'A']++;
	        }
	        Arrays.sort(c);
	        int i = 25;
	        while(i >= 0 && c[i] == c[25]) i--;

	        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
	    }
}

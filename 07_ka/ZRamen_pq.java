package test0404;

import java.util.*;

public class Ramen_pq {
	
	public static void main(String[] args) {
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k =	 30; 
		System.out.println(	Ramen_pq.solution(stock, dates, supplies, k));
		
	}
	  public static int solution(int stock, int[] dates, int[] supplies, int k) {
	        int answer = 0;
	        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
	 
	        int index = 0;
	        for (int i = 0; i < k; i++) {
	        	System.out.println("i: "+i);
	            if(index < dates.length && i == dates[index]) {
	            	System.out.println("index:"+index+" dates.length: "+dates.length+" i: "+i+" supplies["+index+"] "+ supplies[index]+" dates["+index+"]: "+dates[index]);
	                priorityQueue.add(supplies[index++]);
	            }
	            if(stock == 0) {
	                stock += priorityQueue.poll();
	                answer++;
	            }
	            stock -= 1;
	        }
	        return answer;
	    }

}

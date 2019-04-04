package test;

import java.util.*;

public class MoreSpicy {

	public static void main(String[] args) {
		
		int[] scoville=	{1, 2, 3, 9, 10, 12};
		int K = 7;
		MoreSpicy a = new MoreSpicy();
		a.solution(scoville, K);
	}
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
        	pq.add(i);
        }

        while (!pq.isEmpty() && pq.peek() < K){
            Integer lessSpicy = pq.poll();
            if (!pq.isEmpty()) {
                Integer secondLessSpicy = pq.poll();
                pq.add(lessSpicy + secondLessSpicy * 2);
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}

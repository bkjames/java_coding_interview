package real;
import java.util.*;

public class L2_FunctionDev {

	public static void main(String[] args) {
		int[] progresses= {93,30,55};	
		int[] speeds= {1,30,5};
		
		L2_FunctionDev a = new L2_FunctionDev();
		int[] r = a.solution(progresses, speeds);
		for(int i: r)
			System.out.println(i);

	}
	public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int len = progresses.length;
         
        int num = 0;
        for(int i = 0; i <= len; i++){
            if(i == len){
            	queue.add(num);
                break;
            }
            if(progresses[i] >= 100){
                num++;
                continue;
            }
            if(num != 0){
            	queue.add(num);
            }
             
            num = 0;
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0){
                day++;
            }
             
            for(int j = i; j < len; j++){
                progresses[j] += (day * speeds[j]);
            }
            num++;
        }
     
        int[] answer = new int[queue.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = queue.remove();
        }
        return answer;
    }
	
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] dayArr = new int[progresses.length];
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i=0; i<progresses.length; i++) {
            int pgs = 100 - progresses[i];
            int day = pgs/speeds[i] + (pgs%speeds[i] > 0 ? 1: 0);
            dayArr[i] = day;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(dayArr[0]);

        for(int i=1; i<dayArr.length; i++) {
            int target = dayArr[i];
            if(target <= queue.peek()) {
                queue.add(target);
            }else {
                int cnt = 0;
                while(!queue.isEmpty()) {
                    queue.poll();
                    cnt++;
                }
                answerList.add(cnt);

                queue.add(target);
            }
        }

        if(!queue.isEmpty()) {
            int cnt = 0;
            while(!queue.isEmpty()) {
                queue.poll();
                cnt++;
            }
            answerList.add(cnt);
        }

        answer = new int[answerList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

package real;

public class L1_Budget {

	public static void main(String[] args) {
		int[] d ={1,3,2,5,4};
		int budget =9;
		L1_Budget a = new L1_Budget();
		System.out.println(a.solution(d, budget));
		
	}
	public int solution(int[] d, int budget) {
		int answer = 0;
		for(int i=0; i<d.length; i++) {
			for(int j=0; j<d.length-1; j++) {
				if(d[j]>d[j+1]) {
					int tmp = d[j];
					d[j] = d[j+1];
					d[j+1] =tmp;
				}
			}
		}
		
		for(int i :d) {
			budget -= i;
			answer++;
			if(budget<0) return answer-1;
		}
	  
	    return answer;
	}
}

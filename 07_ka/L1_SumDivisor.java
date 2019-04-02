package real;

public class L1_SumDivisor {

	public static void main(String[] args) {
		L1_SumDivisor a = new L1_SumDivisor();
		int num =12;
		System.out.println(a.sumDivisor(num));
	}
	
	public int sumDivisor(int num) {
		int answer=0;
		for(int i=1; i<=num; i++) {
			if(num %i==0) {
				answer += i;
			}
		}
		return answer;
	}
}

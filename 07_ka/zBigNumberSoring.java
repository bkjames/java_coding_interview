package prog;

public class BigNumberSorting {

	public static void main(String[] args) {
		BigNumberSorting a = new BigNumberSorting();
		int[] numbers =  {6, 10, 2};
		System.out.println(a.solution(numbers));
	}
	
	public String solution(int[] numbers) {
		String answer ="";
		String[] nums = new String[numbers.length];
		for(int i=0; i< nums.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(nums, Comp);
		if(nums[0].equals("0")) {
			answer += "0";
		}else {
			for(int j=0; j<nums.length; j++) {
				answer +=nums[j];
			}
		}
		return answer;
	}
	
	Comparator<String> Comp = new Comparator<String>() {

		@Override
		public int compare(String a, String b) {
			// TODO Auto-generated method stub
			System.out.println((b+a)+"   "+(a+b)+" : "+((b+a).compareTo(a+b)));
			return (b+a).compareTo(a+b);
		}
		
	};

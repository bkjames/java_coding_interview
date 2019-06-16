package zKaKa;


//numbers	target	return
//[1, 1, 1, 1, 1]	3	5
public class Dfs_TargetNumber {
	
	public static void main(String[] args) {
		int[] numbers= {1,1,1,1,1};
		int target = 3; 
		Dfs_TargetNumber a = new Dfs_TargetNumber();
		System.out.println(a.solution(numbers, target));
	}
	
	int answer = 0;
	
	public int solution(int[] numbers, int target) {
		dfs(numbers, 0, 0, target, " ");
		return answer;
	}



	void dfs(int[] numbers, int index, int sum, int target, String str) {
		
		if(index>numbers.length) return;
		System.out.println("index: "+index+" sum: "+sum+" target: "+target+" str: "+str);
		if(index == numbers.length){
			if(sum==target){
				//System.out.println(str);
				answer++;
			}
			return;
		}

		dfs(numbers, index+1, sum + numbers[index], target, str + "+");
		dfs(numbers, index+1, sum - numbers[index], target, str + "-");
	}


}

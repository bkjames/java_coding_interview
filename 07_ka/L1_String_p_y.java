package real;

public class L1_String_p_y {

	public static void main(String[] args) {
		String s = "pPoooyY";
		L1_String_p_y a = new L1_String_p_y();
		System.out.println(a.solution(s));
	}
	boolean solution(String s) {
        boolean answer = false;
        int pCount =0, yCount=0;
        for(int i=0; i<s.length(); i++) {
        	if(s.toLowerCase().charAt(i)=='p') {
        		pCount++;
        	}
        	if(s.toLowerCase().charAt(i)=='y') {
        		yCount++;
        	}
        }
        if(pCount==yCount) {
        	answer=true;
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}

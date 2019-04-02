package real;

public class L1_ValidBracket {

	public static void main(String[] args) {
		String s = "()()";
	}
	
	boolean solution(String s) {
        
		boolean answer = true;
        int check =0;
        
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)=='(') check +=1;
        	else check -=1;
        	
        	if(check<0) return false;
        }

       if(check !=0) return false;

        return answer;
	 }
	
	
	boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}

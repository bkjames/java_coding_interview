package real;

public class L1_GetMiddleWord {

	public static void main(String[] args) {
//		String s = "abcde";
		String s = "qwer";
		L1_GetMiddleWord a = new L1_GetMiddleWord();
		System.out.println(a.solution(s));
	}
	public String solution(String s) {
	    int length = s.length();
	    if(length % 2 ==1) {
//	    	return Character.toString(s.charAt(length/2));
	    	return s.substring(length/2, length/2+1);
	    }else {
	    	return s.substring(length/2-1, length/2+1);
	    }
	  }
}

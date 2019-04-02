package real;

public class L1_Subak {

	public static void main(String[] args) {
		int n =5;
		System.out.println(solution(n));
	}
	
	public static String solution(int n) {
	      String answer = "";
	      
	      for(int i=0; i<n; i++) {
	    	  if(i%2 ==0) {
	    		  answer += "박";
	    	  }else {
	    		  answer += "수";
	    	  }
	      }
	      return answer;
	  }
	
	public String watermelon(int n){
        StringBuffer sf = new StringBuffer();
        for (int i=1; i<=n; ++i) {
            sf.append(i%2==1?"수":"박");
        }
        return sf.toString();
    }
}

package real;

public class L1_Ceaser {


	public static void main(String[] args) {
		L1_Ceaser c = new L1_Ceaser();
        System.out.println("s는 'a B z', n은 4인 경우: " + c.solution("a B z", 4));
    }
	
	String solution(String s, int n) {
        String result = "";
        n = n%26; //밀어낼 자리수 n의 계산
        int cs = s.length(); //cs = 5 , 공백도 똑같이 출력해줘야하기 때문에 그냥 length로 받음
         
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);  //하나씩 저장
            if(Character.isLowerCase(ch)) {
                // 계산시 -'a'와 +'a'를 해줘야 하는 이유에 대해 파악해야함
                ch = (char) ((ch-'a'+n) % 26 +'a'); 
                 
            }else if(Character.isUpperCase(ch)) {
                ch = (char) ((ch-'A'+n) % 26 +'A');
                 
            }
            result = result + ch;
             
        }
         
        // 함수를 완성하세요.
         
        return result;
    }

}

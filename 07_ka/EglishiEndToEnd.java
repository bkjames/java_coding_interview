package real;
import java.util.*;

public class EglishiEndToEnd {

	public static void main(String[] args) {
		int n =3;
		String[] words = {"tank", "kick", "know", 
				"wheel", "land", "dream", "mother", "robot", "tank"};
		EglishiEndToEnd a = new EglishiEndToEnd();
		int[] result = a.solution(n, words);
		for(int r: result)
			System.out.println(r);
	}
	
	public int [] solution(int n, String [] words) {
		int [] answer = {0, 0};
		HashSet<String> set = new HashSet<String>();
		char previous = words[0].charAt(words[0].length() - 1);
		set.add(words[0]);
		for(int i=1; i < words.length; i++) {
			char current = words[i].charAt(0);
			System.out.println("current: "+current);
			if(previous != current || set.contains(words[i])) {
				
				System.out.println("val "+words[i]);
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}
			System.out.println(words[i]);
			set.add(words[i]);
			previous = words[i].charAt(words[i].length() - 1);
		}
		return answer;
	}
}

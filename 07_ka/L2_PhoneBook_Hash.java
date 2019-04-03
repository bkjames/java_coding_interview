package test0329;
import java.util.*;
public class L2_PhoneBook {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		solution(phone_book);
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[j].length(); j++) {
            	
                map.put(phone_book[i].substring(0, j), 1);
            }
        }
        for(int inx = 0; inx < phone_book.length; inx++) {
            if(map.containsKey(phone_book[inx])) {
                answer = false;
                break;
            } else {
                map.put(phone_book[inx], 1);
            }
        }
        return answer;
    }
}

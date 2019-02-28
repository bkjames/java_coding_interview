package Basic;

import java.util.HashSet;
import java.util.Set;

public class A002_UniqueEmail {
	
	public static void main(String[] args) {
	  String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
	  numUniqueEmails(emails);
	}
	 public static int numUniqueEmails(String[] emails) {
	        Set<String> set = new HashSet<>();
	        for(String email : emails) {
	            StringBuilder sb = new StringBuilder();
	            for(char c: email.toCharArray()) {
	                if (c == '.') continue;
	                if (c == '+') break;
	                sb.append(c);
	            }
	            String cur = sb.toString() + email.substring(email.indexOf('@'));
	            set.add(cur);
	        }
	        return set.size();
	    }

}

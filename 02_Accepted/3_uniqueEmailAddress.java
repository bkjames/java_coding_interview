package Basic;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(numUniqueEmails(emails));
	}
	 public static int numUniqueEmails(String[] emails) {
	      if (emails == null || emails.length == 0) {
	        return 0;
	      }

	      Set<String> set = new HashSet<>();
	      for (String email : emails) {
	        StringBuilder sb = new StringBuilder();
	        boolean isBeforePlus = true;
	        int idxOfAt = 0;
	        System.out.println("email: "+email);
	        for (int i = 0; i < email.length(); i++) {
	          if (isBeforePlus && email.charAt(i) != '@') {
	            if (email.charAt(i) == '.') {
	              continue;
	            } else if (email.charAt(i) == '+') {
	              isBeforePlus = false;
	            } else {
	              sb.append(email.charAt(i));
	            }
	          } else if (email.charAt(i) == '@') {
	            idxOfAt = i;
	            break;
	          }
	        }
	        sb.append(email.substring(idxOfAt));
	        System.out.println("sb: "+sb.toString());
	        set.add(sb.toString());
	      }
	      
	      return set.size();
	    }
}

package zGoo001;
import java.util.*;


interface Master {
    public int guess(String word);
}

class MasterImpl implements Master{
     String secret;

    @Override
    public int guess(String word) {
        int count=0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)==secret.charAt(i))
                count++;
        }
        System.out.println("count: "+count);
        return count;
    }
}
public class G009_GuessTheWord {

//	public void findSecretWord(String[] wordlist, Master master) {
//	        int N = wordlist.length;
//	        int[][] m = new int[N][N];
//	        List<Integer> remain = new ArrayList<>();
//	        for (int i = 0; i < N; i++) {
//	            remain.add(i);
//	            for (int j = i+1; j < N; j++) {
//	                int c=0;
//	                for (int k = 0; k < wordlist[i].length(); k++) {
//	                    if(wordlist[i].charAt(k)==wordlist[j].charAt(k)) c++;
//	                }
//	                m[i][j]=c;
//	                m[j][i]=c;
//	            }
//	        }
//
//	        int wordLen = wordlist[0].length();
//	        int step=10;
//	        Random r = new Random();
//	        HashSet<Character> blacklist = new HashSet<>();
//	        while(step>0){
//	            int rand =  r.nextInt(remain.size());
//	            int v = remain.get(rand);
//	            remain.remove(rand);
//
//	            int match = master.guess(wordlist[v]);
////	            System.out.println("match: "+match);
//	            List<Integer> nextCandidate = new ArrayList<>();
//	            if(match == wordLen){
//	                nextCandidate.add(v);
//	                remain=nextCandidate;
//	            }else{
//	                // 1<=match<wordLen
//	                for(int i : remain){
//	                    if(m[v][i]==match){
//	                        nextCandidate.add(i);
//	                    }
//	                }
//	                remain=nextCandidate;
//	            }
//	            step--;
//	        }
//	    }
public void findSecretWord(String[] wordlist, Master master) {
	int[] count = new int[26];
	for (String s : wordlist) {
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
	}
	Set<String> set = new HashSet<>();
	for (String s : wordlist) {
		set.add(s);
	}
	int i = 0;
	while (i++ < 10) {
		String best = getBestCandidate(set, count);
		int match = master.guess(best);
		for (Iterator<String> ite = set.iterator(); ite.hasNext();) {
			if (match(best, ite.next()) != match) {
				// Remove the candidate that not matches.
				ite.remove();
			}
		}
	}
}

private String getBestCandidate(Set<String> wordlist, int[] count) {
	int max = 0;
	String best = "";
	for (String s : wordlist) {
		int c = 0;
		for (char a : s.toCharArray()) {
			c += count[a - 'a'];
		}
		if (c > max) {
			max = c;
			best = s;
		}
	}
	return best;
}

private int match(String a, String b) {
	int count = 0;
	for (int i = 0; i < a.length(); i++) {
		if (a.charAt(i) == b.charAt(i))
			count++;
	}
	return count;
}
	    public static void main(String[] args) {
			 G009_GuessTheWord a = new G009_GuessTheWord();
//			    Master master = new Master("acckzz");
			    String[] wordList = {"acckzz","ccbazz","eiowzz","abcczz"};
//			    master.guess("aaaaaa");
//			    a.findSecretWord(wordList, master);
			    
			    MasterImpl master = new MasterImpl();
			    master.secret = "eiowzz";
			    a.findSecretWord(wordList, master);
			    
			  }
}

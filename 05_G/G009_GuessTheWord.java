package zGoo001;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import java.util.ArrayDeque;
import java.util.Queue;

public class G009_GuessTheWord {
  static class Master {
    int callCount;
    String secretWord;

    Master(String secretWord) {
      this.secretWord = secretWord;
    }

    int guess(String word) {
      System.out.println("Master.guess() is called " + ++callCount + " times.");
      return getMatches(secretWord, word);
    }
  }

  private static final int ALL_MATCHED = 6;

  public void findSecretWord(String[] wordlist, Master master) {
    int n = wordlist.length;
    int[][] matchMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) { // TODO: j = i
        matchMatrix[i][j] = getMatches(wordlist[i], wordlist[j]);
      }
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> possibleSecretIndices = new ArrayDeque<>();
    possibleSecretIndices.offer(0);
    visited[0] = true;
    while (!possibleSecretIndices.isEmpty()) {
      int guessIndex = possibleSecretIndices.poll();
      int matches = master.guess(wordlist[guessIndex]);
      if (matches == ALL_MATCHED) {
        break;
      }
      for (int index : matchMatrix[guessIndex]) {
        if (!visited[index] && getMatches(wordlist[index], wordlist[guessIndex]) == matches) {
          possibleSecretIndices.offer(index);
          visited[index] = true;
        }
      }
    }
  }

  // precondition: w1.length() == w2.length() == 6
  private static int getMatches(String w1, String w2) {
    int total = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) == w2.charAt(i)) {
        total++;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    G011_GuessTheWord solution = new G011_GuessTheWord();
    Master master = new Master("acckzz");
    String[] wordList = {"acckzz","ccbazz","eiowzz","abcczz"};
    master.guess("aaaaaa");
    solution.findSecretWord(wordList, master);
  }
}

  // This is the Master's API interface.
  // You should not implement it, or speculate about its implementation
//  interface Master {
//      public int guess(String word) ;
//  }
//
//
//public class G011_GuessTheWord implements Master{
//
//	String  word = "acckzz";
//	public int guess(String word) {
//
//		System.out.println();
//		return 0;
//	}
//	public static void main(String[] args) {
//		
//
//		String[] wordlist = {"acckzz","ccbazz","eiowzz","abcczz"};
//		
//				
//		G011_GuessTheWord a = new G011_GuessTheWord();
//		a.findSecretWord(wordlist, a);
//				
//	}
// public void findSecretWord(String[] wordlist, Master master) {
//		int[] count = new int[26];
//		for (String s : wordlist) {
//			for (char c : s.toCharArray()) {
//				count[c - 'a']++;
//			}
//		}
//		Set<String> set = new HashSet<>();
//		for (String s : wordlist) {
//			set.add(s);
//		}
//		int i = 0;
//		while (i++ < 10) {
//			String best = getBestCandidate(set, count);
//			int match = master.guess(best);
//			for (Iterator<String> ite = set.iterator(); ite.hasNext();) {
//				if (match(best, ite.next()) != match) {
//					// Remove the candidate that not matches.
//					ite.remove();
//				}
//			}
//		}
//	}
//
//private String getBestCandidate(Set<String> wordlist, int[] count) {
//		int max = 0;
//		String best = "";
//		for (String s : wordlist) {
//			int c = 0;
//			for (char a : s.toCharArray()) {
//				c += count[a - 'a'];
//			}
//			if (c > max) {
//				max = c;
//				best = s;
//			}
//		}
//		return best;
//	}
//
//private int match(String a, String b) {
//		int count = 0;
//		for (int i = 0; i < a.length(); i++) {
//			if (a.charAt(i) == b.charAt(i))
//				count++;
//		}
//		return count;
//	}
//}

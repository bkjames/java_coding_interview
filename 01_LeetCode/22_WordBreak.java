package aExe03;

import java.util.Set;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {
		//Given a string s and a dictionary of words, determine if s can be segmented
		//into a space-separated sequence of one or more dictionary words.

		public static int wordBreak(String a, ArrayList<String> b) {
			int n = a.length();
			int T[][] = new int[n][n];

			for (int col = 0; col < n; col++){
				for (int i = 0; i < n - col; i++){
					int j = i + col;
					System.out.print("["+i+"]["+j+"]");
					String str = a.substring(i, j +1);
					System.out.print(": " + str);

					if (b.contains(str)){
						T[i][j] = 1;
						System.out.println("\tyes whole");
						continue;
					}
					//find a split point
					for (int k = i + 1; k <= j; k++)
						if (T[i][k -1] == 1 && T[k][j] == 1){
							System.out.println("\tyes split at "+ k);
							T[i][j] = 1;
							break;
						}
					if (T[i][j] == 0)
						System.out.println("\t None");
				}
			}

			for (int i = 0; i < n; i++){
				for (int j = 0; j < n; j++)
					System.out.print(T[i][j] + " ");
				System.out.println();
			}

			return T[0][n -1];
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ArrayList<String> dict = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));
			System.out.println(wordBreak("catsandog", dict));
		}
	
}



public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();
        Map<String, Boolean> mem = new HashMap<>();
        return wordBreak(s, mem, dict);
    }

    private boolean wordBreak(String s, Map<String, Boolean> mem, Set<String> dict) {
        // If the dict contains the word s, return true directly
        if (dict.contains(s)) {
            return true;
        }
        // if the str state has been calculated, return the result directly
        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        for (int i = 1; i < s.length(); i++) {
            // the left part (substring)
            String subStr = s.substring(0, i);
            if (dict.contains(s.substring(i)) && wordBreak(subStr, mem, dict)) {
                // if the word dictionary contains the right substring (word)
                // and the left subStr can be break into a space-separated sequence of one or more dictionary words
                mem.put(s, true);
                return true;
            }
        }

        mem.put(s, false);
        return false;
    }
}


/**
 * Approach 2: DP
 */
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict.contains(s)) {
            return true;
        }
        int maxLength = getMaxLength(dict);

        // State
        boolean[] dp = new boolean[s.length() + 1];

        // Initialize
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = false;
        }

        // Function
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (dp[i - j] && dict.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // Answer
        return dp[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}

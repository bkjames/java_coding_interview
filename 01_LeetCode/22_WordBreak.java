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
 * 超时的 Case 是一个长度非常长的 String,但是反观单词字典，里面的单词长度并不长。
 * 出现超时的现象正是由于我们循环的范围不当所导致的。
 * 分析总结如下：
 *  字符串String与单词word是存在着不同点的，那就是它们的长度！
 *  字符串可以非常的长，但是一个单词长度是有限的。它不可能超过词典中最长英文单词的长度。
 *  所以，我们在for loop时，仅仅需要考虑 i - maxLength ~ i 内的范围即可，而不需要考虑 0 ~ i 全部的范围了。
 *
 * 改进后算法复杂度为：O(NL)
 *  N: 字符串长度     L：最长单词长度
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

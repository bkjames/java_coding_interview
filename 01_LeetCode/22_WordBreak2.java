package ama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WordBreak aa = new WordBreak();
//		ArrayList<String> dict = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
//		System.out.println(aa.wordBreak("catsandog", dict));
		
		ArrayList<String> dict = new ArrayList<>(Arrays.asList("leet", "code"));
		System.out.println(aa.wordBreak("leetcode", dict));
	}
	
	
	    public boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> wordDictSet=new HashSet(wordDict);
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            for (int j = 0; j < i; j++) {
	                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[s.length()];
	    }
	
	
//	3
//	 public boolean wordBreak(String s, List<String> wordDict) {
//	        Set<String> wordDictSet=new HashSet(wordDict);
//	        Queue<Integer> queue = new LinkedList<>();
//	        int[] visited = new int[s.length()];
//	        queue.add(0);
//	        while (!queue.isEmpty()) {
//	            int start = queue.remove();
//	            if (visited[start] == 0) {
//	                for (int end = start + 1; end <= s.length(); end++) {
//	                    if (wordDictSet.contains(s.substring(start, end))) {
//	                        queue.add(end);
//	                        if (end == s.length()) {
//	                            return true;
//	                        }
//	                    }
//	                }
//	                visited[start] = 1;
//	            }
//	        }
//	        return false;
//	    }
	
//2
//	    public boolean wordBreak(String s, List<String> wordDict) {
//	        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
//	    }
//	    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
//	        if (start == s.length()) {
//	            return true;
//	        }
//	        if (memo[start] != null) {
//	            return memo[start];
//	        }
//	        for (int end = start + 1; end <= s.length(); end++) {
//	            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
//	                return memo[start] = true;
//	            }
//	        }
//	        return memo[start] = false;
//	    }
	
	//1
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        return word_Break(s, new HashSet(wordDict), 0);
//    }
//    public static boolean word_Break(String s, Set<String> wordDict, int start) {
//        if (start == s.length()) {
//            return true;
//        }
//        for (int end = start + 1; end <= s.length(); end++) {
//            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
//                return true;
//            }
//        }
//        return false;
//    }
}

package aaa_ama_6mon;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		WordBreak a = new WordBreak();
//		System.out.println(a.wordBreak(s, dict));
		System.out.println(a.wordBreak_dp(s, dict));
	}

	public boolean wordBreak_dp(String s, Set<String> wordDictSet) {
//		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			System.out.println("start i: " + i);
			for (int j = 0; j < i; j++) {
				System.out.println("j: " + j + " i: " + i + " " + (s.substring(j, i)) + "  dp[" + j + "]: " + dp[j]);
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					System.out.println("dp[i]: " + i + " " + dp[i]);
					break;
				}

			}
			System.out.println();
		}
		System.out.println("dp[s.length()]: " + dp[s.length()] + " " + s.length());
		return dp[s.length()];
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (dict.contains(s))
			return true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		// use a set to record checked index to avoid repeated work.
		// This is the key to reduce the running time to O(N^2).
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(0);
		while (!queue.isEmpty()) {
			int curIdx = queue.poll();
			System.out.println("queue curIdx========" + curIdx);
			for (int i = curIdx + 1; i <= s.length(); i++) {
				if (visited.contains(i)) {
					System.out.println("================");
					continue;
				}
				System.out.println("=======curIdx========" + curIdx + " " + i);
				if (dict.contains(s.substring(curIdx, i))) {
					System.out.println("$$$$$$curIdx========" + curIdx + " " + i);
					if (i == s.length())
						return true;
					queue.offer(i);
					visited.add(i);
				}
			}
			System.out.println();
		}
		return false;
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		int max_len = -1;
		for (String word : wordDict)
			max_len = Math.max(max_len, word.length());
		Set<String> wordDictSet = new HashSet(wordDict);
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[s.length()];
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int start = queue.remove();
			for (int end = start + 1; end <= s.length() && end - start <= max_len; end++) {
				if (wordDictSet.contains(s.substring(start, end)) && !(end < s.length() && visited[end])) {
					if (end == s.length()) {
						return true;
					}
					queue.add(end);
					visited[end] = true;
				}
			}
		}
		return false;
	}

}

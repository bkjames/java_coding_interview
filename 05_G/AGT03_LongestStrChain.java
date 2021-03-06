package zGTop;

import java.util.*;

public class AGT03_LongestStrChain {

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		AGT03_LongestStrChain a = new AGT03_LongestStrChain();
		System.out.println(a.longestStrChain(words));
	}

	public int longestStrChain(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		int res = 0;
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		});
		HashMap<String, Integer> map = new HashMap();
		for (String word : words) {
			if (map.containsKey(word))
				continue;
			map.put(word, 1);
			for (int i = 0; i < word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				sb.deleteCharAt(i);
				String next = sb.toString();
				if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
					map.put(word, map.get(next) + 1);
				}
			}
			if (map.get(word) > res)
				res = map.get(word);
		}
		return res;
	}
}

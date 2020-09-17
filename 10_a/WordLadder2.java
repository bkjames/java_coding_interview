package a0914;

import java.util.Arrays;
import java.util.*;

public class WordLadder2 {

	public static void main(String[] args) {
		String[] words = { "hot", "dot", "lot", "log", "cog" };
//		String[] words = {"hot","dot","dog","lot","log"};
		List<String> wordList = Arrays.asList(words);
//		Set<String> dict = new HashSet<>(wordList);
		WordLadder2 a = new WordLadder2();
//		System.out.println(a.findLadders("hit", "cog", wordList));

		List<List<String>> result = a.findLadders("hit", "cog", wordList);
		System.out.println("result: "+result);
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (!wordList.contains(endWord)) {
			return result;
		}
		Queue<List<String>> queue = new LinkedList<List<String>>();
		List<String> list = new ArrayList<String>();
		list.add(beginWord);
		queue.add(list);
		Set<String> wordSet = new HashSet<String>();
		wordSet.addAll(wordList);
		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> currentlyVisited = new HashSet<String>();
			for (int i = 0; i < size; i++) {
				List<String> current = queue.poll();
				String lastWord = current.get(current.size() - 1);
				if (lastWord.equals(endWord)) {
					result.add(current);
				}
				for (int j = 0; j < lastWord.length(); j++) {
					char[] chars = lastWord.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						chars[j] = ch;
						String word = new String(chars);
					
						if (wordSet.contains(word)) {
							System.out.println("word: "+word);
							List<String> updatedList = new ArrayList<String>(current);
							updatedList.add(word);
							currentlyVisited.add(word);
							queue.add(updatedList);
						}
					}
				}
			}
			wordSet.removeAll(currentlyVisited);
			if (result.size() != 0)
				break;
		}
		return result;
	}
	
	
	
	

	public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		List<List<String>> result = new ArrayList<>();

		Queue<List<String>> queue = new LinkedList<>();
		queue.add(Arrays.asList(beginWord));

		int level = 1, finalLevel = Integer.MAX_VALUE;
		List<String> words = new ArrayList<>();
		while (!queue.isEmpty()) {
			List<String> list = queue.poll();

			if (list.size() > level) { // meaning: new word was added to list
				set.removeAll(words);
				words.clear();
				level = list.size();
				if (level > finalLevel)
					break;
			}

			String str = list.get(level - 1);
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char original = arr[i];
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (ch == original)
						continue;
					arr[i] = ch;
					String newStr = String.valueOf(arr);

					if (set.contains(newStr)) {
						words.add(newStr);
						List<String> newList = new ArrayList<>(list);
						newList.add(newStr);
						if (newStr.equals(endWord)) {
							result.add(newList);
							finalLevel = level;
						} else {
							queue.add(newList);
						}
					}
				}
				arr[i] = original;
			}
		}

		return result;
	}
}

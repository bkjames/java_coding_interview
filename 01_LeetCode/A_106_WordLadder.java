package ama;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public static void main(String[] args) {
		String beginWord = "hit" , endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		WordLadder a= new WordLadder();
		System.out.println(a.ladderLength(beginWord, endWord, wordList));
	}
	
	
	  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        if (wordList == null || wordList.size() == 0) {
	            return 0;
	        }
	    
	        Set<String> wordSet = new HashSet<>(wordList);
	        if (!wordSet.contains(endWord)) {
	            return 0;
	        }

	        Queue<String> queue = new LinkedList<>();
	      
	        Set<String> visited = new HashSet<>();
	
	        queue.offer(beginWord);
	        visited.add(beginWord);
	        int level = 1; 

	        // BFS
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                String word = queue.poll();
	              
	                if (word.equals(endWord)) {
	                    return level;
	                }
	             
	                for (String neigh : getNeighbors(word, visited,  wordSet)) {
	                    queue.offer(neigh);
	                }
	            }
	          
	            level++;
	        }

	        return 0;
	    }

	    private List<String> getNeighbors(String word, Set<String> visited, Set<String> wordSet) {
	        List<String> rst = new ArrayList<>();
	        char[] chars = word.toCharArray();

	        for (int i = 0; i < chars.length; i++) {
	            char old = chars[i];   
	            for (char ch = 'a'; ch <= 'z'; ch++) {
	                if (ch == old) {
	                    continue;
	                }
	                chars[i] = ch;
	                String nextWord = String.valueOf(chars);
	                System.out.println(""+nextWord);
	             
	                if (!visited.contains(nextWord) && wordSet.contains(nextWord)) {
	                	System.out.println("@@@@@@@@@@@@@@"+nextWord);
	                    visited.add(nextWord);
	                    rst.add(nextWord);
	                }
	            }
	            chars[i] = old;    
	        }
	        return rst;
	    }
	}


//	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
//		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
//
//		int len = 1;
//		int strLen = beginWord.length();
//		HashSet<String> visited = new HashSet<String>();
//		
//		beginSet.add(beginWord);
//		endSet.add(endWord);
//		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
//			if (beginSet.size() > endSet.size()) {
//				Set<String> set = beginSet;
//				beginSet = endSet;
//				endSet = set;
//			}
//
//			Set<String> temp = new HashSet<String>();
//			for (String word : beginSet) {
//				char[] chs = word.toCharArray();
//
//				for (int i = 0; i < chs.length; i++) {
//					for (char c = 'a'; c <= 'z'; c++) {
//						char old = chs[i];
//						chs[i] = c;
//						String target = String.valueOf(chs);
//
//						if (endSet.contains(target)) {
//							return len + 1;
//						}
//
//						if (!visited.contains(target) && wordList.contains(target)) {
//							temp.add(target);
//							visited.add(target);
//						}
//						chs[i] = old;
//					}
//				}
//			}
//
//			beginSet = temp;
//			len++;
//		}
//		
//		return 0;
//	}
	
//}

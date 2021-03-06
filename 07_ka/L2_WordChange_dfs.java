package test;

import java.util.LinkedList;
import java.util.Queue;
	 
	public class L2_WordChange {
		
		static class Node {
	        String next;
	        int edge;
	 
	        public Node(String next, int edge) {
	            this.next = next;
	            this.edge = edge;
	        }
	    }
		
		public static void main(String[] args) {
			String begin ="hit";
			String target="cog";
			String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
			L2_WordChange a = new L2_WordChange();
			System.out.println(a.solution(begin, target, words));
		}
	 
	    
	 
	    public int solution(String begin, String target, String[] words) {
	        int n = words.length, ans = 0;
	 
	        // for (int i=0; i<n; i++)
	        //  if (words[i] != target && i == n-1) return 0;
	 
	        Queue<Node> q = new LinkedList<>();
	 
	 
	        boolean[] visit = new boolean[n];
	        q.add(new Node(begin, 0));
	 
	        while(!q.isEmpty()) {
	            Node cur = q.poll();
	            System.out.println("cur.next: "+cur.next);
	            if (cur.next.equals(target)) {
	                ans = cur.edge;
	                break;
	            }
	 
	            for (int i=0; i<n; i++) {
	                if (!visit[i] && isNext(cur.next, words[i])) {
	                    visit[i] = true;
	                    System.out.println("words[i]: "+words[i]);
	                    q.add(new Node(words[i], cur.edge + 1));
	                }
	            }
	        }
	 
	        return ans;
	    }
	 
	    static boolean isNext(String cur, String n) {
	    	System.out.println("cur: "+cur+" n: "+n);
	        int cnt = 0;
	        for (int i=0; i<n.length(); i++) {
	            if (cur.charAt(i) != n.charAt(i)) {
	                if (++ cnt > 1) return false;
	            }
	        }
	 
	        return true;
	    }    
	}

package real;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A023_WordLadder {

	public static void main(String[] args) {

		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		String[] words = {"hot","dot","lot","log","cog"};
		
		
		System.out.println(ladderLength("hit", "cog", words));
	}
	public static int ladderLength(String beginWord, String endWord, String[] words) {
		
		Set<String> wordSet = new HashSet<String>();
		for(String s: words) {
			wordSet.add(s);
		}
		
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.add(beginWord);
		
        
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 0;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				System.out.println("*********beginSet: "+beginSet);
				char[] charArr = word.toCharArray();

				for (int i = 0; i < charArr.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = charArr[i];
//						System.out.println("old: "+old+" c: "+c);
						charArr[i] = c;
						String target = String.valueOf(charArr);
						System.out.println("target: "+target);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordSet.contains(target)) {
							System.out.println("====================target: "+target);
							temp.add(target);
							visited.add(target);
						}
						charArr[i] = old;
					}
				}
				System.out.println("==================");
			}
			System.out.println("========temp============temp: "+temp);
			beginSet = temp;
			len++;
		}
		
		return 0;
	}
}

	 
//	
//	class Solution {
//		static boolean[] v;
//		public int dfs(String begin, String target, String[] words) {
//			int answer = 0;
//			String dupBegin;
//			
//			for(int i = 0; i < words.length; i++) {
//				if(v[i]) continue;
//				
//				for(int j = 0; j < begin.length(); j++) {
//					dupBegin = begin;
//					dupBegin = (j > 0 ? begin.substring(0, j) : "") 
//	                                + words[i].charAt(j) + (j < begin.length()-1 ? begin.substring(j+1) : "");				
//					
//					if(dupBegin.equals(target)) 
//						return 1;
//					if(dupBegin.equals(words[i])) {
//						v[i] = true;
//						answer = 1;
//						answer += dfs(dupBegin, target, words);
//					}
//				}
//			}
//			return answer;
//		}
//		
//		public int solution(String begin, String target, String[] words) {
//			v = new boolean[words.length + 1];	
//	        for(int i = 0; i < words.length; i++){
//	            if(target.equals(words[i]))
//	                return dfs(begin, target, words);
//	        }
//			return 0;
//		}
//	}


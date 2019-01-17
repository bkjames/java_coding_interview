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


public static boolean wordBreak2(String s, Set<String> dict) {
		  if (s == null || s.length() == 0) return false;
		  
		  int n = s.length();
		  
		  // dp[i] represents whether s[0...i] can be formed by dict
		  boolean[] dp = new boolean[n];
		  
		  for (int i = 0; i < n; i++) {
		    for (int j = 0; j <= i; j++) {
		      System.out.println("i : "+i+" j: "+j);
		      String sub = s.substring(j, i + 1);
		      System.out.println("sub : "+sub);
		      
		      if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
		        dp[i] = true;
		        System.out.println("i : "+i+" sub: "+sub+" j:"+j);
		        break;
		      }
		    }
		  }
		  
		  return dp[n - 1];
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



/*
 SOLUTION 1: bfs
    Idea is to try to chop off prefix of s that is in the dict
    enqueue the left-over of each chop off
    if there is a time the left over happens to be in the dict as well
        we know word is breakable, b/c all the previous chops are all in the dict
    otherwise the original world is not breakable.
    
    we can use a set to store all the leftovers that we have tried, to avoid enqueue the 
    same leftover multiple times.

*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int index = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        Set<String> visited = new HashSet<String>();
        while(!queue.isEmpty()){
            String candidate = queue.poll();
            if(wordDict.contains(candidate)) return true;
            for(int i = 0; i < candidate.length(); i++){
                String chop = candidate.substring(0,i);
                String next = candidate.substring(i, candidate.length());
                if(!visited.contains(next) && wordDict.contains(chop)){
                    next = candidate.substring(i, candidate.length());
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }
}

/* SOLUTION 2: dfs
    use a set to record the substring (i, s.length) that is not breakable
    start from the front, try to see if the substring (0,i) is in the dict,
    if so, recursively check if there is a way to break (i, s.length)
    
    
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        return helper(s, 0, set, wordDict);
    }
    
    private boolean helper(String s, int index, Set<Integer> set, Set<String> dict){
        if(index == s.length()) return true;
        for(int i = index + 1; i <= s.length(); i++){
            if(set.contains(i)) continue;
            if(dict.contains(s.substring(index, i))){
                 if (helper(s, i, set, dict)) return true;
                 set.add(i);
            }
        }
        return false;
    }
}


/* SOLUTION 3: dp
    dp[i] represents if substring (0,i) is breakable.
    for each longer substring, we just need to check 

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return false;
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(breakable[j] && wordDict.contains(s.substring(j, i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        //for(boolean b : breakable) System.out.print(b + ", ");
        return breakable[s.length()];
    }
}
*/

/* SOLUTION 4: TRIE + MAP  


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Trie trie = new Trie();
        for(String d : wordDict){
            trie.insert(d);
        }
        List<String> prefix = findPrefix(trie, s);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for(String split : prefix){
            if(canBeSplitted(trie, s.replaceFirst(split, ""), map)){
                map.put(split, true);
                return true;
            }
        }
        return false;   
    }
    
    private boolean canBeSplitted(Trie root, String input, Map<String, Boolean> map){
        if(map.containsKey(input)) return map.get(input);
        if(root.search(input) || input.length() == 0) return true;
        List<String> prefix = findPrefix(root, input);
        for(String s : prefix){
            String copy = new String(input);
            if(canBeSplitted(root, copy.replaceFirst(s, ""), map)){
                map.put(input, true);
                return true;
            } 
        }
        map.put(input, false);
        return false;
    }
    
    private List<String> findPrefix(Trie root, String input){
        char[] split = input.toCharArray();
        List<String> result = new ArrayList<String>();
        TrieNode pointer = root.root;
        for(int i = 0; i < split.length; i++){
            pointer = pointer.next[split[i] - 'a'];
            if(pointer == null) break;
            if(pointer.word != null) result.add(pointer.word);
        }
        return result;
    }    

    class TrieNode {
    
        public String word;
        public TrieNode[] next;
        public TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode pointer = root;
            for(int i = 0; i < word.length(); i++){
                if(pointer.next[word.charAt(i) - 'a'] == null){
                    pointer.next[word.charAt(i) - 'a'] = new TrieNode();
                }
                pointer = pointer.next[word.charAt(i) - 'a'];
            }
            pointer.word = word;
        }
    
        public boolean search(String word) {
            TrieNode pointer = root;
            if(root.word != null && root.word.equals(word)) return true;
            for(int i = 0; i < word.length(); i++){
                if(pointer.next[word.charAt(i) - 'a'] == null) return false;
                pointer = pointer.next[word.charAt(i) - 'a'];
            }
            if(pointer.word == null) return false;
            return pointer.word.equals(word);
        }
    
    }    
    
}*/

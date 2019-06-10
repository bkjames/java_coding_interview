package zTest;

import java.util.*;



class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

public class WordSearch2 {
	
	public static void main(String[] args) {
		
		
		char[][] board = {
				{'A','B','T','T','T'},
				{'T','C','D','E','T'},
				{'T','T','T','F','T'},
				{'B','A','H','G','F'},
				{'C','D','E','F','G'}
				};
		String[] words = {"oath","pea","eat","rain"};
		WordSearch2 a = new WordSearch2();
		System.out.println(a.findWords(board, words));
	}
	TrieNode root = new TrieNode();
	TrieNode p = root;
	public List<String> findWords(char[][] board, String[] words) {
	    List<String> res = new ArrayList<>();
	    
//	    TrieNode root = buildTrie(words);
	    boolean[][] visited = new boolean[board.length][board[0].length];
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            dfs (board, i, j,  res, visited);
	        }
	    }
	    
//	    findTrie(p);
	    return res;
	}
	 void findTrie(TrieNode p) {
		 while(p!= null) {
			System.out.println("aaa "+p.next.toString());
//			p = p.next;
		 }
	 }

	public void dfs(char[][] board, int i, int j,  List<String> res, boolean[][] visited) {

	    char c = board[i][j];
	
        if (visited[i][j] == true ) return;
        System.out.println("board["+i+"]["+j+"]"+" c: "+c);
	    int m = c - 'A';

        System.out.println("m: "+m);
        if (p.next[m] == null) p.next[m] = new TrieNode();
        p = p.next[m];
		System.out.println("p: "+p);
        
        
//	    if (c == '#' || p.next[c - 'a'] == null) return;
//	    p = p.next[c - 'a'];
//	    System.out.println("p.word: "+p.word);
//	    if (p.word != null) {   // found one
//	        res.add(p.word);
//	        p.word = null;     // de-duplicate
//	    }

        visited[i][j] = true;
	    if (i > 0) dfs(board, i - 1, j , res, visited); 
	    if (j > 0) dfs(board, i, j - 1,  res,visited);
	    if (i < board.length - 1) dfs(board, i + 1, j,  res,visited); 
	    if (j < board[0].length - 1) dfs(board, i, j + 1,  res, visited); 
	    board[i][j] = c;
	    
	}

	public TrieNode buildTrie(String[] words) {
	    TrieNode root = new TrieNode();
	    for (String w : words) {
	        TrieNode p = root;
	        for (char c : w.toCharArray()) {
	            int i = c - 'a';
	            System.out.println("i: "+i);
	            if (p.next[i] == null) p.next[i] = new TrieNode();
	            p = p.next[i];
	       }
	       System.out.println("w: "+w);
	       p.word = w;
	    }
	    return root;
	}



}

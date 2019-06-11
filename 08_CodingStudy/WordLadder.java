package part1;

import java.util.*;

public class WordLadder {

	
	public static void main(String[] args) {

		Set<String> wordList = new HashSet<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		String[] words = {"hot","dot","lot","log","cog"};
		
		
//		System.out.println(ladderLength("hit", "cog", words));
		WordLadder a = new WordLadder();
		System.out.println(a.ladderLength("hit", "cog", wordList));
	}
	
	public int ladderLength(String b, String e, Set<String> dict) {
	    if(b.equals(e)) return 1;
	    
	    Queue<String> q = new LinkedList<String>();
	    q.add(b);
	    dict.remove(b);

	    int level=2;
	    
	    while(!q.isEmpty()) {
	        int sz = q.size();
	        
	        for(int i=0; i<sz; i++) {
	            String tmp = q.poll();
	            
	            for(int j=0; j<tmp.length(); j++) {
	                char[] chars = tmp.toCharArray();
	                
	                for(char c='a'; c<='z'; c++) {
	                    chars[j] = c;
	                    String tmp2 = new String(chars);
	                    
	                    if(tmp2.equals(e)) return level;
	                    
	                    if(dict.remove(tmp2)) {
	                        q.add(tmp2);
	                    }
	                }
	            }
	        }
	        
	        level++;
	    }
	    
	    return 0;
	}

	public int ladderLength2(String start, String end, Set<String> dict) {
		  // Use queue to help BFS
		  Queue<String> queue = new LinkedList<String>();
		  queue.add(start);
		  queue.add(null);
		  
		  // Mark visited word
		  Set<String> visited = new HashSet<String>();
		  visited.add(start);
		  
		  int level = 1;
		  
		  while (!queue.isEmpty()) {
		    String str = queue.poll();
		    
		    if (str != null) {
		      // Modify str's each character (so word distance is 1)
		      for (int i = 0; i < str.length(); i++) {
		        char[] chars = str.toCharArray();
		        
		        for (char c = 'a'; c <= 'z'; c++) {
		          chars[i] = c;
		          
		          String word = new String(chars);
		          
		          // Found the end word
		          if (word.equals(end)) return level + 1;
		          
		          // Put it to the queue
		          if (dict.contains(word) && !visited.contains(word)) {
		            queue.add(word);
		            visited.add(word);
		          }
		        }
		      }
		    } else {
		      level++;
		      
		      if (!queue.isEmpty()) { 
		        queue.add(null);
		      }
		    }
		  }
		  
		  return 0;
		}
}

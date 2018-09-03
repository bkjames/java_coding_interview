package coding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class WordNode{
    String word;
    int numSteps;
 
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
 
public class WordLadder01 {
	
	  public static void main(String[] args) {
		    String beginWord = "hit";//"hit";
		    String endWord = "cog";
		    Set<String> set = new HashSet<String>();
		    set.add("hot"); set.add("dot"); set.add("dog"); set.add("lot"); set.add("log"); 
		    
		    
		    WordLadder01 sol = new WordLadder01();
		    int leng = sol.ladderLength(beginWord, endWord, set);
		    
		    System.out.println("rst " + leng );
		    System.out.println("END");
		  }
		  
	  
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
        System.out.println("queue: "+queue);
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    System.out.println("newWord: "+newWord);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                      
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }
}

package zTest;
import java.util.*;

public class SentenceSimilar2 {

	public static void main(String[] args) {
		String[] words1= {"great", "acting", "skills"};
		String[] words2= {"fine", "drama", "talent"} ;
		String[][]  pairs = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
		SentenceSimilar2 a = new SentenceSimilar2();
		System.out.println(a.areSentencesSimilarTwo(words1, words2, pairs));
	}
	
	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;           
            if (!graph.containsKey(words1[i])) return false;            
            if (!dfs(graph, words1[i], words2[i], new HashSet<>())) return false;
        }
        
        return true;
    }
    
    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target)) return true;
        
        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited)) 
                    return true;
            }
        }
        return false;
    }
}

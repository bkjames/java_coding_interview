package zGoo1;

import java.util.*;

public class G023_FindAndReplaceString {

	public static void main(String[] args) {
		String S = "abcd";
		int[] indexes = {0,2};
		String[] sources = {"a","cd"}, targets = {"eee","ffff"};
		System.out.println(findReplaceString(S, indexes, sources, targets));
	}
	
	 public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
	        Map<Integer, Integer> table = new HashMap<>();
	        for (int i=0; i<indexes.length; i++) {
	            // if a match is found in the original string, record it
	            if (S.startsWith(sources[i], indexes[i])) {
	                table.put(indexes[i], i);
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        for (int i=0; i<S.length(); ) {
	            if (table.containsKey(i)) {
	                // if a replacement was recorded before
	                sb.append(targets[table.get(i)]);
	                i+=sources[table.get(i)].length();
	            } else {
	                // if no replacement happened at this index
	                sb.append(S.charAt(i));
	                i++;
	            }
	        }
	        return sb.toString();
	    }
	 
	 
	 public static String findReplaceString2(String S, int[] indexes, String[] sources, String[] targets) {
	        List<int[]> sorted = new ArrayList<>();
	        for (int i = 0 ; i < indexes.length; i++) sorted.add(new int[]{indexes[i], i});
	        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
	        for (int[] ind: sorted) {
	            int i = ind[0], j = ind[1];
	            String s = sources[j], t = targets[j];
	            if (S.substring(i, i + s.length()).equals(s)) S = S.substring(0, i) + t + S.substring(i + s.length());
	        }
	        return S;
	    }
}

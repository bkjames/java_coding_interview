package aBasic;

public class IntArray {

	public static void main(String[] args) {
	
	    int[] map_p = new int[26];
	    String p = "ABCD";
	    for (int i = 0; i < map_p.length; i++) {
	        map_p[i]++;
	        System.out.println("i: "+i+" "+map_p[i]);
	        map_p[i]++;
	        System.out.println("i: "+i+" "+map_p[i]);
	    }
	}
}

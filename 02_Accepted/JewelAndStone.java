

public class JewelAndStone {

	public static void main(String[] args) {
		
		String J ="aA";
		String S ="aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
	}
	public static int numJewelsInStones(String J, String S) {
        // Corner cases.
        if (J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;
        
        // Map char to its frequency in S.
        int[] charToFreq = new int[256]; 
        for (char ch : S.toCharArray()) {
            charToFreq[ch]++;
        }
        
        int numJewels = 0; // Number of jewels among stones.
        for (char ch : J.toCharArray()) {
            if (charToFreq[ch] > 0) {
                numJewels += charToFreq[ch];
            }
        }
        
        return numJewels;
    }
}

package zGoo1;

public class G060_OutputContextMatch {

	public static void main(String[] args) {
		int n = 8; 
		System.out.println(findContestMatch(n));
	}
    public static String findContestMatch(int n) {
        String[] team = new String[n];
        for (int i = 1; i <= n; ++i)
            team[i-1] = "" + i;

        for (; n > 1; n /= 2)
            for (int i = 0; i < n / 2; ++i)
                team[i] = "(" + team[i] + "," + team[n-1-i] + ")";

        return team[0];
    }
	
}

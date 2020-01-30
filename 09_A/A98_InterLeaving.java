package aaa_ama_6mon;

public class A98_InterLeaving {

	public static void main(String[] args) {
		String s1 = "aabcc",s2 = "dbbca", s3 = "aadbbcbcac";
		A98_InterLeaving a = new A98_InterLeaving();
		System.out.println(a.isInterleave_dp(s1, s2, s3));
		
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
        // dp[i][j] = true, means first i characters of s1 and first j characters of s2 interleaved to form i+j characters of s3
        // intuition dp[i][j] = true, if(dp[i-1][j] = true and ith char of s1 = (i+j)th char of s3 or dp[i][j-1] = true and jth character of s2 = (i+j)th char of s3
        
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        
        if(t==0) return true;
        if(m+n != t) return false;
        else if(m==0 && n==0 && t!=0) return false;
        else if(m==0 && n!=0 )
        {
            if(s2.equals(s3))
                return true;
            else
                return false;
        }
        else if(m!=0 && n==0)
        {
            if(s1.equals(s3))
                return true;
            else
                return false;
        }
            
        
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        //base case 1
        for(int i=1;i<=m;i++)
        {
            if((s1.substring(0,i)).equals(s3.substring(0,i)))
                dp[i][0] = true;
            else
                dp[i][0] = false;
        }

        //base case 2
        for(int j=1;j<=n;j++)
        {
            if((s2.substring(0,j)).equals(s3.substring(0,j)))
                dp[0][j] = true;
            else
                dp[0][j] = false;
        }
        
        //dp solution
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if( (dp[i-1][j]==true && s1.charAt(i-1)==s3.charAt(i+j-1)) || (dp[i][j-1]==true && s2.charAt(j-1)==s3.charAt(i+j-1)) )
                    dp[i][j] = true;
                 else
                    dp[i][j] = false;
            }
        }
        return dp[m][n];
	
	
	public boolean isInterleave_dp(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if(s3.length() != len1 + len2){
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len1; i++){ //base case, go down
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= len2; i++){  //base case, go right
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //case 1, special case, up and left has the same character.
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                //case2, normal case, only from left
                }else if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                //case3, normal case, only from up
                }else if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }
                /*pay attention, no other cases here,think of: s1 = abc, s2 = def, s3 = abcdef,
                while dp[2][1] will be one of "abd,adb, bad, bda, dab, dba", and we try to match "abc" no match!
                Think of this problem as a matrix, we are tring to find out if there is a path from [0,0]  to [len1 - 1, len2 - 1], 
                so dp[i][j] == false, only mean dp[i][j] is not on the valid path, does not mean there is no such path exists!
                   a  b  c
                   ☑️ ☑️ ☑️
            d               ☑️
            e               ☑️
            f               ☑️(valid path)
            */
            }
        }
        return dp[len1][len2];
    }
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!= s3.length()) return false;
        if(s1.length()==0 && s2.length()==0 && s3.length()==0) return true;
        if(s1.length()==0) return s2.equals(s3);
        if(s2.length()==0) return s1.equals(s3);
        boolean D[]=new boolean[s2.length()+1];
        for(int j=0;j<=s2.length();j++){
        	System.out.println(s2.substring(0,j).equals(s3.substring(0,j))+" s2.substring(0,j) "+s2.substring(0,j)+" s3.substring(0,j): "+s3.substring(0,j));
            D[j]=s2.substring(0,j).equals(s3.substring(0,j));
        }
        boolean res[];
        for(int i=1;i<=s1.length();i++){
            res=new boolean[s2.length()+1];
            System.out.println(s1.substring(0,i)+" : "+s3.substring(0,i)+" "+s1.substring(0,i).equals(s3.substring(0,i)));
            res[0]=s1.substring(0,i).equals(s3.substring(0,i));
            for(int j=1;j<=s2.length();j++){
                if((D[j] && s1.charAt(i-1)==s3.charAt(i+j-1))||(res[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))){
                    res[j]=true;
                }
            }
            D=res;
        }
        return D[D.length-1];
    }
}

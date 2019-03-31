package real;

public class GotoSchool {

    public int solution(int m, int n, int[][] puddles) {
        /* 웅덩이 초기화 */
        boolean[][] isPuddles = new boolean[n][m];
        int[][] map = new int[n][m];
        for (int i = 0; i < puddles.length; i++)
            isPuddles[puddles[i][1] - 1][puddles[i][0] - 1] = true;
         
        boolean flag = true;
        for(int i = 0; i < m; i++) { 
            if(isPuddles[0][i]) flag = false;
            if(flag) map[0][i] = 1;
        }
         
        flag = true;
        for(int i = 0; i < n; i++) {
            if(isPuddles[i][0]) flag = false;
            if(flag) map[i][0] = 1;
        }
         
        for(int i = 1; i < n; i++) 
            for(int j = 1; j < m; j++) 
                if(!isPuddles[i][j]) 
                    map[i][j] = (map[i][j - 1] + map[i - 1][j]) % 1000000007;
 
        return map[n - 1][m - 1];
    }
     
    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        System.out.println(new GotoSchool().solution(4, 3, puddles));
    }
}

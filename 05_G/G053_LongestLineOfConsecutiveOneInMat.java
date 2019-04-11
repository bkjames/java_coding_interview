package zGoo1;

public class G053_LongestLineOfConsecutiveOneInMat {

	public static void main(String[] args) {
		G053_LongestLineOfConsecutiveOneInMat a = new G053_LongestLineOfConsecutiveOneInMat();
		int[][] M = {{0,1,1,0},
				 {0,1,1,0},
				 {0,0,0,1}};
		System.out.println(a.longestLine(M));
	}
	 public int longestLine(int[][] M) {
	        if(M == null) return 0;
	        int res = 0;
	        for(int i =0;i<M.length;i++){
	            for(int j = 0;j<M[0].length;j++){
	                if(M[i][j] == 1){
	                    res = Math.max(res,getMaxOneLine(M, i, j));
	                }
	            }
	        }
	        return res;
	    }
	    final int [][] dirs = new int[][]{{1,0},{0,1},{1,1},{1,-1}};
	    private int getMaxOneLine(int [][] M, int x, int y){
	        int res = 1;
	        for(int [] dir:dirs){
	            int i = x+dir[0];
	            int j = y+dir[1];
	            int count = 1;
	            while(isValidPosition(M, i, j) && M[i][j] == 1){
	                i+=dir[0];
	                j+=dir[1];
	                count++;
	            }
	            res = Math.max(count,res);
	        }
	        return res;
	    }
	    
	    private boolean isValidPosition(int M[][], int i, int j){
	        return (i<M.length && j<M[0].length && i>=0 && j>=0);
	    }
}

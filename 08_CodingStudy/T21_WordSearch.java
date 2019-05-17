package part1;

public class T21_WordSearch {

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
				};
		
		String word = "ABCCED";
		T21_WordSearch a = new T21_WordSearch();
		System.out.println(a.exist(board, word));
		
	}
	
	 int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
	    public boolean exist(char[][] board, String word) {
	        if (board==null ||board.length==0||board[0].length==0) return false;
	        int m=board.length,n=board[0].length;
	        boolean[][] visited=new boolean[m][n];
	        for (int i=0;i< m;i++){
	            for (int j=0;j<n;j++){               
	                if (dfs(board,visited,i,j,0,word)){
	                    return true;
	                }              
	            }
	        }
	        return false;
	    }
	    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, int i, String word){         
	        int m=board.length,n=board[0].length;   
	        if (i==word.length()) return true;
	        
	        if(x<0||x>=m||y<0||y>=n) return false;
	        if(visited[x][y]) return false;
	        System.out.println("board["+x+"]["+y+"] "+word.charAt(i)+" i "+i);
	        if(board[x][y]!=word.charAt(i)) {
	        	System.out.println("word.charAt(i) "+word.charAt(i)+" i "+i);
	        	return false;
	        }
	        
	        
	        visited[x][y]=true;
	        System.out.println("visited["+x+"]["+y+"] "+visited[x][y]);
	        for (int[] dir: dirs){
	            int x1=x+dir[0];
	            int y1=y+dir[1];
	            System.out.println("x1: "+x1+" y1: "+y1);
	            if (dfs(board, visited, x1, y1, i+1, word)){
	                return true;
	            }
	        }
	        visited[x][y]=false;
	        return false;                                                                          
	    }
	
//	boolean[][] visited;
//    public  boolean exist(char[][] board, String word) {
//        visited = new boolean[board.length][board[0].length];
//        
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[i].length; j++){
//                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
//                    return true;
//                }
//            }
//        }
//        
//        return false;
//    }
//    
//    private boolean search(char[][]board, String word, int i, int j, int index){
//        if(index == word.length()){
//            return true;
//        }
//        
//        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
//            return false;
//        }
//        
//        visited[i][j] = true;
//        if(search(board, word, i-1, j, index+1) || 
//           search(board, word, i+1, j, index+1) ||
//           search(board, word, i, j-1, index+1) || 
//           search(board, word, i, j+1, index+1)){
//           return true;
//        }
//        
//        visited[i][j] = false;
//        return false;
//    }
	

	
	

}

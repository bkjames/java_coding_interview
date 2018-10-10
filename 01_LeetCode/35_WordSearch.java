package coding;



/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 */
public class WordSearch {

     public boolean exist3(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        // visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int  j = 0; j < board[0].length; j++) {
                // If the dfs's result it true, it means that we can find the word in board.
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        // if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index) || visited[i][j]) {
        //     return false;
        // }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // visited[i][j] = true;
        char temp = board[i][j];
        board[i][j] = '#';
        
        // int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1 }};
        // for (int[] dir : dirs) {
        //     if (dfs(board, i + dir[0], j + dir[1], word, index + 1)) {
        //         return true;
        //     }
        // }
        // go to the four directions, check whether we can find the next character of the word or not.
        if (dfs(board, i-1, j, word, index+1)
                || dfs(board, i+1, j, word, index+1)
                || dfs(board, i, j-1, word, index+1)
                || dfs(board, i, j+1, word, index+1)) {
            return true;
        }
        // Backtracking
        // visited[i][j] = false;
        board[i][j] = temp;

        return false;
    }


    public static void main(String[] args)
	{

        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

  

        String wordTest = "ABCCED";
        WordSearch word1 = new WordSearch();
        boolean result =  word1.exist3(board, wordTest);
        System.out.println("result : "+result);
        

}

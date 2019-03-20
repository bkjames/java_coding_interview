package real;

import java.util.*;
public class K2018_BlockGame {
	
	public static void main(String[] args) {
		int [][] grid = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,4,0,0,0},
				{0,0,0,0,0,4,4,0,0,0},
				{0,0,0,0,3,0,4,0,0,0},
				{0,0,0,2,3,0,0,0,5,5},
				{1,2,2,2,3,3,0,0,0,5},
				{1,1,1,0,0,0,0,0,0,5}
				};
		
		K2018_BlockGame a = new K2018_BlockGame();
		System.out.println(a.solution(grid));
		
	}


    int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int BLACK = -1;

    public int solution(int[][] board) {
        int width = board.length;
        int height = board[0].length;

        boolean[][] visit = new boolean[width][height];

        int answer = 0;
        List<Puzzle> list = new LinkedList<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (visit[i][j] || board[i][j] < 1) {
                    continue;
                }

                Position p = new Position(i, j);
                Puzzle puzzle = bfs(board, visit, p);
                list.add(puzzle);
            }
        }

        while (!list.isEmpty()) {
            boolean find = false;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (board[j][i] > 0) {
                        break;
                    }

                    board[j][i] = BLACK;
                }
            }

            Iterator<Puzzle> it = list.iterator();
            iterating : while (it.hasNext()) {
                Puzzle puzzle = it.next();

                for (int i = puzzle.minR; i <= puzzle.maxR; i++) {
                    for (int j = puzzle.minC; j <= puzzle.maxC; j++) {
                        if (board[i][j] != puzzle.type && board[i][j] != BLACK) {
                            continue iterating;
                        }
                    }
                }

                for (Position p : puzzle.blocks) {
                    board[p.r][p.c] = 0;
                }

                answer++;
                find = true;
                it.remove();
            }

            if (!find) {
                break;
            }
        }

        return answer;
    }

    public Puzzle bfs(int[][] board, boolean[][] visit, Position start) {
        int type = board[start.r][start.c];
        Puzzle puzzle = new Puzzle(type);

        Queue<Position> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Position p = q.poll();
                puzzle.addBlock(p);
                visit[p.r][p.c] = true;

                for (int[] d : DIR) {
                    int nr = p.r + d[0];
                    int nc = p.c + d[1];

                    if (nr < 0 || nr >= board.length ||
                            nc < 0 || nc >= board[0].length ||
                            board[nr][nc] != type || visit[nr][nc]) {
                        continue;
                    }

                    Position np = new Position(nr, nc);
                    q.add(np);
                }
            }
        }

        return puzzle;
    }

    class Puzzle {
        int type;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        List<Position> blocks = new LinkedList<>();

        public Puzzle(int type) {
            this.type = type;
        }

        public void addBlock(Position p) {
            blocks.add(p);

            maxR = Math.max(maxR, p.r);
            minR = Math.min(minR, p.r);
            maxC = Math.max(maxC, p.c);
            minC = Math.min(minC, p.c);
        }
    }

    class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}


//public class K2018_BlockGame {
//	
//	public static void main(String[] args) {
//		int [][] grid = {
//				{0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,4,0,0,0},
//				{0,0,0,0,0,4,4,0,0,0},
//				{0,0,0,0,3,0,4,0,0,0},
//				{0,0,0,2,3,0,0,0,5,5},
//				{1,2,2,2,3,3,0,0,0,5},
//				{1,1,1,0,0,0,0,0,0,5}
//				};
//		
//		K2018_BlockGame a = new K2018_BlockGame();
//		System.out.println(a.solution(grid));
//		
//	}
//
//		private int N;
//
//		public int solution(int[][] board) {
//			N = board.length;
//
//			int answer = 0;
//			while (true) {
//				if (locateBlack(0, board))
//					answer++;
//				else
//					break;
//			}
//
//			return answer;
//		}
//
//		private boolean locateBlack(int x, int[][] b) {
//			for (int y = 0; y < N; y++) {
//				if (b[y][x] <= 0)
//					continue;
//
//				boolean result = false;
//				setBlack(y, x, true, b);
//				result = (x == N - 1) ? findBlock(b) : locateBlack(x + 1, b);
//				setBlack(y, x, false, b);
//				return result;
//			}
//
//			return (x == N - 1) ? findBlock(b) : locateBlack(x + 1, b);
//		}
//
//		private void setBlack(int y, int x, boolean turn, int[][] b) {
//			if (y - 1 >= 0)
//				b[y - 1][x] = (turn) ? -1 : 0;
//			if (y - 2 >= 0)
//				b[y - 2][x] = (turn) ? -1 : 0;
//		}
//
//		private boolean findBlock(int[][] b) {
//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < N; x++) {
//					if (b[y][x] <= 0)
//						continue;
//					if (removeBlock(y, x, b[y][x], b))
//						return true;
//				}
//			}
//
//			return false;
//		}
//
//		private boolean removeBlock(int y, int x, int E, int[][] b) {
//			if (y + 1 < N && x + 2 < N
//				&& b[y + 1][x] == E && b[y + 1][x + 1] == E && b[y + 1][x + 2] == E
//				&& b[y][x + 1] == -1 && b[y][x + 2] == -1)
//			{
//				b[y][x] = 0;
//				b[y + 1][x] = 0;
//				b[y + 1][x + 1] = 0;
//				b[y + 1][x + 2] = 0;
//				return true;
//			}
//
//			if (y + 2 < N && x - 1 >= 0
//				&& b[y + 1][x] == E && b[y + 2][x] == E && b[y + 2][x - 1] == E
//				&& b[y][x - 1] == -1 && b[y + 1][x - 1] == -1)
//			{
//				b[y][x] = 0;
//				b[y + 1][x] = 0;
//				b[y + 2][x] = 0;
//				b[y + 2][x - 1] = 0;
//				return true;
//			}
//
//			if (y + 2 < N && x + 1 < N
//				&& b[y + 1][x] == E && b[y + 2][x] == E && b[y + 2][x + 1] == E
//				&& b[y][x + 1] == -1 && b[y + 1][x + 1] == -1)
//			{
//				b[y][x] = 0;
//				b[y + 1][x] = 0;
//				b[y + 2][x] = 0;
//				b[y + 2][x + 1] = 0;
//				return true;
//			}
//
//			if (y + 1 < N && x - 2 >= 0
//				&& b[y + 1][x] == E && b[y + 1][x - 1] == E && b[y + 1][x - 2] == E
//				&& b[y][x - 1] == -1 && b[y][x - 2] == -1)
//			{
//				b[y][x] = 0;
//				b[y + 1][x] = 0;
//				b[y + 1][x - 1] = 0;
//				b[y + 1][x - 2] = 0;
//				return true;
//			}
//
//			if (y + 1 < N && x - 1 >= 0 && x + 1 < N
//				&& b[y + 1][x - 1] == E && b[y + 1][x] == E && b[y + 1][x + 1] == E
//				&& b[y][x - 1] == -1 && b[y][x + 1] == -1)
//			{
//				b[y][x] = 0;
//				b[y + 1][x - 1] = 0;
//				b[y + 1][x] = 0;
//				b[y + 1][x + 1] = 0;
//				return true;
//			}
//
//			return false;
//		}
//	
//}


//2
//class Solution {
//    int[][] Board;
//    int N;
//    int[] maxRow;
//
//    void setMaxRow(int col) {
//        int row = 0;
//        for (row = 0; row < N; row++) {
//            if (Board[row][col] != 0)
//                break;
//        }
//        maxRow[col] = row;
//    }
//
//    public int solution(int[][] board) {
//        this.Board = board;
//        N = board.length;
//        maxRow = new int[board[0].length];
//        int answer = 0;
//
//        // set maxRow
//
//        for (int i = 0; i < N; i++) {
//            setMaxRow(i);
//        }
//
//        int cnt = 1;
//        while(cnt > 0) {
//            cnt = 0;
//
//            for (int i = 0; i < N; i++) {
//                cnt += upTwo(i); // 1-4, 2-2
//                cnt += sideBySide(i); // 1-3, 2-3, 3-1
//            }
//            answer += cnt;
//        }
//        return answer;
//    }
//
//    int upTwo(int col) {
//
//        // validation
//        if (N <= col + 1) return 0;
//        int maxR = Math.max(maxRow[col], maxRow[col + 1]);
//        if (maxR-2 < 0 || N <= maxR) return 0;
//
//        int val = Board[maxR][col];
//        int blankCnt = 0;
//        int[][] tmpBoard = new int[Board.length][Board[0].length];
//
//        for(int i = 0; i < Board.length; i++){
//            for(int j = 0; j < Board[0].length; j++){
//                tmpBoard[i][j] = Board[i][j];
//            }
//        }
//
//        for (int i = maxR-2; i <= maxR; i++) {
//            for (int j = col; j <= col+1; j++) {
//                if (Board[i][j] != val && Board[i][j] != 0)
//                    return 0;
//                if (Board[i][j] == 0)
//                    blankCnt++;
//                tmpBoard[i][j] = 0;
//            }
//        }
//        if (blankCnt != 2)
//            return 0;
//
//        Board = tmpBoard;
//        setMaxRow(col + 1);
//        setMaxRow(col);
//        return 1;
//    }
//
//    int sideBySide(int col) {
//
//        // validation
//        if (N <= col + 2) return 0;
//        int row1 = maxRow[col];
//        int row2 = maxRow[col + 1];
//        int row3 = maxRow[col + 2];
//        int maxR = Math.max(row1, Math.max(row2, row3));
//        int minR = Math.min(row1, Math.min(row2, row3));
//        int sameMax = 0;
//        if (row1 == maxR) sameMax++;
//        if (row2 == maxR) sameMax++;
//        if (row3 == maxR) sameMax++;
//        if (sameMax != 2 || minR < 0 || N <= maxR) return 0;
//        if (maxR-1 < 0 || N <= maxR) return 0;
//
//        int val = Board[maxR][col];
//
//        int[][] tmpBoard = new int[Board.length][Board[0].length];
//
//        for(int i = 0; i < Board.length; i++){
//            for(int j = 0; j < Board[0].length; j++){
//                tmpBoard[i][j] = Board[i][j];
//            }
//        }
//
//        int blankCnt = 0;
//        for (int i = maxR - 1; i <= maxR; i++) {
//            for (int j = col; j <= col+2; j++) {
//                if (Board[i][j] != val && Board[i][j] != 0)
//                    return 0;
//                if (Board[i][j] == 0)
//                    blankCnt++;
//                tmpBoard[i][j] = 0;
//            }
//        }
//        if (blankCnt != 2)
//            return 0;
//
//        Board = tmpBoard;
//        setMaxRow(col + 2);
//        setMaxRow(col);
//        setMaxRow(col + 1);
//        return 1;
//    }
//
//}

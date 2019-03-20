package real;
import java.util.*;

public class K2017_4Block {
	
	
	public static void main(String[] args) {
		
		int m = 6;
		// 판의 폭
		int n = 6;
		// 판의 배치 정보
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
//		for ( String item : board ) {
//			System.out.println(item);
//		}
		K2017_4Block a = new K2017_4Block();
		a.solution(m, n, board);
	}

  public int solution(int m, int n, String[] board) {
	  
	    int delCount = 0;
		
		boolean delPoint = true;
		while ( delPoint ) {
				delPoint = false;
				List<String> delList = new ArrayList();
				for ( int i = 0 ; i < m - 1 ; i++ ) {
					for ( int j = 0 ; j < n - 1 ; j++ ) {
						char item1 = board[i].charAt(j);
						char item2 = board[i].charAt(j+1);
						char item3 = board[i+1].charAt(j);
						char item4 = board[i+1].charAt(j+1);
						if ( item1 != ' ' && item1 == item2 && item1 == item3 && item1 == item4 ) {
							delPoint = true;
							delList.add(i + "-" + j);
						}
					}
				}
				System.out.println(delList);
				
				for ( String delIndex : delList ) {
					int i = Integer.parseInt( delIndex.split("-")[0] );
					int j = Integer.parseInt( delIndex.split("-")[1] );
					
					if ( board[i].charAt(j) != ' ' ) {
						board[i] = board[i].substring(0, j) + " " + board[i].substring(j+1);
						delCount++;
					}
					if ( board[i].charAt(j+1) != ' ' ) {
						board[i] = board[i].substring(0, j+1) + " " + board[i].substring(j+2);
						delCount++;
					}
					if ( board[i+1].charAt(j) != ' ' ) {
						board[i+1] = board[i+1].substring(0, j) + " " + board[i+1].substring(j+1);
						delCount++;
					}
					if ( board[i+1].charAt(j+1) != ' ' ) {
						board[i+1] = board[i+1].substring(0, j+1) + " " + board[i+1].substring(j+2);
						delCount++;
					}
				}
				
				boolean flag = true;
				while ( flag ) {
					flag = false;
					for ( int i = 1 ; i < m ; i++ ) {
						for ( int j = 0 ; j < n ; j++ ) {
							char item1 = board[i].charAt(j);
							char item2 = board[i-1].charAt(j);
							if ( item1 == ' ' && item2 != ' ' ) {
								System.out.println("item1: "+item1+" item2: "+item2);
								flag = true;
								
								board[i-1] = board[i-1].substring(0, j) + " " + board[i-1].substring(j+1);
								System.out.println("a: "+board[i-1] );
								board[i] = board[i].substring(0, j) + item2 + board[i].substring(j+1);
								System.out.println("b: "+board[i] );
							}
						}
					}
				}
				
				System.out.println("삭제블록 원좌표 : " + delList);
				
				for ( String item : board ) {
					System.out.println(item);
				}
		}
		
		System.out.println("final 삭제블록수 : " + delCount);
		  return delCount;
	}

  

}

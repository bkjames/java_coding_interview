package real;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class K2017_DartGame {
	public static void main(String[] args) {

		// 숫자문자열
		final String numExp = "0123456789";
		
		// 다트결과 문자열
		String dartResult = "1S2D*3T";
		
		// 점수
		int answer = 0;

		// 각회별 점수
		int[] score = {0,0,0};
		
		// 점수계산
		for ( int i = 0 ; i < 3 ; i++ ) {
			String num = "";
			while ( numExp.indexOf( dartResult.charAt(0) ) != -1 ) {
				num += dartResult.charAt(0);
				dartResult = dartResult.substring(1);
			}
			
			char bonus = dartResult.charAt(0);
			dartResult = dartResult.substring(1);
			
			char option = ' ';
			if ( dartResult.length() > 0 ) {
				option = dartResult.charAt(0);
				if ( numExp.indexOf( option ) == -1 ) {
					dartResult = dartResult.substring(1);
				}
			}
			
			if ( bonus == 'S' ) {
				score[i] += Math.pow(Integer.parseInt(num), 1);
			} else if ( bonus == 'D' ) {
				score[i] += Math.pow(Integer.parseInt(num), 2);
			} else if ( bonus == 'T' ) {
				score[i] += Math.pow(Integer.parseInt(num), 3);
			}
			
			if ( option == '*' ) {
				if ( i != 0 ) score[i-1] = score[i-1] * 2;
				score[i] = score[i] * 2;
			} else if ( option == '#' ) {
				score[i] = -score[i];
			}
			
			System.out.println("회별 점수 : " + score[0] + "," + score[1] + "," + score[2]);
		}
		
		answer = score[0] + score[1] + score[2];
		System.out.println("종합 점수 : " + answer);
	}

}

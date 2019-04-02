package test0329;

import java.util.*;
//file 클래스
	class File{
	  int idx;
	  int pri;
	  File(int idx, int pri){
	      this.idx = idx;
	      this.pri = pri;
	  }
	}
	public class L2_Printer {
		
	public static void main(String[] args) {
		L2_Printer a = new L2_Printer();
		int[] priorities = {2, 1, 3, 2};
		int location=2;
		System.out.println(a.solution(priorities, location));
	}
		 
	  //중요도 갯수 배열
	  static int[] priority = new int[10];
	  //프린트 가능하면 true 반환
	  public static boolean check(File temp){
	      int tempP = temp.pri;
	      for(int i = tempP + 1; i < 10; i++){
	          if(priority[i] != 0){
	              return false;
	          }
	      }
	      return true;
	  }
	  
	  public int solution(int[] priorities, int location) {
	      int len = priorities.length;
	      //문서 대기 큐
	      Queue<File> q = new LinkedList<File>();
	      //중요도 배열 세팅 및 문서 대기 큐 세팅
	      for(int i = 0; i < len; i++){
	          priority[priorities[i]]++;
	          q.add(new File(i, priorities[i]));
	      }
	      //순서
	      int answer = 0;
	      while(!q.isEmpty()){
	          File t = q.remove();
	          //프린트 가능한지 확인
	          boolean flag = check(t);
	          //프린트 가능하다면 flag = true
	          if(flag){
	              //순서+
	              answer++;
	              //찾던 거라면
	              if(t.idx == location){
	                  return answer;
	              }
	              //찾던게 아니라면 중요도 갯수 -
	              priority[t.pri]--;
	          }
	          //프린트 불가능이면 대기 문서 뒤에 다시 삽입
	          else{
	              q.add(t);
	          }
	      }
	      return answer;
	  }
	}

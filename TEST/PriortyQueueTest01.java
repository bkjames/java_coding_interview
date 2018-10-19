package aBasic;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Comparator;
import java.util.PriorityQueue; 
import java.util.StringTokenizer;

class Member{
	int uid;
	int age;
	String name;
	Member(int uid, int age, String name){
		this.uid = uid;
		this.age = age;
		this.name = name;
	}
}

public class PriortyQueue01{
	public static void main(String[] args) {
		
		
		
		
		PriorityQueue<Member> q1 = new PriorityQueue<Member>(new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				// / 오름차순 가정할때 

				// 현재 객체 < target  작은 수 라면 -1

				// 현재 객체 > target 큰 수라면 1

				// 동일하다면 0을 반환
				if(m1.age < m2.age) {
					return -1;
				}else if(m1.age >m2.age) {
					return 1;
				}else {
					return m1.uid - m2.uid;
				}
			}
			
		});
		
		q1.add(new Member(1, 10, "aaa"));
		q1.add(new Member(20,55, "bbb"));
		q1.add(new Member(3, 40, "ccc"));
		q1.add(new Member(7, 12, "ddd"));
		
		while(!q1.isEmpty()) {
			Member m = q1.poll();
			System.out.println(m.age+" "+m.name);
		}
	
	
		
	}
	
}

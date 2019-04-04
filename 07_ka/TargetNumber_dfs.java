package test0404;

public class TargetNumber {

	  private static int answer = 0;
	    public static void main(String[] args) {
	        int[] numbers = {1, 1, 1, 1, 1};
	        int target = 3;
	        TargetNumber solution = new TargetNumber();
	        System.out.println(solution.solution(numbers, target));
	    }
	    
	    
	    private int count, size, t;
	    public int solution(int[] numbers, int target) {
	        size = numbers.length;
	        t = target;
	        dfs(0, numbers, 0);

	        return count;
	    }

	    private void dfs(int currentIndex, int[] numbers, int currentSum) {
	    	System.out.println("currentIndex: "+currentIndex+" currentSum: "+currentSum);
	        if(currentIndex == size) {
	            if(currentSum == t) {
	                count++;
	            }
	            return;
	        }

	        dfs(currentIndex+1, numbers, currentSum+numbers[currentIndex]);
	        dfs(currentIndex+1, numbers, currentSum-numbers[currentIndex]);
	        System.out.println("=====end===currentIndex: "+currentIndex+" currentSum: "+currentSum);
	    }

//	    public int solution(int[] numbers, int target) {
//	        int[] flag = new int[numbers.length];
//	        findTargetNumber(numbers, target, flag, 0);
//	        return answer;
//	    }
//
//	    public static void findTargetNumber(int[] numbers, int target, int[] flag, int depth) {
//	        if (depth == numbers.length) {
//	            int sum=0;
//	            int max = numbers.length;
//	            for (int i = 0; i < max; i++) {
//	                if (flag[i] == 1) {
//	                    sum += numbers[i];
//	                } else {
//	                    sum -= numbers[i];
//	                }
//	            }
//	            if (sum == target) {
//	                answer++;
//	            }
//	            return;
//	        }
//
//	        //더하는경우
//	        flag[depth] = 1;
//	        findTargetNumber(numbers, target, flag, depth + 1);
//
//	        //빼는경우
//	        flag[depth] = 0;
//	        findTargetNumber(numbers, target, flag, depth + 1);
//	    }
}




package test0325;

import java.util.*;

//class Tree{
class Node{
    Node parent;
    int data;
    Node left;
    Node right;
    int index;
    Node(int data, int index){
        this.data = data;
        this.index = index;
    }
}


public class TargetNumber_dfs {

//	public int solution(int[] numbers, int target) {
//        return DFS(numbers, target, 0, 0);
//    }
// 
//    public int DFS(int[] numbers, int target, int index, int num) {
//        if(index == numbers.length) {
//            return num == target ? 1 : 0;
//        } else {
//            return DFS(numbers, target, index + 1, num + numbers[index])
//                    + DFS(numbers, target, index + 1, num - numbers[index]);
//        }
//    }
 
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            System.out.print("arr["+i+"]"+ arr[i]+" ");
        }
        System.out.println();
        int target = 3;
 
        System.out.println(new TargetNumber_dfs().solution(arr, target));
    }
    
//    1 queue bfs
    public int solution(int[] numbers, int target) {
        Queue<Node> Q = new LinkedList<Node>();
        int answer = 0;
        Q.add(new Node(0, 0));
        while(!Q.isEmpty()){
            Node a = Q.poll();
            System.out.println("index:"+a.index + "data:" + a.data);
            if(a.index==numbers.length){
                if(a.data==target)
                    answer++;
                continue;
            }

            a.left = new Node(a.data + numbers[a.index] , a.index+1);
            a.right = new Node(a.data - numbers[a.index] , a.index+1);
            Q.add(a.left);
            Q.add(a.right);
        }
        return answer;
    }
}


    
    
  //음수 아닌 정수, +-로 수 만들기
    //만드는 방법의 수
    static int[] num;
    static int len;
    static int count = 0;
    //경우의 수는 +/-
    //targer = 목표 수 / tempNum = 현재 수 / i = 현재 index
    public void check(int target, int tempNum, int i){
        //i가 끝이면
        if(i >= len - 1){
            if(tempNum + num[i] == target){
                count++;
            }
            if(tempNum - num[i] == target){
                count++;
            }  
            return;
        }
        //i가 끝이 아니면 경우의 수 따지기
        check(target, tempNum + num[i], i + 1);
        check(target, tempNum - num[i], i + 1);
    }
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        num = new int[len];
        for(int i = 0; i < len; i++){
            num[i] = numbers[i];
        }
        check(target, 0, 0);
        return count;
    }
    
    
    2 dfs
    private int count, size, t;
    public int solution(int[] numbers, int target) {
        size = numbers.length;
        t = target;
        dfs(0, numbers, 0);

        return count;
    }

    private void dfs(int currentIndex, int[] numbers, int currentSum) {
        if(currentIndex == size) {
            if(currentSum == t) {
                count++;
            }
            return;
        }

        dfs(currentIndex+1, numbers, currentSum+numbers[currentIndex]);
        dfs(currentIndex+1, numbers, currentSum-numbers[currentIndex]);
    }
    
    
    
    Queue<Integer> q = new LinkedList<Integer>();
    public int solution(int[] numbers, int target) {
        int answer = 0;
        q.offer(0);
        q.offer(0);
        while(q.peek()!=null){
            int level =q.poll();
            int v = q.poll();
            if(level==numbers.length){
                if(v==target)
                    answer++;
            }else {

                q.offer(level + 1);
                q.offer(v + numbers[level]);

                q.offer(level + 1);
                q.offer(v - numbers[level]);
            }
        }
        return answer;
    }
//}


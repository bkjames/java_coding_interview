package coding04;

import java.util.Stack;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next= new ListNode(5);
		l1.next.next = new ListNode(5);
		System.out.println(isPalindrome(l1));
	}
	
	
	 public static boolean isPalindrome(ListNode head) {
	        if (head == null) {
	            return false;
	        }

	        Stack<ListNode> stack = new Stack<>();
	        ListNode mid = getMid(head);
	     
	        while (mid != null) {
	            stack.push(mid);
	            mid = mid.next;
	        }

	
	        while (!stack.isEmpty()) {
	            if (head.val != stack.pop().val) {
	                return false;
	            }
	            head = head.next;
	        }
	        return true;
	    }

	    private static ListNode getMid(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
}

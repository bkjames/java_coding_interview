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
	        // 将链表后半部分的元素入栈以实现逆序
	        while (mid != null) {
	            stack.push(mid);
	            mid = mid.next;
	        }

	        // 将链表中的元素取出来，依次与链表的前半部分进行比较
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

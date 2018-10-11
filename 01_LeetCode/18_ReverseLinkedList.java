package LinkedList;


class ListNode{
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}
public class ReverseLinkedList {
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
//		l1.next.next.next = new ListNode(4);
		
		ListNode head = reverseList(l1);
		printNode(head);
	}

	
	// Reverse a single linked list through iterative method
		public static ListNode reverseList(ListNode current) {
			ListNode prev = null;
			ListNode next = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
		}
		
		public static void printNode(ListNode head) {
			System.out.print("printNode : ");
			while (head != null) {
				System.out.print(head.val);
				head = head.next;
			}
			System.out.println();
		}
}

package zExe02;


class ListNode{
	int val;
	ListNode next;
	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}

public class AddTwoNumbers01 {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(3);
		
		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(4);
		
		ListNode l4 = addTwoNumbers(list1, list2);
		printNode(l4);
	}
	
	public static void printNode(ListNode listNode4) {
		while(listNode4 != null) {
			System.out.println(listNode4.val+"");
			listNode4 = listNode4.next;
		}
		System.out.println("");
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode newHead = new ListNode(0);
		ListNode p1=l1, p2=l2, p3=newHead;
		int carry =0;
		while(p1 != null || p2 != null) {
			
			if(p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if(p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			    p3.next = new ListNode(carry%10);
			    p3 = p3.next;
			    carry /=10;
		}
		if(carry ==1) p3.next = new ListNode(1);
		return newHead.next;
	}
}

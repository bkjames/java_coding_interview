package aExe02;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
}

public class MergeTwoSortedList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode listNode =mergeTwoLists(l1,l2);
		print(listNode);
	}
	
	public static void print(ListNode listNode) {
		while(listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    ListNode head = new ListNode(0);
	    ListNode p=head;
	 
	    ListNode p1=l1;
	    ListNode p2=l2;
	    while(p1!=null && p2!=null){
	        if(p1.val < p2.val){
	            p.next = p1;
	            p1 = p1.next;
	        }else{
	            p.next = p2;
	            p2 = p2.next;
	        }
	        p=p.next;
	    }
	 
	    if(p1!=null){
	        p.next = p1;
	    }
	 
	    if(p2!=null){
	        p.next = p2;
	    }
	 
	    return head.next;
	}

}

package LinkedList;

class ListNode{
	int val ;
	ListNode next;
	ListNode(int x){
		this.val = x;
		this.next = null;
	}
	
}
public class LinkedListCycle {

    public static void main(String[] args)  
    { 
       ListNode l1 = new ListNode(1);
       ListNode l2 = new ListNode(2);
       ListNode l3 = new ListNode(3);
       ListNode l4 = new ListNode(4);
       
       l1.next = l2;
       l1.next.next = l3;
       l1.next.next.next = l4;
       l1.next.next.next.next =l2;
       
       System.out.println(hasCycle(l1));
      
    } 

	    public static boolean hasCycle(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;
	 
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	            System.out.println(slow);
	            System.out.println(fast);
	            if(slow == fast)
	                return true;
	        }
	 
	        return false;
	    }
	
	
}

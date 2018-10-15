package code4;


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}
public class IntersectionOfTwoLinkedlists {
	
	public static void main(String[] args) {
		 // creating first linked list 
		ListNode l1 = new ListNode(3); 
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(15);
        l1.next.next.next = new ListNode(30); 
  
        // creating second linked list 
        ListNode l2 = new ListNode(10); 
        l2.next  = new ListNode(15); 
        l2.next.next = new ListNode(30); 
        ListNode node = getIntersectionNode(l1, l2);
        print(node);
	}
	
	public static void print(ListNode node) {
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int len1 = 0;
	        int len2 = 0;
	        ListNode p1=headA, p2=headB;
	        if (p1 == null || p2 == null)
	            return null;
	 
	        while(p1 != null){
	            len1++;
	            p1 = p1.next;
	        }
	        while(p2 !=null){
	            len2++;
	            p2 = p2.next;
	        }
	 
	        int diff = 0;
	        p1=headA;
	        p2=headB;
	 
	        if(len1 > len2){
	            diff = len1-len2;
	            int i=0;
	            while(i<diff){
	                p1 = p1.next;
	                i++;
	            }
	        }else{
	            diff = len2-len1;
	            int i=0;
	            while(i<diff){
	                p2 = p2.next;
	                i++;
	            }
	        }
	 
	        while(p1 != null && p2 != null){
	            if(p1.val == p2.val){
	                return p1;
	            }else{
	 
	            }
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	 
	        return null;
	    }

}

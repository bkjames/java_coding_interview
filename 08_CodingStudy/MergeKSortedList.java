package zTest;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}
public class MergeKSortedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next  = new ListNode(4);
		n1.next.next = new ListNode(5);
		
		ListNode n2 = new ListNode(1);
		n2.next = new ListNode(3);
		n2.next.next = new ListNode(4);
		
		ListNode n3 = new ListNode(2);
		n3.next = new ListNode(6);
		
		ListNode[] list = new ListNode[3];
		list[0] = n1;
		list[1] = n2;
		list[2] = n3;
		
		ListNode result = mergeKLists(list);
		System.out.println("===================");
		print(result);
	}
	
	public static void print(ListNode listNode) {
		while(listNode !=null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists ==null || lists.length==0) return null;
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
			
		});
		ListNode head = new ListNode(0);
		ListNode p = head;
		for(ListNode list:lists) {
			if(list !=null)
				queue.offer(list);
		}
		
		while(!queue.isEmpty()) {
			ListNode n = queue.poll();
			
			System.out.println(n.val);
			
			
			p.next = n;
			System.out.println("====p first===");
			printNode(p);
			
			System.out.println("====p.next===");
			printNode(p.next);
			
			p=p.next;
			
			System.out.println("====p===");
			printNode(p);
			
			if(n.next !=null) queue.offer(n.next);
		}
		return head.next;
		
	}
	
	public static void printNode(ListNode head) {
		System.out.print("printNode : ");
		while (head != null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	//2
	 public ListNode mergeKLists_recursive(ListNode[] lists) {
	        // corner case
	        if(lists == null || lists.length == 0) return null;
	        
	        ListNode head = merge(lists, 0, lists.length - 1);
	        return head;
	    }


	    public ListNode merge(ListNode[] lists, int left, int right){
	        // base case
	        if(left == right) return lists[left];
	        
	        int mid = left + (right - left)/2;
	        ListNode l1 = merge(lists, left, mid); 
	        ListNode l2 = merge(lists, mid + 1, right); 
	        
	        return mergeTwoLists(l1, l2);
	    }
	    
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
	        ListNode dummy = new ListNode(-1);
	        ListNode cur = dummy;
	        
	        ListNode cur1 = l1;
	        ListNode cur2 = l2;
	        while(cur1 != null || cur2 != null){
	            if(cur1 == null){
	                cur.next = cur2;
	                break;
	            }else if(cur2 == null){
	                cur.next = cur1;
	                break;
	            }else{
	                if(cur1.val <= cur2.val){
	                    cur.next = cur1;
	                    cur1 = cur1.next;
	                }else{
	                    cur.next = cur2;
	                    cur2 = cur2.next;
	                }
	                cur = cur.next;
	            }
	            
	        }
	     
	        return dummy.next;
	    }
	
	
}

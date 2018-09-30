package aExe03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode{
	
	int val ; 
	ListNode next; 
	public ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}

public class MergeKsortedList {
	
	   public ListNode mergeKLists(ListNode[] lists) {
	        if (lists==null||lists.length==0) return null;
	        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
	        

				@Override
				public int compare(ListNode o1, ListNode o2) {
	
						if(o1.val <o2.val)
							return -1;
						else if(o1.val == o2.val)
							return 0;
						else
							return 1;
					}
	        });
	        
	        ListNode dummy = new ListNode(0);
	        ListNode tail=dummy;
	        
	        for (ListNode node:lists)
	            if (node!=null)
	                queue.add(node);
	            
	        while (!queue.isEmpty()){
	            tail.next=queue.poll();
	            tail=tail.next;
	            
	            if (tail.next!=null)
	                queue.add(tail.next);
	        }
	        return dummy.next;
	    }

		/**
		 * @param args
		 */
		public static void main(String[] args) {

			ListNode first = new ListNode(1);
			first.next = new ListNode(4);
			first.next.next = new ListNode(5);

			ListNode seccond = new ListNode(1);
			seccond.next = new ListNode(3);
			seccond.next.next = new ListNode(4);

//			List<ListNode> lists = new ArrayList<ListNode>();
//			lists.add(first);
//			lists.add(seccond);
			ListNode[] listArray = new ListNode[2];
			listArray[0] = first;
			listArray[1]=seccond;
			

			MergeKsortedList sortedList = new MergeKsortedList();
			ListNode head = sortedList.mergeKLists(listArray);
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}

		}
		private static class ListNode {
			int val;
			ListNode next;
			ListNode(int x) {
				val = x;
				next = null;
			}
		}
	}

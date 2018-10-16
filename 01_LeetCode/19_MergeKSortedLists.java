package aExe02;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;




//class ListNode{
//	
//	int val ; 
//	ListNode next; 
//	public ListNode(int x) {
//		this.val = x;
//		this.next = null;
//	}
//}


public class MergeKSortedList {
	
	public static ListNode mergeKLists(ListNode[] lists) {
	    if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
	    	public int compare(ListNode l1, ListNode l2) {
	    		return l1.val-l2.val;
	    	}
	    });
	 
	    ListNode head = new ListNode(0);
	    ListNode p = head;
	 
	    for(ListNode list: lists){
	        if(list!=null)
	            queue.offer(list);
	    }    
	 
	    while(!queue.isEmpty()){
	        ListNode n = queue.poll();
	        System.out.println(n.val);
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }    
	 
	    return head.next;
	 
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }

        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
	   //Drive code
 public static void main(String args[])
 {
 	
 	ListNode node1 = new ListNode(1);
 	node1.next = new ListNode(4);
 	node1.next.next  = new ListNode(5);
 	
 	ListNode node2 = new ListNode(1);
 	node2.next = new ListNode(3);
 	node2.next.next = new ListNode(4);
 	
 	ListNode node3 = new ListNode(2);
 	node3.next = new ListNode(6);
 	
 	
 	ListNode[] list = new ListNode[3];
 	list[0] =node1;
 	list[1] = node2;
 	list[2] = node3;
 	
 	ListNode  result =mergeKLists(list);
 	print(result);
 	
 }
 public static void print(ListNode listNode) {
 	while(listNode != null) {
 		System.out.println(listNode.val);
 		listNode = listNode.next;
 	}
 }

}

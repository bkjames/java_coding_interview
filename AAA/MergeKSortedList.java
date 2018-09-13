package aaa;

import java.util.ArrayList;
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


public class MergeKSortedList {
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if ((lists == null) || (lists.size() == 0)) {
			return null;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (ListNode list : lists) {
			while (list != null) {
				pq.offer(list.val);
				list = list.next;
			}
		}
		int size = pq.size();
		if (size == 0) {
			return null;
		}
		ListNode start = new ListNode(pq.poll());
		ListNode head = start;
		size = pq.size();
		for (int i = 0; i < size; i++) {
			start.next = new ListNode(pq.poll());
			start = start.next;
		}

		return head;

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

		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(first);
		lists.add(seccond);

		MergeKSortedList sortedList = new MergeKSortedList();
		ListNode head = sortedList.mergeKLists(lists);
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

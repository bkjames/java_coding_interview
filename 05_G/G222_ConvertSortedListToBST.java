package zGoo1;


class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		this.val = x;
	}
}

class Tree{
	int val;
	Tree left, right;
	Tree(int x){
		this.val = x;
	}
}
public class G222_ConvertSortedListToBST {

	private ListNode node;
	
	public static void main(String[] args) {
//		[-10,-3,0,5,9]
		ListNode listNode = new ListNode(-10);
		listNode.next = new ListNode(-3);
		listNode.next.next = new ListNode(0);
		listNode.next.next.next = new ListNode(5);
		listNode.next.next.next.next = new ListNode(9);
		G222_ConvertSortedListToBST a = new G222_ConvertSortedListToBST();
		TreeNode tree = a.sortedListToBST2(listNode);
		a.print(tree);
	}
	
	 public TreeNode sortedListToBST2(ListNode head) {
			if(head==null) return null;
			if(head.next==null) return new TreeNode(head.val);
			ListNode slow=head, fast=head,prev=null;
			while(fast!=null && fast.next!=null){
				prev=slow;
				slow=slow.next;
				fast=fast.next.next;
			}
			prev.next=null;
			TreeNode root = new TreeNode(slow.val);
			root.left=sortedListToBST(head);
			root.right=sortedListToBST(slow.next);
			return root;
	    } 
	 
	void print(TreeNode tree) {
		if(tree == null) return;
		System.out.println(tree.val);
		if(tree.left != null)
			print(tree.left);
		if(tree.right != null)
			print(tree.right);
		
	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		
		int size = 0;
		ListNode runner = head;
		node = head;
		
		while(runner != null){
			runner = runner.next;
			size ++;
		}
		
		return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end){
		if(start > end){
			return null;
		}
		
		int mid = start + (end - start) / 2;
		TreeNode left = inorderHelper(start, mid - 1);
		
		TreeNode treenode = new TreeNode(node.val);
		treenode.left = left;
		node = node.next;

		TreeNode right = inorderHelper(mid + 1, end);
		treenode.right = right;
		
		return treenode;
	}
}

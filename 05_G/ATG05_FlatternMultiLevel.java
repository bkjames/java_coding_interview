package zGTop;

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node() {
	}

	public Node(int _val, Node _prev, Node _next, Node _child) {
		val = _val;
		prev = _prev;
		next = _next;
		child = _child;
	}
};

public class FlatternMultiLevel {

	public static void main(String[] args) {

		Node node = new Node(1, null, null, null);
		node.next = new Node(2, node, null, null);
		node.next.next = new Node(3, node.next, null, null);
		node.next.next.child = new Node(7, null, null, null);
		node.next.next.child.next = new Node(8, node.next.next.child, null, null);
		node.next.next.child.next.child = new Node(11, node.next.next.child.next, null, null);
		node.next.next.child.next.child.next = new Node(12, node.next.next.child.next.child, null, null);
		node.next.next.child.next.next = new Node(9, node.next.next.child.next, null, null);
		node.next.next.child.next.next.next = new Node(10, node.next.next.child.next.next, null, null);
		node.next.next.next = new Node(4, node.next.next, null, null);
		node.next.next.next.next = new Node(5, node.next.next.next, null, null);
		node.next.next.next.next.next = new Node(6, node.next.next.next.next, null, null);
		Node resultNode = flatten(node);
		while (resultNode != null) {
			System.out.print(resultNode.val + "  ");
			resultNode = resultNode.next;
		}

	}

	public static Node flatten(Node head) {
		if (head == null)
			return head;
		// Pointer
		Node p = head;
		while (p != null) {
			/* CASE 1: if no child, proceed */
			if (p.child == null) {
				p = p.next;
				continue;
			}
			/* CASE 2: got child, find the tail of the child and link it to p.next */
			Node temp = p.child;
			// Find the tail of the child
			while (temp.next != null)
				temp = temp.next;
			// Connect tail with p.next, if it is not null
			temp.next = p.next;
			if (p.next != null)
				p.next.prev = temp;
			// Connect p with p.child, and remove p.child
			p.next = p.child;
			p.child.prev = p;
			p.child = null;
		}
		return head;
	}

}

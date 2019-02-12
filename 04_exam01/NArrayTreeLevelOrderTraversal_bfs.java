package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}


public class NArrayTreeLevelOrderTraversal {

	public static void main(String[] args) {
		List<Node> ch5 = new ArrayList<Node>();
		Node node5 = new Node(5, ch5);
		List<Node> ch6 = new ArrayList<Node>();
		Node node6 = new Node(6,ch6);
		List<Node> ch3 = new ArrayList<Node>();
		ch3.add(node5);
		ch3.add(node6);
		
		Node node3 = new Node(3, ch3);
		List<Node> ch2 = new ArrayList<Node>();
		Node node2 = new Node(2, ch2);
		List<Node> ch4 = new ArrayList<Node>();
		Node node4 = new Node(4, ch4);
		
		List<Node> ch1 = new ArrayList<Node>();
		ch1.add(node3);
		ch1.add(node2);
		ch1.add(node4);
		
		Node node1 = new Node(1, ch1);
		System.out.println(levelOrder(node1));
	}
	public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        
        if (root == null) return ret;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }
        
        return ret;
    }
}

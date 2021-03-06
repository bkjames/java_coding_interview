package ama03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val =x;
	}
}

public class A137_AllNodesDistKInBinaryTree {

	//Method 1: use HashMap
	//1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
	//2. do BFS with source vertice (target) to find all vertices with distance K to it.

	    Map<TreeNode, List<TreeNode>> map = new HashMap();
	//here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, since parent-child mapping is inherent in the tree structure
	    
	    
	    public static void main(String[] args) {
			
//	    	Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
	    			
	    	TreeNode node = new TreeNode(3);
	    	node.left =new TreeNode(5);
	    	node.right=new TreeNode(1);
	    	node.left.left = new TreeNode(6);
	    	node.left.right = new TreeNode(2);
	    	node.right.left = new TreeNode(0);
	    	node.right.right = new TreeNode(8);
	    	node.left.right.left= new TreeNode(7);
	    	node.left.right.right = new TreeNode(4);
	    	A137_AllNodesDistKInBinaryTree a = new A137_AllNodesDistKInBinaryTree();
	    	System.out.println(a.distanceK(node, node.left, 2));
	    	
		}
	    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	         List<Integer> res = new ArrayList<Integer> ();
	        if (root == null || K < 0) return res;
	        buildMap(root, null); 
	        if (!map.containsKey(target)) return res;
	        Set<TreeNode> visited = new HashSet<TreeNode>();
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(target);
	        visited.add(target);
	        while (!q.isEmpty()) {
	            int size = q.size();
	            if (K == 0) {
	                for (int i = 0; i < size ; i++) res.add(q.poll().val);
	                return res;
	            }
	            for (int i = 0; i < size; i++) {
	                TreeNode node = q.poll();
	                for (TreeNode next : map.get(node)) {
	                    if (visited.contains(next)) continue;
	                    visited.add(next);
	                    q.add(next);
	                }
	            }
	            K--;
	        }
	        return res;
	    }
	    
	    private void buildMap(TreeNode node, TreeNode parent) {
	        if (node == null) return;
	        if (!map.containsKey(node)) {
	            map.put(node, new ArrayList<TreeNode>());
	            if (parent != null)  { 
	            	map.get(node).add(parent); 
	            	map.get(parent).add(node);
	            }
	            buildMap(node.left, node);
	            buildMap(node.right, node);
	        }
	    }    
	}


	//Method 2: No HashMap
	//kind of like clone the tree, in the meanwhile add a parent link to the node
//	class Solution {
//	    private GNode targetGNode;
//	    
//	    private class GNode {
//	        TreeNode node;
//	        GNode parent, left, right;
//	        GNode (TreeNode node) {
//	            this.node = node;
//	        }
//	    }           
//	    
//	    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//	        List<Integer> res = new ArrayList<Integer> ();
//	        if (root == null || K < 0) return res;
//	        cloneGraph(root, null, target);
//	        if (targetGNode == null) return res;
//	        Set<GNode> visited = new HashSet<GNode>();
//	        Queue<GNode> q = new LinkedList<GNode>();
//	        q.add(targetGNode);
//	        visited.add(targetGNode);
//	        while (!q.isEmpty()) {
//	            int size = q.size();
//	            if (K == 0) {
//	                for (int i = 0; i < size ; i++) res.add(q.poll().node.val);
//	                return res;
//	            }
//	            for (int i = 0; i < size; i++) {
//	                GNode gNode = q.poll();
//	                if (gNode.left != null && !visited.contains(gNode.left)) { visited.add(gNode.left); q.add(gNode.left); }
//	                if (gNode.right != null && !visited.contains(gNode.right)) { visited.add(gNode.right); q.add(gNode.right); }
//	                if (gNode.parent != null && !visited.contains(gNode.parent)) { visited.add(gNode.parent); q.add(gNode.parent); }
//	            }
//	            K--;
//	        }
//	        return res;
//	    }
//	    
//	    private GNode cloneGraph(TreeNode node, GNode parent, TreeNode target) {
//	        if (node == null) return null;
//	        GNode gNode = new GNode(node);
//	        if (node == target) targetGNode = gNode;
//	        gNode.parent = parent;
//	        gNode.left = cloneGraph(node.left, gNode, target);
//	        gNode.right = cloneGraph(node.right, gNode, target);
//	        return gNode;
//	    }
//	}

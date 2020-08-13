package a_20200813;

import java.util.*;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val =x;
	}
}



public class A076_TwoSum4 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		A076_TwoSum4 a = new A076_TwoSum4();
		int k = 9;
		System.out.println(a.findTarget_1(root, k));
		System.out.println(a.findTarget(root, k));
		
	}
	
	
	 public boolean findTarget_1(TreeNode root, int k) {
	        HashSet<Integer> set = new HashSet<>();
	        return dfs(root, set, k);
	    }
	    
	    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
	        if(root == null)return false;
	        if(set.contains(k - root.val))return true;
	        set.add(root.val);
	        return dfs(root.left, set, k) || dfs(root.right, set, k);
	    }
	    
	
//	Time complexity : O(n) We need to traverse over the whole tree once to do the inorder traversal. Here, nn refers to the number of nodes in the given tree.
//	Space complexity : O(n) The sorted listlist will contain nn elements.

    public boolean findTarget22(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int left=0, right = list.size()-1;
        while(left < right){
            int sum = list.get(left) +list.get(right);
            if(sum == k)
                return true;
            if(sum < k)
                left++;
            else 
                right--;
        }
        return false;
    }
    public void inOrder(TreeNode root, List<Integer> list){
        if(root ==null) 
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new ArrayList();
		inorder(root, list);
		int l = 0, r = list.size() - 1;
		while (l < r) {
			int sum = list.get(l) + list.get(r);
			if (sum == k)
				return true;
			if (sum < k)
				l++;
			else
				r--;
		}
		return false;
	}

	public void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
	
//	ime complexity : O(n)O(n). We need to traverse over the whole tree once in the worst case. Here, nn refers to the number of nodes in the given tree.
//
//	Space complexity : O(n)O(n). The size of the setset can grow atmost upto nn.

	public boolean findTarget2(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
//	Time complexity : O(n)O(n). The entire tree is traversed only once in the worst case. Here, nn refers to the number of nodes in the given tree.
//	Space complexity : O(n)O(n). The size of the setset can grow upto nn in the worst case.


	 public boolean findTarget3(TreeNode root, int k) {
	        Set < Integer > set = new HashSet();
	        return find(root, k, set);
	    }
	    public boolean find(TreeNode root, int k, Set < Integer > set) {
	        if (root == null)
	            return false;
	        if (set.contains(k - root.val))
	            return true;
	        set.add(root.val);
	        return find(root.left, k, set) || find(root.right, k, set);
	    }
}

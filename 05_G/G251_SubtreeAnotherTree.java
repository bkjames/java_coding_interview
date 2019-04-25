package p3;

class TreeNode{
	int val; 
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
public class G251_SubtreeAnotherTree {

	public static void main(String[] args) {
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.left.right = new TreeNode(2);
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		G251_SubtreeAnotherTree a = new G251_SubtreeAnotherTree();
		System.out.println(a.isSubtree(s, t));
	}
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        if (s == null) return false;
	        if (isSame(s, t)) return true;
	        return isSubtree(s.left, t) || isSubtree(s.right, t);
	    }
	    
	    private boolean isSame(TreeNode s, TreeNode t) {
	        if (s == null && t == null) return true;
	        if (s == null || t == null) return false;
	     	System.out.println("======s.val: "+s.val+" t.val: "+t.val);
	        if (s.val != t.val) {
	        	System.out.println("s.val: "+s.val+" t.val: "+t.val);
	        	return false;
	        }
	        
	        return isSame(s.left, t.left) && isSame(s.right, t.right);
	    }
}

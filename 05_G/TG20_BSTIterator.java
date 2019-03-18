package Problems;
import java.util.*;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val =x;
	}
}
public class TG20_BSTIterator {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(3);
		node.right = new TreeNode(15);
		node.right.left = new TreeNode(9);
		node.right.right = new TreeNode(20);
		
		TG20_BSTIterator a = new TG20_BSTIterator(node);
		
		System.out.println(a.next());
		System.out.println(a.next());
		System.out.println(a.hasNext());
		System.out.println(a.next());
		System.out.println(a.hasNext());
		System.out.println(a.next());
		System.out.println(a.hasNext());
		System.out.println(a.next());
		System.out.println(a.hasNext());

		
	}
	Stack<TreeNode> stack =  null ;            
    TreeNode current = null ;
	
    public TG20_BSTIterator(TreeNode root) {
    	  current = root;	     
    	  stack = new Stack<> ();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {		  
	      return !stack.isEmpty() || current != null;  
	}

	    /** @return the next smallest number */
	public int next() {
		while (current != null) {
			stack.push(current);
			current = current.left ;
		}		
		TreeNode t = stack.pop() ;		
		current = t.right ;		
		return t.val ;
	}
	

}

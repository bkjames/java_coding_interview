package Basic;



class Tree{
	int val;
	Tree left, right;
	Tree(int x){
		this.val = x;
	}
}

public class BinaryTree {

	
	public static void main(String[] args) {
		
		Tree tree = new Tree(1);
		tree.left = new Tree(2);
		tree.right = new Tree(3);
		tree.left.left = new Tree(4);
		tree.left.right = new Tree(5);
		
		BinaryTree a = new BinaryTree();
		a.preOrder(tree);
		System.out.println();
		a.inOrder(tree);
		System.out.println();
		a.postOrder(tree);
	}
	
	// 1. preOrder Root-Left-Right
	void preOrder(Tree tree) {
		if(tree == null) return ;
		System.out.print(tree.val+" ");
		
		preOrder(tree.left);
		preOrder(tree.right);
	}
	
	//2. InOrder Left-Root-Right
	void inOrder(Tree tree) {
		if(tree == null )return;
		
		inOrder(tree.left);
		System.out.print(tree.val+" ");
		inOrder(tree.right);
	}
	
	//3. post left-right-Root
	void postOrder(Tree tree) {
		if(tree == null) return ;
		
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.print(tree.val+" ");
		
	}

	
	
	

}

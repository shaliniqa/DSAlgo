
public class BinaryTree {
	private class Node
	{
		int key;
		Node right;
		Node left;
		
		public Node(int key)
		{
			this.key=key;
			right=null;
			left=null;
		}
	}
	private Node root;
	private int size;
	public Node Insert(Node root, int data)
	{
			if(data==-1){
				return null;
			}
				Node newNode=new Node(data);
				root=newNode;
			root.left=Insert(root.left,data);
			root.right=Insert(root.right,data);
		return root;
	}
	
	public void display(Node root)
	{
		if(root==null)
			return;
		
		System.out.println(root.key);
		if(root.left!=null)
		{
			display(root.left);
		}
		if(root.right!=null)
		{
			display(root.right);
		}
	}
	
	public static void main(String args[])
	{
		BinaryTree tree=new BinaryTree();
		tree.Insert(tree.root,5);
		tree.Insert(tree.root,-1);
		tree.Insert(tree.root,-1);
	}

}

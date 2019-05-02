import java.util.Scanner;


public class Tree {
	private class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key)
		{
			this.key=key;
			left=null;
			right=null;
		}
	}
	private int size;
	private Node root;
	
	public Tree()
	{
		size=0;
		Scanner sc=new Scanner(System.in);
		root=takeInput(sc, null, false);
	}
	
	public Node takeInput(Scanner sc, Node parent, boolean isLeftRight)
	{
		if(parent==null)
		{
			System.out.println("Enter the root");
		}
		else{
			if(isLeftRight)
			{
				System.out.println("Enter the left child of "+parent.key);
			}
			else
			{
				System.out.println("Enter the right child of "+parent.key);
			}
		}
		int key=sc.nextInt();
		Node newNode= new Node(key);
		this.size++;
		
		System.out.println("is there left child of "+key);
		boolean choice=sc.nextBoolean();
		
		if(choice)
		{
			newNode.left=takeInput(sc,newNode,true);
		}
		choice=false;
		System.out.println("is there right child of "+key);
		choice=sc.nextBoolean();
		
		if(choice)
		{
			newNode.right=takeInput(sc,newNode,false);
		}
		return newNode;
	}
	
	public void display()
	{
		this.display(this.root);
	}
	private void display(Node root)
	{
		String str="";
		if(root.left!=null)
		{
			str=str+root.left.key+" => ";
		}
		else
		{
			str=str+"END => ";
		}
		str=str+root.key;
		if(root.right!=null)
		{
			str=str+" <="+root.right.key;
		}
		else
		{
			str=str+" <= END";
		}
		System.out.println(str);
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
		Tree tree=new Tree();
		tree.display();
	}
}

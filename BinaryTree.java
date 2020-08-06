package dataStructure;

import java.util.*;

public class BinaryTree {
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root;
	private int size;
	
	public BinaryTree() {
		Scanner s = new Scanner(System.in);
		this.root = this.takeInput(s, null, false);
	}
	
	private Node takeInput(Scanner s, Node parent, boolean isLeftorRight) {
		if(parent == null) {
			System.out.println("Enter the data for the root node");
		}else {
			if(isLeftorRight) {
				System.out.println("Enter the data for left child of "+parent.data);
			}else {
				System.out.println("Enter the data for right child of "+parent.data);
			}
		}
		
		int data = s.nextInt();
		Node node = new Node(data, null, null);
		this.size++;
		
		boolean choice = false;
		System.out.println("Do you have left child for "+node.data);
		choice = s.nextBoolean();
		if(choice) {
			node.left = this.takeInput(s, node, true);
		}
		
		choice = false;
		System.out.println("Do you have right child for "+node.data);
		choice = s.nextBoolean();
		if(choice) {
			node.right = this.takeInput(s, node, false);
		}
		return node;
	}
	
	
	public void display() {
		this.display(this.root);
	}
	
	
	private void display(Node node) {
		if(node.left != null) {
			System.out.print(node.left.data+"=>");
		}else {
			System.out.print("END=>");
		}
		System.out.print(node.data);
		if(node.right != null) {
			System.out.print("<="+node.right.data);
		}else {
			System.out.print("<=END");
		}
		System.out.println();
		
		if(node.left != null) {
			this.display(node.left);
		}
		if(node.right != null) {
			this.display(node.right);
		}
	}
	
	public void OrderRec() {
		System.out.println("\n\nPreOrder Recursive");
		this.preOrderRec(this.root);
		System.out.println("\n\nInOrder Recursive");
		this.inOrderRec(this.root);
		System.out.println("\n\nPostOrder Recursive");
		this.postOrderRec(this.root);
	}
	
	private void preOrderRec(Node node) {
		if(node == null) return;
		System.out.print(node.data + " ");
		preOrderRec(node.left);
		preOrderRec(node.right);
	}
	
	private void inOrderRec(Node node) {
		if(node == null) return;
		inOrderRec(node.left);
		System.out.print(node.data + " ");
		inOrderRec(node.right);
	}
	
	private void postOrderRec(Node node) {
		if(node == null) return;
		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.print(node.data + " ");
	}
	
	
	public void OrderIter() {
		System.out.println("\n\nPreOrder Iterative");
		this.preOrderIter(this.root);
		System.out.println("\n\nInOrder Iterative");
		this.inOrderIter(this.root);
		System.out.println("\n\nPostOrder Iterative");
		this.postOrderIter(this.root);
	}
	

	class Pair{
		Node node;
		public boolean selfdone;
		public boolean leftdone;
		public boolean rightdone;
	
		Pair(Node node) {
			this.node = node;
			this.leftdone = leftdone;
			this.rightdone = rightdone;
			this.selfdone = selfdone;
		}
		
	}
	
	private void preOrderIter(Node node) {
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(node));
		while(!st.isEmpty()) {
			Pair pair = st.peek();
			if(pair.selfdone == false) {
				pair.selfdone = true;
				System.out.print(pair.node.data + " ");
			} else if(pair.leftdone == false) {
				if(pair.node.left != null) {
					st.push(new Pair(pair.node.left));
				}
				pair.leftdone = true;
			}else if(pair.rightdone == false) {
				if(pair.node.right != null) {
					st.push(new Pair(pair.node.right));
					}
				pair.rightdone = true;
				}else {
					st.pop();
					}
				}
	}
	
	
	private void inOrderIter(Node node) {
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(node));
		while(!st.isEmpty()) {
			Pair pair = st.peek();
			if(pair.leftdone == false) {
				if(pair.node.left != null) {
					st.push(new Pair(pair.node.left));
				}
				pair.leftdone = true;
				
			} else if(pair.selfdone == false) {
				pair.selfdone = true;
				System.out.print(pair.node.data + " ");
				
			} else if(pair.rightdone == false) {
				if(pair.node.right != null) {
					st.push(new Pair(pair.node.right));
					}
				pair.rightdone = true;
				}else {
					st.pop();
					}
				}
		}
	
	private void postOrderIter(Node node) {
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(node));
		while(!st.isEmpty()) {
			Pair pair = st.peek();
			if(pair.leftdone == false) {
				if(pair.node.left != null) {
					st.push(new Pair(pair.node.left));
				}
				pair.leftdone = true;
				
			} else if(pair.rightdone == false) {
				if(pair.node.right != null) {
					st.push(new Pair(pair.node.right));
					}
				pair.rightdone = true;
				}
				else if(pair.selfdone == false) {
					pair.selfdone = true;
					System.out.print(pair.node.data + " ");	
				} 
			else {
					st.pop();
					}
				}
		
	}
	
	class DiaPair{
		int height;
		int diameter;
		public DiaPair() {
			
		}
	}
	
	public int Diameter() {
		return this.Diameter(this.root);
	}
	
	private int Diameter(Node node) {
		if(node == null) {
			return 0;
		}
		
		int mydiameter = this.height(node.left) + this.height(node.right) + 2;
		int ldiameter = this.Diameter(node.left);
		int rdiameter = this.Diameter(node.right);
		
		int myans = Math.max(ldiameter, Math.max(rdiameter, mydiameter));
		return myans;
		
	}



public static void main(String[] args) {
	BinaryTree tree = new BinaryTree();
	tree.display();
	tree.OrderRec();
	tree.OrderIter();
	tree.Diameter();
	}
}



//50
//true
//25
//true
//12
//false
//false
//true
//54
//false
//false
//true
//75
//true
//62
//false
//false
//true
//87
//false
//false
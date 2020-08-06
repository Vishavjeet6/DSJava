package dataStructure;

import java.util.Scanner;

public class BST {
	
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
	
	
	
	
	public void add(int data) {
		if(this.root == null) {
			this.root = new Node(data, null, null);
			this.size++;
		}else {
			this.add(this.root, data);
		}
	}
	
	private void add(Node node, int data) {
		if(data < node.data) {
			if(node.left != null) {
				this.add(node.left, data);
			}else {
				node.left = new Node(data, null, null);
				this.size++;
			}	
		} else if(data > node.data) {
			if(node.right != null) {
				this.add(node.right, data);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			} 
		}
	}
	
	public void max() {
		this.max(this.root);
	}
	
	private void max(Node node) {
		if(node == null) {
			return;
		}
		this.max(node.right);
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
		}
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
	
	public boolean isBST() {
		return this.isBST(this.root,Integer.MIN_VALUE, Integer.MAX_VALUE );
	}
	
	private boolean isBST(Node node, int min, int max) {
		if(node == null) {
			return true;
		}
		if(node.data < min || node.data > max) {
			return false;
		} else if(!this.isBST(node.left,min, node.data)) {
			return false;
		} else if(!this.isBST(node.right, node.data, max)) {
			return false;
		}else {
			return true;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BST tree = new BST();
		while(sc.hasNextInt()) {
			tree.add(sc.nextInt());
		}
		tree.display();
		System.out.println(tree.isBST());
		tree.max();
		sc.close();
		
	}
}

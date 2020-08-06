package dataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	
	class Node{
		char data;
		boolean isTerminal;
		HashMap<Character, Node> children;
		
		Node(char data, boolean isTerminal){
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap();
			
		}
	}


	private int numwords;
	private Node root;
	
	Trie(){
		this.root = new Node('\0',false);
	}
	
	
	
	public void addWord(String word) {
		this.addWord(this.root,word);
	}
	
	private void addWord(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal) {
				return;
			} else {
				parent.isTerminal = true;
				this.numwords++;
			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(cc);
		
		if(child == null) {
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		
		this.addWord(child, ros);
	}
	
	
	public void display() {
		this.display(this.root, "");
	}
	
	private void display(Node node, String res) {
		if(node.isTerminal) {
			System.out.println(res);
		}
		
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for(Map.Entry<Character, Node> entry: entries) {
			this.display(entry.getValue(), res+entry.getKey());
		}
		
	}
	
	public void isPresent(String word) {
		if(this.isPresent(this.root, word)) {
			System.out.println("Yes");
		} else System.out.println("No");
	}
	
	private boolean isPresent(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal) return true;
			else return false;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		
		Node child = parent.children.get(cc);
		
		if(child == null) {
			return false;
		}
		return this.isPresent(child, ros);
	}
	
	public void remove(String word) {
		this.remove(this.root, word);
	}
	
	private void remove(Node node, String word) {
		if(word.length() == 0) {
			if(node.isTerminal) {
				node.isTerminal = false;
				this.numwords--;
			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(cc);
		if(child==null) {
			System.out.println("Word doesn't exist");
		}
		this.remove(child,ros);
		if(!child.isTerminal && child.children.size() == 0) {
// check below line
//			
			node.children.remove(cc);
			
		}
	}
	
	public void displayAsTree() {
		this.displayAsTree(this.root);
	}
	
	private void displayAsTree(Node node) {
		String str = "";
		str = str + node.data + "=>";
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		
		for(Map.Entry<Character, Node> entry: entries) {
			str = str+entry.getKey() + ", ";
		}
		
		str = str+"END";
		
//code missing
//		
		
	}
	
	
	
	public static void main(String[] args) {
		Trie obj = new Trie();
		obj.addWord("vishav");
		obj.addWord("vishavjeet");
		obj.display();
		obj.isPresent("vis");
//		obj.remove("vishav");
//		obj.isPresent("vishav");
		obj.displayAsTree();
	}
}

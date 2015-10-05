package vicky8rk;
import java.util.ArrayList;
import java.util.HashMap;

class TreeNode implements Comparable{
	int data;
	TreeNode lChild=null,rChild=null;
	TreeNode(int data){
		this.data = data;
	}
	TreeNode(int data, TreeNode l, TreeNode r){
		this.data = data;
		this.lChild = l;
		this.rChild = r;
	}
	
	@Override
	public int compareTo(Object o){
		try{
		if(o instanceof TreeNode){
			TreeNode other = (TreeNode)o;
			if(this.data < other.data)
				return -1;
			else if(this.data == other.data)
				return 0;
			else return 1;
		}
		else
			throw new Exception("Passed argument is not of Type TreeNode");
		}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		return 0;
	}
	boolean has_no_l_child(){
		return this.lChild==null?true:false;
	}
	boolean has_no_r_child(){
		return this.rChild==null?true:false;
	}
	boolean has_no_child(){
		return has_no_l_child() && has_no_r_child();
	}
	void set_l_child(TreeNode neww){
		this.lChild = neww;
	}
	void set_r_child(TreeNode neww){
		this.rChild = neww;
	}
	
}

/*class BinarySearchTree{
	TreeNode root;
	
}*/

public class BinarySearchTree {
	TreeNode root;
	ArrayList list;
	HashMap map;
	BinarySearchTree(int val){
		root = new TreeNode(val);
	}
	void add(int val){
		TreeNode current = root;
		tryToAddNewValueToSubTree(current, new TreeNode(val));
	}
	void tryToAddNewValueToSubTree(TreeNode current, TreeNode incoming){
		if(incoming.compareTo(current)<=0)
			if(current.has_no_l_child()){
				current.set_l_child(incoming);
			}
			else
				tryToAddNewValueToSubTree(current.lChild, incoming);
		else 
			if(current.has_no_r_child()){
				current.set_r_child(incoming);
			}
			else
				tryToAddNewValueToSubTree(current.rChild, incoming);
	}
	
	String print_dfs(){
		return null;
	}
	
	void traverse_dfs(TreeNode current){
		if(current.has_no_l_child()==false)
			traverse(current.lChild);
		list.add(current.data);
		if(current.has_no_r_child()==false)
			traverse(current.rChild);
	}
	
	String print_bfs(){
		return null;
	}
	boolean search(int value){
		return searchStub(root, new TreeNode(value));
	}
	boolean searchStub(TreeNode curr, TreeNode val){
		if(curr.compareTo(val)==0)
			return true;
		else if(curr.compareTo(val)<0)
			return searchStub(curr.lChild, val);
		else
			return searchStub(curr.rChild, val);
	}
	@Override
	public String toString(){
		TreeNode current = root;
		list = new ArrayList();
		
		traverse(current);
		String ret = list.toString();
		
		list = null;
		return ret;
	}
	void traverse(TreeNode current){
		if(current.has_no_l_child()==false)
			traverse(current.lChild);
		list.add(current.data);
		if(current.has_no_r_child()==false)
			traverse(current.rChild);
	}
	public static void main(String... args){
		BinarySearchTree bst = new BinarySearchTree(3);
		bst.add(2);
		bst.add(4);
		bst.add(1);
		bst.add(5);
		System.out.println(bst);
	}
}

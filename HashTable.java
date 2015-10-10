package vicky8rk;

class Node implements Comparable{
	String data;
	Node next;
	Node(String x){
		this.data = x.toUpperCase();
		this.next = null;
	}
	Node(String x, Node next){
		this.data = x.toUpperCase();
		this.next = next;
	}
	public int compareTo(Object O){
		if(O.getClass()!= this.getClass())
			return -1;
		Node newer = (Node)O;
		return data.compareToIgnoreCase(newer.data);
	}
	void addNext(Node x){
		x.next = this.next;
		this.next = x;
		System.out.println("Added Node "+x.data+" after Node "+this.data);
	}
}

class LinkedList{
	Node root=null;
	LinkedList( String initValue){
		root = new Node(initValue);
	}
	LinkedList( ){
	}
	public String toString(){
		if(root == null){
			return "Empty";
		}
		Node current = root;
		String ret = "";
		while(current.next!=null){
			ret = ret + current.data;
			current = current.next;
			if(current!=null)
				ret+=",";
		}
		return ":"+ret+current.data;
	}
	void add(String x){
		Node neww = new Node(x);
		if(root == null){ // empty linked list
			System.out.println("Adding Root "+x);
			root = neww;
			return;
		}
		else{
			Node current = root;
			while(current.next != null)
				current = current.next;
			current.next = neww;
		}
	}
	void addInOrder(String x){
		Node neww = new Node(x);
		if(root == null){ // empty linked list
			System.out.println("Adding Root "+x);
			root = neww;
			return;
		}
		else{
			Node current = root;
			Node prev = root;
			while(current.compareTo(neww)<=0){
				prev = current;
				current = current.next;
				if(current==null)
					break;
			}
			if(current==root){
				neww.next = root;
				root=neww;
			}
			else
				prev.addNext(neww);
		}
	}
	/*void addSorted(String x){ // figure out cases
		if(root == null){ // empty linked list
			System.out.println("Adding Root "+x);
			root = new Node(x);
			return;
		}
		System.out.println("Adding "+x+" to "+this.toString()); // 
		Node neww = new Node(x);
		if(root.next==null){
			if(neww.compareTo(root)<0){
				neww.addNext(root);
				root=neww;
			}
			else
				root.addNext(neww);
			return;
		}
		if(root.compareTo(O))
		Node current = root;
		while(current.next!=null){
			if(neww.compareTo(current.next)<0){
				current.addNext(neww);
				return;
			}
			current = current.next;
			if(current.next==null){
				current.addNext(neww);
				return;
			}
		}
		
	}*/
}

public class HashTable {
	
	LinkedList[] list;
	
	HashTable(int k){
		list = new LinkedList[k];
	}
	
	void map(int k, String str){
		if(list[k]==null)
			list[k]=new LinkedList(str);
		else
			list[k].addInOrder(str);
	}
	
	String get(int k){
		return list[k].toString();
	}
	
	String getFirst(int k){
		return list[k].root.data;
	}
	
	public String toString(){
		String ret="";
		for(int i=0;i<list.length;i++){
			if(list[i]!=null)
				ret = ret+i+":>"+list[i].toString()+"\n";
			else
				ret = ret+i+":> >Null List<\n";
		}
		return ret;
	}
	
	int hash(String x){
		int ret = Math.abs(x.hashCode())%list.length;
		//System.out.println(x+" ka hashcode="+ret);
		return ret;
	}
	
	void add(String x){
		this.map(hash(x), x);
	}
	
	public static void main(String... ars){
//		LinkedList l = new LinkedList("Katara");
//		System.out.println(l);
//		l.addInOrder("Vicky");
//		System.out.println(l);
//		l.addInOrder("Nisha");
//		System.out.println(l);
//		l.addInOrder("A");
//		System.out.println(l);
		HashTable h = new HashTable(4);
		h.add("Vicky");
		h.add("Nisha");
		h.add("Katara");
		h.add("Ankita");
		System.out.println(h);
		//System.out.println(h.list[2]);
	}

}

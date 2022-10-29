import java.util.ArrayList;


/**
 * 
 * @author Gabriel O'donnell
 * This structure is used to hold a piece of data and pointers.
 * The pointers point to the next node ahead of it and the previous node behind it.
 *
 * @param <T> This is a generic type so that data can be of any data-type.
 */
class Node <T>{
	public T data;
	public Node next;
	public Node prev;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

/**
 * 
 * @author Gabriel O'donnell
 * This is an implementation of the Linked List data structure. In this case it has a head node and tail node
 * so that we can access the tail for a more optimized search algorithm. 
 * @param <T>
 */
public class DoublyLinkedList <T>{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	//Constructor
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	//Copy Constructor
	public DoublyLinkedList(DoublyLinkedList<T> list) {
		int copySize = list.getSize();
		
		for(int i = 0; i < copySize; i++) {
			push_back(list.at(i));
		}
	}
		
	/**
	 * Returns the size of the list
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	
	
	/**
	 * returns the data at a given index
	 * @param index - position of a particular index 
	 * @return data at the index position
	 */
	public T at(int index) {
		Node<T> current = head;
		
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		
		return current.data;
	}
	
	
	/**
	 * searchs for a given value you will return an arraylist of all the indexs 
	 * where that value appears.
	 * @param data: the search value
	 * @return An arraylist of indexs where the value is stored.
	 */
	public ArrayList<Integer> searchItem(T data) {
		ArrayList<Integer> result = new ArrayList<Integer>(); // Create an ArrayList to return
		Node<T> current = head;
		
		for(int i=0; i<size; i++) {
			if(current.data.equals(data)){
				result.add(i);
			}
			current = current.next;
		}
		
		return result;
	}
	
	
	/**
	 * inserts a value into the tail/back of the list
	 * @param data: value to be inserted
	 */
	public void push_back(T data) {
		//make the new node to be inserted
		Node<T> newNode = new Node<T>(data);

		//if the list is not empty push it to the back
		if (tail != null) {
			tail.next = newNode; // update old tail next pointer with new nodes position
			newNode.prev = tail;// give the new node the old tails position
			
			tail = newNode;// make the new node the tail
		}
		//list is empty to the first node is head and tail
		else {
			head = newNode;
			tail = newNode;
		}
		
		size++;
	}
	
	/**
	 * inserts a value into the front/head of the list
	 * @param data: value to be inserted
	 */
	public void push_front(T data) {
		//make the new node to be inserted
		Node<T> newNode = new Node<T>(data);
		
		//check if the list is not empty
		if (head != null) {
			//new node is the head
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		
		//list is empty to the first node is head and tail
		else {
			head = newNode;
			tail = newNode;
		}
		
		size++;
	}
	
	/**
	 * Inserts a node after a given node. Private since the user wont
	 * have access to the node stucture.
	 * @param prevNode: the node before you want the new node inserted
	 * @param data: the value to be added to the list.
	 */
	private void insert_After(Node<T> prevNode, T data) {
		//check if node that was given is valid
		if (prevNode == null) {
			System.out.println("Need to give a valid node for previous node.");
			return;
		}
		//make the new node to be inserted
		Node<T> newNode = new Node<T>(data);
		//newNode takes the given nodes next
		newNode.next = prevNode.next;
		newNode.prev = prevNode;
		//Now the given node can point to the new Node
		prevNode.next = newNode;
		
		if (newNode.next != null) {//need to update the node after's information
			newNode.next.prev = newNode;
		}
		
		size++;
		
	}
	
	/**
	 * general insert function that can insert a value with a given index
	 * @param index: where the value is to be inserted
	 * @param data: what value is to be inserted
	 * @return: true/false on if the operation was successful.
	 */
	public boolean insert (int index, T data) {
		//check if we have a valid index
		if (index < 0 || index > size) {
			return false;
		}
		// if its the first just use the push front
		if (index ==0) {
			push_front(data);
			return true;
		}
		//if its last use the push back
		else if (index == size) {
			push_back(data);
		}
		//otherwise we can find the node before and use insert after
		else {
			Node<T> current = head;
			for(int i=0; i<index-1; i++) {
				current = current.next;
			}
			insert_After(current, data);
		}
		return true;
	}
	
	/**
	 * deletes the front/head of the list
	 * @return true/false on if the operation was successful.
	 */
	public boolean pop_front() {
		//check if the list is empty
		if (size == 0 || head == null) {
			return false;
		}
		//check if there is only one node.
		if(head.next == null) {
			// By setting these to null the garbage collector will allow the system
			//to reallocate memory to the system.
			head = null;
			tail = null;
			size = 0;
			return true;
		}
		//hold the old head for deletion
		Node<T> prevHead = head;
		//update new head
		head = head.next;
		head.prev = null;
		
		if(head==tail) {// if there is now only one node
			tail.prev = null;
		}
		
		prevHead = null;
		size--;
		return true;
	}
	/**
	 * deletes the tail/back of the list
	 * @return true/false on if the operation was successful.
	 */
	public boolean pop_back() {
		//check if the list is empty
		if (size == 0 || tail == null) {
			return false;
		}
		//check if there is only one node.
		if(head.next == null) {
			// By setting these to null the garbage collector will allow the system
			//to reallocate memory to the system.
			head = null;
			tail = null;
			size = 0;
			return true;
		}
		//hold the old head for deletion
		Node<T> prevTail = tail;
		//update new head
		tail = tail.prev;
		tail.next = null;
		
		if(head==tail) {// if there is now only one node
			head.next = null;
		}
		
		prevTail = null;
		size--;
		return true;
	}
	/**
	 * deletes the node after a given node, very similar to insert_after
	 * @param prevNode: the node before the one you want deleted
	 * @return true/false on if the operation was successful.
	 */
	private boolean deleteAfter(Node<T> prevNode) {

		//check if the given node is valid
		if (prevNode == null) {
			return false;
		}
		//check if the next node is a valid option
		if(prevNode.next == null) {
			return false;
		}
		
		Node<T> nodeDelete = prevNode.next;
		
		//adjust links
		prevNode.next = nodeDelete.next;
		
		//check if the node after needs to be updated
		if(nodeDelete.next != null) {
			nodeDelete.next.prev = prevNode;
		}
		
		nodeDelete = null;
		size--;
		return true;
		}
	
	/**
	 * deletes a node at a given index
	 * @param index: what index that is to be deleted
	 * @return true/false on if the operation was successful.
	 */
	public boolean deleteNode (int index) {
		T data;
		//check if we have a valid index
		if (index < 0 || index > size) {
			return false;
		}
		// if its the first just use the pop front
		if (index ==0) {
			pop_front();
			return true;
		}
		//if its last use the pop back
		else if (index == size) {
			pop_back();
		}
		//otherwise we can find the node before and use delete after
		else {
			if (index > size/2) {
				Node<T> current = tail;
				for(int i=size-1; i>index-1; i--) {
					current = current.prev;
				}
				
				deleteAfter(current);
				
			}
			else {
				Node<T> current = head;
				for(int i=0; i<index-1; i++) {
					current = current.next;
				}
				deleteAfter(current);
			}
		}
		return true;
	}
	
	/**
	 * Deletes a node given the data that the node contains.
	 * @param data: the value to remove from the list.
	 * @return true/false on if the operation was successful.
	 */
	public boolean deleteItem(T data) {
		if (size == 0 ) {
			return false;
		}
		
		
		Node<T> current = head;
		//go till at the end of the list
		while(current != null) {
			// check if we have a match
			if(current.data.equals(data)) {
				//if the point is still at the head index then delete it
				if(current == head) {
					pop_front();
				}
				else {
					//else we can just use delete after to delete it
					deleteAfter(current.prev);
				}
			}
			current = current.next;
		}
		return false;
	}
	
	/**
	 * Prints the list into the console, head frist. 
	 */
	public void displayList() {
		Node<T> current = head;
		while(current != null) {
			System.out.print(current.data + "<==>" );
			current = current.next;
		}
		if(current == null) {
			System.out.print("END"+ "\n");
		}
	}
	
	/**
	 * Prints the list into the console starting from the tail.
	 */
	public void displayListBackwards() {
		Node<T> current = tail;
		while(current != null) {
			System.out.print(current.data + "<==>");
			current = current.prev;
		}
		if(current == null) {
			System.out.print("END"+ "\n");
		}
	}

	/**
	 * Prints the list in reverse order 
	 */
	public void reverse() {
		Node<T> hNode = head;
		Node<T> tNode = tail;
		Node<T> temp = new Node<T>(null);

		for(int i =0; i < size /2; i++) {
			temp.data = tNode.data;
			tNode.data = hNode.data;
			hNode.data = temp.data;
			hNode = hNode.next;
			tNode = tNode.prev;
		}
	}
	
}

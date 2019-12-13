package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		 size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException("Value to be added cannot be null.");
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
			prev.next = nodeToAdd;
			nodeToAdd.prev = prev;
			nodeToAdd.next = tail;
			tail.prev = nodeToAdd;
		
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds!.");
		}
		LLNode<E> node = head.next;
		while(index > 0) {
			node =node.next;
			index--;
		}
		
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Value to be added cannot be null.");
		}
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Indexout of bounds!.");
		}
		LLNode<E> nodeToAdd = new LLNode(element);
		LLNode<E> indexNode = head;
		for (int i = 0; i <= index; i++) {
			indexNode = indexNode.next;
		}
		LLNode<E> prev = indexNode.prev;
			prev.next = nodeToAdd;
			nodeToAdd.prev = prev;
			nodeToAdd.next = indexNode;
			indexNode.prev = nodeToAdd;
					
		size++;
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index out of bounds!");
		}
		
	
			LLNode<E> removeNode = head.next;
			while (index > 0) {
				removeNode = removeNode.next;
				index--;
			}
			removeNode.next.prev = removeNode.prev;
			removeNode.prev.next = removeNode.next;
			
			size--;
		return removeNode.data;
		
		
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size - 1) {
			throw new NullPointerException("Value to be added cannot be null.");
		}
		if (element == null) {
			throw new NullPointerException("Invaild input");
		}
		
		LLNode<E> setNode= head;
		for (int i = 0; i <= index; i++) {
			setNode = setNode.next;
		}
		
			setNode.data = element;
			return element;
		}
		
	}   


class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}

package mnq.naqui;

public class SinglyLinkedList<E> {
		
	Node<E> head;
	
	public static class Node<E>{
		
		Node next;
		E e;
		
		public Node(E e){
			this.e=e;
			next=null;
		}
	}
		public  void traverse() 
	    { 
	        Node<E> n = head; 
	        while (n != null) 
	        { 
	            System.out.print(n.e+" "); 
	            n = n.next; 
	        } 
	    } 
		
		 /* Inserts a new Node at front of the list. */
		public void push(E e) {
			
			/* 1 & 2: Allocate the Node & Put in the data*/
			Node<E> newNode= new Node<>(e);
			
			 /* 3. Make next of new Node as head */
			newNode.next = head; 
		  
		    /* 4. Move the head to point to new Node */
		    head = newNode; 
		}
		
		 /* Inserts a new node after the given prev_node. */
	    public void insertAfter(Node<E> prev_node, E new_data) 
	    { 
	        /* 1. Check if the given Node is null */
	        if (prev_node == null) 
	        { 
	            System.out.println("The given previous node cannot be null"); 
	            return; 
	        } 
	  
	        /* 2 & 3: Allocate the Node & 
	                  Put in the data*/
	        Node<E> new_node = new Node<E>(new_data); 
	  
	        /* 4. Make next of new Node as next of prev_node */
	        new_node.next = prev_node.next; 
	  
	        /* 5. make next of prev_node as new_node */
	        prev_node.next = new_node; 
	    } 
		
	    
	    /* Appends a new node at the end.  This method is  
	       defined inside LinkedList class shown above */
	    public void append(E new_data) 
	    { 
	        /* 1. Allocate the Node & 
	           2. Put in the data 
	           3. Set next as null */
	        Node<E> new_node = new Node<E>(new_data); 
	  
	        /* 4. If the Linked List is empty, then make the 
	              new node as head */
	        if (head == null) 
	        { 
	            head = new Node<E>(new_data); 
	            return; 
	        } 
	  
	        /* 4. This new node is going to be the last node, so 
	              make next of it as null */
	        new_node.next = null; 
	  
	        /* 5. Else traverse till the last node */
	        Node<E> last = head;  
	        while (last.next != null) 
	            last = last.next; 
	  
	        /* 6. Change the next of last node */
	        last.next = new_node; 
	        return; 
	    } 
	  
	    
		public static void main(String[] args) {
			
			SinglyLinkedList<Integer> llist= new SinglyLinkedList<Integer>();
			/*llist.head=new Node<Integer>("One");
			Node<Integer> second=new Node<Integer>("Two");
			Node<Integer> third=new Node<Integer>("Three");
			llist.push("Me");
			llist.head.next=second;
			llist.next=third;*/
			/*
			 // Insert 6.  So linked list becomes 6->NUllist 
	        llist.append(6); 
	  
	        // Insert 7 at the beginning. So linked list becomes 
	        // 7->6->NUllist 
	        llist.push(7); 
	  
	        // Insert 1 at the beginning. So linked list becomes 
	        // 1->7->6->NUllist 
	        llist.push(1); 
	  
	        // Insert 4 at the end. So linked list becomes 
	        // 1->7->6->4->NUllist 
	        llist.append(4); 
	  
	        // Insert 8, after 7. So linked list becomes 
	        // 1->7->8->6->4->NUllist 
	        llist.insertAfter(llist.head.next.next, 8); */
			
		
	    } 
			
	}
	
	



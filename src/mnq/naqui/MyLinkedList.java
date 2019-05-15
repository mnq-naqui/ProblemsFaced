package mnq.naqui;

public class MyLinkedList<E> {
	
	transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;
    
    protected transient int modCount = 0;
    
    public MyLinkedList() {
    }
	
	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

		        
    }
	
	public boolean add(E e) {
        linkLast(e);
        return true;
    }
	
	 void linkLast(E e) {
	        final Node<E> l = last;
	        final Node<E> newNode = new Node<>(l, e, null);
	        last = newNode;
	        if (l == null)
	            first = newNode;
	        else
	            l.next = newNode;
	        size++;
	        modCount++;
	    }
	 
	 
	 public void addLast(E e) {
	        linkLast(e);
	    }
	 
	 public void addFirst(E e) {
	        linkFirst(e);
	    }
	 
	 private void linkFirst(E e) {
	        final Node<E> f = first;
	        final Node<E> newNode = new Node<>(null, e, f);
	        first = newNode;
	        if (f == null)
	            last = newNode;
	        else
	            f.prev = newNode;
	        size++;
	        modCount++;
	    }
	 
	 public void add(int index, E element) {
	        checkPositionIndex(index);

	        if (index == size)
	            linkLast(element);
	        else
	            linkBefore(element, node(index));
	    }
	 
	 private void checkPositionIndex(int index) {
	        if (!isPositionIndex(index))
	            throw new IndexOutOfBoundsException(index+"");
	    }
	 
	 private boolean isPositionIndex(int index) {
	        return index >= 0 && index <= size;
	    }
	 
	 /**
	     * Returns the (non-null) Node at the specified element index.
	     */
	    Node<E> node(int index) {
	        // assert isElementIndex(index);

	        if (index < (size >> 1)) {
	            Node<E> x = first;
	            for (int i = 0; i < index; i++)
	                x = x.next;
	            return x;
	        } else {
	            Node<E> x = last;
	            for (int i = size - 1; i > index; i--)
	                x = x.prev;
	            return x;
	        }
	    }
	 
	    
	    /**
	     * Inserts element e before non-null Node succ.
	     */
	    void linkBefore(E e, Node<E> succ) {
	        // assert succ != null;
	        final Node<E> pred = succ.prev;
	        final Node<E> newNode = new Node<>(pred, e, succ);
	        succ.prev = newNode;
	        if (pred == null)
	            first = newNode;
	        else
	            pred.next = newNode;
	        size++;
	        modCount++;
	    }
	 // Add opeartion end

	    public void traverse(MyLinkedList< E> e) {
	    	
	    	for (int i = 0; i < size; i++) {
				System.out.print(e.node(i).item+" ");
			}
	    }
	   
}

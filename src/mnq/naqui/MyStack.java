package mnq.naqui;

public class MyStack<E> extends StackUtil<E> {
	
	/*Stack contains mainly five methods.
	1. push
	2. pop
	3. peek
	4. empty
	5. search*/
	
	
	public MyStack() {
		
	}
	
	public E push (E item) {
		
		addElement(item);
		return item;
	}
	
	public boolean empty() {
        return size() == 0;
    }
	
	 public synchronized E peek() {
	        int     len = size();

	        if (len == 0)
	            //throw new EmptyStackException();
	        	throw new RuntimeException();
	        return elementAt(len - 1);
	    }
	
	 public synchronized E pop() {
	        E       obj;
	        int     len = size();

	        obj = peek();
	        removeElementAt(len - 1);

	        return obj;
	    }
	 
	 public synchronized int search(Object o) {
	        int i = lastIndexOf(o);

	        if (i >= 0) {
	            return size() - i;
	        }
	        return -1;
	    }
	 
	 public String toString() {
		 
		 return super.toString();
	    }
}

package mnq.naqui;

import java.util.Arrays;

public class StackUtil<E> {
	
	protected transient int modCount = 0;
	protected int elementCount;
	protected int capacityIncrement;
	protected Object[] elementData;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	public StackUtil() {
		this.elementData = new Object[10];
    }
	
	
	// Push hleper method starts
	public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = obj;
    }
	
	private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
	
	 private void grow(int minCapacity) {
	        // overflow-conscious code
	        int oldCapacity = elementData.length;
	        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
	                                         capacityIncrement : oldCapacity);
	        if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
	        if (newCapacity - MAX_ARRAY_SIZE > 0)
	            newCapacity = hugeCapacity(minCapacity);
	        elementData = Arrays.copyOf(elementData, newCapacity);
	    }
	 
	 private static int hugeCapacity(int minCapacity) {
	        if (minCapacity < 0) // overflow
	            throw new OutOfMemoryError();
	        return (minCapacity > MAX_ARRAY_SIZE) ?
	            Integer.MAX_VALUE :
	            MAX_ARRAY_SIZE;
	    }
	 //Push helper method end
	 
	 
	 
	 // pop helper start
	 public synchronized void removeElementAt(int index) {
	        modCount++;
	        if (index >= elementCount) {
	            throw new ArrayIndexOutOfBoundsException(index + " >= " +
	                                                     elementCount);
	        }
	        else if (index < 0) {
	            throw new ArrayIndexOutOfBoundsException(index);
	        }
	        int j = elementCount - index - 1;
	        if (j > 0) {
	            System.arraycopy(elementData, index + 1, elementData, index, j);
	        }
	        elementCount--;
	        elementData[elementCount] = null; /* to let gc do its work */
	    }
	 
	 //pop helper end
	 
	 //peek helper end
	 public synchronized int size() {
	        return elementCount;
	    }
	 
	 
	 public synchronized E elementAt(int index) {
	        if (index >= elementCount) {
	            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
	        }

	        return elementData(index);
	    }
	 
	 E elementData(int index) {
	        return (E) elementData[index];
	    }
	 //peek helper end
	 
	 //search helper starts
	 public synchronized int lastIndexOf(Object o, int index) {
	        if (index >= elementCount)
	            throw new IndexOutOfBoundsException(index + " >= "+ elementCount);

	        if (o == null) {
	            for (int i = index; i >= 0; i--)
	                if (elementData[i]==null)
	                    return i;
		        } else {
		            for (int i = index; i >= 0; i--)
		                if (o.equals(elementData[i]))
		                    return i;
		        }
	        return -1;
	    }
	 
	 public synchronized int lastIndexOf(Object o) {
	        return lastIndexOf(o, elementCount-1);
	 }
	 //seaech helper end
	 
	 public String toString() {
		 for (int i = 0; i < elementData.length; i++) {
			System.out.print(elementData[i]+" ");
		}
		 
		 return "";
	    }
	    
}

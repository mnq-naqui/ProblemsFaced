package mnq.naqui;

import java.util.LinkedList;

public class Test {
	
	public static void main(String[] args) {
		
	/*	MyStack<Object> st =new MyStack<>();
		st.push(1);
		st.push(2);
		st.push("asd");
		st.push(true);
		st.push(21.2D);
		st.push(1);
		st.push(2);
		st.push("asd");
		st.push(true);
		st.push(21.2D);
		st.push(21.2D);//11
		
		
		System.out.println(st);
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st);*/
		
		MyLinkedList<Integer> lList=new MyLinkedList<>();
		lList.add(1);
		lList.add(2);
		lList.add(3);
		lList.add(4);
		lList.traverse(lList);
		
	}
	
	
	
}

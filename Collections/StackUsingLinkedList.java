package day17;

import java.util.LinkedList;

public class StackUsingLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<>();
		// addLast메서드는 LinkedList의 end부분에 데이터를 입력한다.
		stack.addLast(12);
		stack.addLast(new Integer(59));
		stack.addLast(new Integer(7));
		while(!stack.isEmpty()) {
			Integer num = stack.removeLast();
			System.out.println(num);
		}
	}
}

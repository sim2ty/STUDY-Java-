package day17;

import java.util.LinkedList;

public class QueueUsingLinkedList {
	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>();
		// offer메서드는 LinkedList의 Tail부분에 데이터를 입력한다.
		queue.offer("토끼");
		queue.offer("사슴");
		queue.offer("호랑이");
		while(!queue.isEmpty()) {
			String str = queue.poll();
			System.out.println(str);
		}
	}

}

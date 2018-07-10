package day17;

import java.util.ArrayList;

class CreateList{
	public ArrayList<Integer> convertList(int array[]) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		//Array배열의 내용을 ArrayList에 담되, 배열의 가장 뒷 요소가 ArrayList의 앞 요소가 되도록 넣는다. 
		for (int i = array.length-1; i >= 0 ; i--) {
			al.add(array[i]);
		}
		return al; 
	}
}

public class ListTest {
	public static void main(String[] args) {
		int array[] = {3,4,2,5,2,3,6,7,5,7,9};
		CreateList c = new CreateList();
		ArrayList<Integer> al;
		al=c.convertList(array);
		for(Integer a : al) {
			System.out.println(a);
		}
	}
}

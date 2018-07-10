package day17;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapLab1 {
	public static void main(String[] args) {
		HashMap<String, Integer> list = new HashMap<>();
		
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("나라이름과 인구수를 차례로 입력 > ");
			list.put(in.next(), in.nextInt());
		}
		
		int [] popu = new int [list.size()];
		Object [] names = list.keySet().toArray();
	
		for (int i = 0; i < names.length; i++)	{	
			popu[i] = list.get(names[i]);			
		}
		int max = 0;
		int min = popu[0];
		for (int i = 0; i < popu.length; i++) {
			if(popu[i]>max) {
				max = popu[i];
			}
		}
		for (int i = 0; i < popu.length; i++) {
			if(popu[i]<min) {
				min = popu[i];
			}
		}
		
		//기본 출력
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + "(" + list.get(names[i]) + ")");
			if(i<names.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		//인구수 제일 많은 나라
		System.out.print("인구수 제일 많은 나라 : ");
		for (int i = 0; i < names.length; i++) {
			// 인구수 제일 많은 나라가 다수인 경우, 그에 해당하는 나라를 모두 출력
			if(popu[i]==max) {
				System.out.print(names[i]+" ");
			}
		}
		System.out.println();
		
		//인구수 제일 적은 나라
		System.out.print("인구수 제일 적은 나라 : ");
		for (int i = 0; i < names.length; i++) {
			// 인구수 제일 적은 나라가 다수인 경우, 그에 해당하는 나라를 모두 출력
			if(popu[i]==min) {
				System.out.print(names[i]+" ");
			}
		}
	}
}

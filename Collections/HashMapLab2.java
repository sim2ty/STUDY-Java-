package day17;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class HashMapLab2 {
	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<>();
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.print("고객명과 포인트를 차례로 입력 (마지막 입력이 끝나면 e 입력)> ");
			String str = in.next();
			if(str.equals("e")) {
				map.remove(str);
				break;
			}
			Double point = in.nextDouble();
			if(map.containsKey(str)) {
				// 이미 있는 고객이고, 포인트가 0이면 해당 고객명을 제거
				if(point==0) {
					map.remove(str);
				}
				// 이미 있는 고객이면 포인트 누적 (replace 메서드 사용)
				else {
					map.replace(str, map.get(str), map.get(str)+point);
				}
			// 앞에 해당하지 않으면(목록에 없는 고객이면) 해당 고객명 입력
			}else {
			map.put(str,point);
			}
		}
		System.out.println("데이터 개수 : " + map.size());
		System.out.println("데이터 리스트");
		
		// TreeMap은 데이터들을 넣어주는 즉시 오름차순으로 정리해준다.
		TreeMap<String, Double> asc = new TreeMap<String, Double>(map);
		for(String s:asc.keySet()) {
			System.out.println(s + " - " + asc.get(s));
		}
	}
}

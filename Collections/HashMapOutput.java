package day17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapOutput {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("해리", 95);
		map.put("헤르미온느", 100);
		map.put("론", 85);
		map.put("드레이코", 93);
		map.put("네빌", 70);
		map.put("헤르미온느", 55);
		System.out.println(map);
		Integer num = map.get("헤르미온느");
		System.out.println("헤르미온느의 성적은? " + num);	//기존 데이터에 덮어쓰기 된다.
		
		// HashMap 객체에 저장된 데이터들의 name(key)들만 추출해서 화면에 출력
		Set<String> keys = map.keySet();
		System.out.print("key값 추출 : ");
		for(String s : keys) {
			System.out.print(s + " / ");
		}
		System.out.println();
		
		// HashMap 객체에 저장된 데이터들을 name --> value 형식으로 행단위로 출력
		//[방법1]
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next(); // Set의 key 값을 하나씩 key에 대입
			int val = map.get(key); // 해당 key에 해당하는 value 대입 / AutoUnBoxing
			System.out.println(key + " --> " + val);
		}
		//[방법2]
		for(String str:map.keySet()) {
			System.out.println(str + " --> " + map.get(str));
		}
		//[방법3]
		Object names[] = map.keySet().toArray();
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + " --> " + map.get(names[i]));
		}
	}
}

package day17;

import java.util.HashSet;
import java.util.Iterator;

public class LottoSet {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		while (lotto.size()<10) {					// HashSet에 10개 숫자가 들어갈때까지 넣는다.
			lotto.add((int)(Math.random()*21)+10);	// 10~30 까지의 난수 추출
		}

		Iterator<Integer> iter = lotto.iterator();
		System.out.print("오늘의 로또 번호 : ");
		
		//Interator의 hasNext() 사용하여 출력
		while(iter.hasNext()) {
			System.out.print(iter.next());
			if(iter.hasNext()) {
				System.out.print(", ");
			}else break;
		}
	}
}

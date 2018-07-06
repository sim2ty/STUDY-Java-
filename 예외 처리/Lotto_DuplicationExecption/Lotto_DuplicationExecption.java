package day15;

import java.util.Random;

class DuplicateException extends Exception{
	DuplicateException(){
		super("중복된 로또 번호가 발생했습니다.");
	}
}

class LottoMachine{
	private int [] nums;
	public LottoMachine() {
		nums = new int [6];
	}
	public void createLottoNums() {
		Random rand = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(20)+1;
		}
	}
	public void checkLottoNums() throws DuplicateException{
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]==nums[j]){
					throw new DuplicateException();
				}
			}
		}
	}
	public int[] getNums() {
		return nums;
	}
}

public class Lotto_DuplicationExecption {
	public static void main(String[] args) {
		LottoMachine lm = new LottoMachine();
		lm.createLottoNums();
		try{
			lm.checkLottoNums();
			int [] nums = lm.getNums();
			System.out.print("(");
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i]);
				if(i<nums.length-1) {
					System.out.print(", ");
				}
			}
			System.out.print(")");
		}catch(DuplicateException e){
			System.out.println(e.getMessage());
		}
	}

}





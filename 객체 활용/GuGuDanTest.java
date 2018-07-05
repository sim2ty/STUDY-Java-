package day12;

class GuGu{
	private int dan;
	private int number;
	GuGu(){}
	GuGu(int dan){
		this.dan = dan;
	}
	
	GuGu(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	
	void printPart() {
		if(number==0) {
			for (int n = 1; n <=9 ; n++) {
				System.out.print("\t" + dan + "*" + n + "=" + dan*n);
			}
			System.out.println();
		}else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDan extends GuGu{
	GuGuDan(){
		super();
	}
	GuGuDan(int dan){
		super(dan);
	}
	GuGuDan(int dan, int number){
		super(dan,number);
	}
	
	static void printAll() {
		for(int i = 1 ; i <= 9 ; i++) {
			for(int j = 1 ; j <= 9 ; j++) {
				System.out.printf("%1d * %1d = %1d\t", i, j, i*j);
			}
			System.out.println();
		}
	}
}


public class GuGuDanTest {

	public static void main(String[] args) {
		int dan = (int)(Math.random()*20)+1;
		int number = (int)(Math.random()*20)+1;
		//dan, number 확인용 출력
		System.out.println("dan : " + dan + ", number : " + number);
		//(1)case
		if(dan>=1 && dan<=9 && number>=1 && number<=9) {
			GuGuDan gg = new GuGuDan(dan,number);
			gg.printPart();
		}
		//(2)case
		if(dan>=1 && dan<=9 && number>=10) {
			GuGuDan gg = new GuGuDan(dan);
			gg.printPart();
		}
		//(3)case
		if(dan>=10) {
			GuGuDan.printAll();
		}
	}

}

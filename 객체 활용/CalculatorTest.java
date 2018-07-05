package day11;

import java.util.Scanner;

class CalculatorExpr{
	int num1;
	int num2;
	CalculatorExpr(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	int getAddition() {
		return num1+num2;
	}
	int getSubtraction() {
		return num1-num2;
	}
	int getMultiplication() {
		return num1*num2;
	}
	double getDivision() {
		return (double)num1/num2;
	}
}

public class CalculatorTest {
	public static void main(String[] args) {
		loop1:
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.print("숫자 두개 입력 > ");
			int num1 = in.nextInt();
			int num2 = in.nextInt();
			CalculatorExpr calc = new CalculatorExpr(num1,num2);
			System.out.println("추출된 숫자 : " + num1 + ", " + num2);
			System.out.println("덧셈 : " + calc.getAddition());
			System.out.println("뺄셈 : " + calc.getSubtraction());
			System.out.println("곱셈 : " + calc.getMultiplication());
			System.out.printf("나눗셈 : %.2f\n",calc.getDivision());
			
			while(true) {
				System.out.print("계속 진행하시겠습니까?(Y/N) > ");
				String str = in.next();
				if(str.equals("Y")) {
					continue loop1;
				}else if(str.equals("N")) {
					System.out.println("프로그램 종료");
					break loop1;
				}else {
					System.out.println("잘못 입력하셨습니다.");
					continue;
					}
				}
		}
	}
}

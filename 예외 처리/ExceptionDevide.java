package day15;
public class ExceptionDevide {
	public static void main(String[] args) {
		System.out.println("수행시작");
		try {
			int num1 = (int)(Math.random()*10);
			int num2 = (int)(Math.random()*10);
			System.out.println("num1 : " + num1 + ", num2 : " + num2);
			int result = num1/num2;
			System.out.println("연산 결과 : "+result);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("두개의 프로그램 아규먼트를 입력하세요");
		} catch (ArithmeticException e) {
			System.out.println("두 번째 숫자는 0일 수 없어요");	
			System.out.println(e.getMessage());
			System.out.println(e.getClass().getName());
			System.out.println(e);
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요");
		} finally {
			System.out.println("이 블럭은 반드시 수행합니다.");
		}
		System.out.println("수행종료");
	}
}






package day21;
abstract class Test {
   Test() {
      System.out.println("No Argument sample");
   }
   Test(String msg) {
	      System.out.println("Argument sample : " + msg);
	   }
   abstract void output(String s);
}
public class InnerClassFlow {
   void pr(Test o) {
      o.output("Test");     
   }
   public static void main(String args[]) {	   
      System.out.println("Main start !!");
      InnerClassFlow n = new InnerClassFlow();
      n.pr(new Test("ㅋㅋㅋ") {
         int su = 100;
         public void output(String s) {
            System.out.println("Anonymous Class : " + s);
            System.out.println("Anonymous Class : " + su);            
         }				
      });			
   }	
}



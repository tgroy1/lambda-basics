package lambdabasics;

public class ClosureExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
//		b = 30;
		
//		doProcess(a, new Process() {
//			
//			@Override
//			public void process(int i) {
//				System.out.println(i + b);
//				
//			}
//		});
		
		Process myProc = i -> System.out.println(i + b);
		myProc.process(a);
	}
}

interface Process {
	void process(int i);
}

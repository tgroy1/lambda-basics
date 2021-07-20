package lambdabasics;

public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		doProcess(10, i -> {
			System.out.println("Value of i -> " + i);
			System.out.println(this);
		});
	}

	public static void main(String[] args) {

		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

		System.out.println("--- Anonymous inner class impl ---");
		thisReferenceExample.doProcess(10, new Process() {

			@Override
			public void process(int i) {
				System.out.println("Value of i -> " + i);
				System.out.println(this);
			}

			public String toString() {
				return "This is the anonymous inner class instance";
			}
		});

		System.out.println("--- Lambda impl ---");
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i -> " + i);
//			System.out.println(this); //This will not work
		});

		System.out.println("--- Lambda impl inside instance method ---");
		thisReferenceExample.execute();

	}

	public String toString() {
		return "This is the ThisReferenceExample class instance";
	}

}
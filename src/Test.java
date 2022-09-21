import java.util.Optional;

public class Test {
	
	public static String getDefault() {
		System.out.println("Inside getDefault() method");
		return "default";
	}
	
	public static void main(String[] args) {

//		MyFunc func = new MyFunc() {
//			
//			@Override
//			public void print(String s) {
//				System.out.println(s);
//				
//			}
//		};

		MyFunc func = s -> System.out.println(s);

		func.print("Hello");
		
		//String str = Optional.ofNullable("text").orElse(getDefault());
		String str = Optional.ofNullable("text").orElseGet(Test::getDefault);
		System.out.println(str);

	}

}

interface MyFunc {

	void print(String s);

}

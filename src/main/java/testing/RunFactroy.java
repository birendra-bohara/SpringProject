package testing;

public class RunFactroy {

	public static void main(String[] args) {
		Os ios=FactoryPattern.getInstance("IOS");
		System.out.println(ios);
	}
}

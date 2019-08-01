package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Test {
	void print();
}

//class TestImple implements Test {
//
//	@Override
//	public void print() {
//		System.out.println("Hello World!!");
//
//	}
//
//}

public class LambdaTest {
	public static void main(String[] args) {
//		Test obj = new TestImple();
//		obj.print();

		Test objs = () -> {
			System.out.println("Hello World!!");
		};
		objs.print();

		List<Integer> list = Arrays.asList(20, 50, 90, 34, 5, 56, 6, 2);
		list.forEach(i -> System.out.println(i));
	}
}

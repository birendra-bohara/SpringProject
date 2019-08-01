package testing;

public class Company {

	private static final Company cmp = new Company();

	private Company() {
	}

	public static Company getInstance() {
		return cmp;
	}
}

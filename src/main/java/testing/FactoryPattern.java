package testing;

public class FactoryPattern {

	public static Os getInstance(String osname) {
		if(osname.equals("Windows")) {
		 return	new Windows();
		}else if(osname.equals("Android")) {
			return new Android();
		}else if(osname.equals("IOS")) {
			return new IOS();
		}
		return null;
	}
}

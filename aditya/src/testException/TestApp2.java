package testException;

public class TestApp2 {
	public static void main(String args[]) {
		try {
			callE1();
		} catch (ExceptionD ex) {
			System.out.println(ex.getCode() + "   " + ex.getMessage() + "  " + ex.getClass().getName());
		}

		try {
			callE2();
		} catch (ExceptionD ex) {
			System.out.println(ex.getCode() + "   " + ex.getMessage() + "  " + ex.getClass().getName());
		}

	}

	private static void callE1() throws ExceptionD {
		throw new ExceptionE1(200, "Error E1");
	}

	private static void callE2() throws ExceptionD {
		throw new ExceptionE2(200, "Error E2");
	}
}

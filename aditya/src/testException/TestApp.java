package testException;

public class TestApp {
	public static void main(String args[]) {
		try {
			callA();
		} catch (ExceptionA ex) {
			System.out.println(ex.getCode() + "   " + ex.getMessage()+ "  "+ex.getClass().getName());
		}

	}

	private static void callA() throws ExceptionA {
		try {
			callB();
		} catch (ExceptionB ex) {
			throw new ExceptionA(ex.getCode(), ex.getMessage());
		}
	}

	private static void callB() throws ExceptionB {
		try {
			callC();
		} catch (ExceptionC ex) {
			throw new ExceptionB(ex.getCode(), ex.getMessage());
		}
	}

	private static void callC() throws ExceptionC {
		try {
			callD();
		} catch (ExceptionD ex) {
			throw new ExceptionC(ex.getCode(), ex.getMessage());
		}

	}

	private static void callD() throws ExceptionD {
		throw new ExceptionD(100, "MyError");
	}
}

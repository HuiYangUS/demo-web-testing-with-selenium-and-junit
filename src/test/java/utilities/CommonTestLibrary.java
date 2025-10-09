package utilities;

public class CommonTestLibrary {

	public static void waitInSecondsFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.err.println("Testing failed to wait for the next action!");
			e.printStackTrace();
		}
	}

}

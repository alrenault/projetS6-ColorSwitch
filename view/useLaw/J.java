package view.useLaw;

/**
 *
 */
public final class J implements UseLaw {
	/**
	 *
	 */
	String message;

	/**
	 *
	 */
	public J() {
		message = "J" ;
	}

	/**
	 *
	 */
	public void apply() {
		System.err.println(message);
	}
}

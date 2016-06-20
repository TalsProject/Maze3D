package env;


/**
 * A factory for creating Os objects.
 */
public class OsFactory {
	
	/**
	 * Gets the env.
	 *
	 * @param env the env
	 * @return the env
	 */
	public static OsProperties getEnv(String env) {
		if (env.equals("Windows")) {
			return new OsWindows();
		} else if (env.equals("Linux")) {
			return new OsLinux();
		}
		
		return null;
	}
}

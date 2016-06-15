package env;

public class OsFactory {
	public static OsProperties getEnv(String env) {
		if (env.equals("Windows")) {
			return new OsWindows();
		} else if (env.equals("Linux")) {
			return new OsLinux();
		}
		
		return null;
	}
}

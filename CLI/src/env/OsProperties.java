package env;

public abstract class OsProperties {
	public final String fileSeperator;
	
	protected OsProperties(String fileSeperator) {
		this.fileSeperator = fileSeperator;
	}
}

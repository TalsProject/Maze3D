package env;


/**
 * The Class OsProperties.
 */
public abstract class OsProperties {
	
	/** The file seperator. */
	public final String fileSeperator;
	
	/**
	 * Instantiates a new os properties.
	 *
	 * @param fileSeperator the file seperator
	 */
	protected OsProperties(String fileSeperator) {
		this.fileSeperator = fileSeperator;
	}
}

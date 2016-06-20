package presenter;

import java.io.Serializable;

import env.OsFactory;
import env.OsProperties;


/**
 * The Class Properties.
 */
public class Properties implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The algosolve. */
	private String algosolve;
	
	/** The uitype. */
	private String uitype;
	
	/** The number of cells. */
	private int numberOfCells;
	
	/** The thread num. */
	private int threadNum;

	/**
	 * Instantiates a new properties.
	 */
	public Properties() {
	}
		
	/**
	 * Instantiates a new properties.
	 *
	 * @param algosolve the algosolve
	 * @param uitype the uitype
	 * @param numberOfCells the number of cells
	 * @param threadNum the thread num
	 */
	public Properties(String algosolve, String uitype, int numberOfCells, int threadNum) {
		this.algosolve = algosolve;
		this.uitype = uitype;
		this.threadNum = threadNum;
		this.numberOfCells = numberOfCells;
	}

	/**
	 * Gets the uitype.
	 *
	 * @return the uitype
	 */
	public String getUitype() {
		return uitype;
	}

	/**
	 * Sets the uitype.
	 *
	 * @param uitype the new uitype
	 */
	public void setUitype(String uitype) {
		this.uitype = uitype;
	}

	/**
	 * Gets the algosolve.
	 *
	 * @return the algosolve
	 */
	public String getAlgosolve() {
		return algosolve;
	}

	/**
	 * Sets the algosolve.
	 *
	 * @param algosolve the new algosolve
	 */
	public void setAlgosolve(String algosolve) {
		this.algosolve = algosolve;
	}
	
	/**
	 * Gets the number of cells.
	 *
	 * @return the number of cells
	 */
	public int getNumberOfCells() {
		return numberOfCells;
	}

	/**
	 * Sets the number of cells.
	 *
	 * @param numberOfCells the new number of cells
	 */
	public void setNumberOfCells(int numberOfCells) {
		this.numberOfCells = numberOfCells;
	}
	
	/**
	 * Gets the thread num.
	 *
	 * @return the thread num
	 */
	public int getThreadNum() {
		return threadNum;
	}

	/**
	 * Sets the thread num.
	 *
	 * @param threadNum the new thread num
	 */
	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}
}

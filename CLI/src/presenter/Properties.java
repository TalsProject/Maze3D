package presenter;

import java.io.Serializable;

public class Properties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String algosolve;
	public String uitype;
	public int threadNum;

	public Properties() {
	}
		
	public Properties(String algosolve, String uitype, int threadNum) {
		this.algosolve = algosolve;
		this.uitype = uitype;
		this.threadNum = threadNum;
	}

	public String getUitype() {
		return uitype;
	}

	public void setUitype(String uitype) {
		this.uitype = uitype;
	}

	public String getAlgosolve() {
		return algosolve;
	}

	public void setAlgosolve(String algosolve) {
		this.algosolve = algosolve;
	}
	
	public int getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}
}

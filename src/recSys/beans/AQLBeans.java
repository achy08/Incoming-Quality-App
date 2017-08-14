package recSys.beans;

public class AQLBeans {
	
	private int countNG;
	private int sampleSize;
	private int countOK;
	private static boolean isNG;
	public int getCountNG() {
		return countNG;
	}
	public void setCountNG(int countNG) {
		this.countNG = countNG;
	}
	public int getSampleSize() {
		return sampleSize;
	}
	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}
	public int getCountOK() {
		return countOK;
	}
	public void setCountOK(int countOK) {
		this.countOK = countOK;
	}
	public boolean isNG() {
		return isNG;
	}
	public void setNG(boolean isNG) {
		AQLBeans.isNG = isNG;
	}


}


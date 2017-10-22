package group1.khai.models;

public class Fee {
	private String feeName;
	private double feeValue;
	private int feeCycle;

	public Fee(String costName, double costValue, int costCycle) {
		this.feeName = costName;
		this.feeValue = costValue;
		this.feeCycle = costCycle;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String costName) {
		this.feeName = costName;
	}

	public double getFeeValue() {
		return feeValue;
	}

	/**
	 * value >0 unit 100.000 VND
	 * 
	 * @param costValue
	 */
	public void setFeeValue(double costValue) {
		if (costValue > 0)
			this.feeValue = costValue;
	}

	public int getFeeCycle() {
		return feeCycle;
	}

	/**
	 * cycle >0 unit day
	 * 
	 * @param costCycle
	 */
	public void setFeeCycle(int costCycle) {
		if (costCycle > 0)
			this.feeCycle = costCycle;
	}

}

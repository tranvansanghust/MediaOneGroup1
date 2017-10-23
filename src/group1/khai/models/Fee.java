package group1.khai.models;

import java.sql.Timestamp;

public class Fee {
	private String feeName;
	private double feeValue;
	private int feeCycle;
	private Timestamp lastRequest;

	

	public Fee(String feeName, double feeValue, int feeCycle, Timestamp lastRequest) {
		super();
		this.feeName = feeName;
		this.feeValue = feeValue;
		this.feeCycle = feeCycle;
		this.lastRequest = lastRequest;
	}

	public Timestamp getLastRequest() {
		return lastRequest;
	}

	public void setLastRequest(Timestamp lastRequest) {
		this.lastRequest = lastRequest;
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

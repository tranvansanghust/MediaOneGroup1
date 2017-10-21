package nhom1.Khai.pack;

public class Cost {
	private String costName;
	private double costValue;
	private int costCycle;

	public Cost(String costName, double costValue, int costCycle) {
		this.costName = costName;
		this.costValue = costValue;
		this.costCycle = costCycle;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public double getCostValue() {
		return costValue;
	}

	/**
	 * value >0 unit 100.000 VND
	 * 
	 * @param costValue
	 */
	public void setCostValue(double costValue) {
		if (costValue > 0)
			this.costValue = costValue;
	}

	public int getCostCycle() {
		return costCycle;
	}

	/**
	 * cycle >0 unit day
	 * 
	 * @param costCycle
	 */
	public void setCostCycle(int costCycle) {
		if (costCycle > 0)
			this.costCycle = costCycle;
	}

}

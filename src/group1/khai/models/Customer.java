package group1.khai.models;

public class Customer extends Human {
	private double point;
	public static int idNumber;
	public Customer() {
		super();
	}

	public Customer(double point) {
		super();
		setPoint(point);
	}

	public double getPoint() {
		return point;
	}

	/**
	 * point > 0
	 * 
	 * @param point
	 */
	public void setPoint(double point) {
		if (point > 0)
			this.point = point;
	}
}

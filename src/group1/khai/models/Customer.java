package group1.khai.models;

public class Customer extends Human {
	private double point;
	public static int idNumber;
	public Customer() {
		super();
	}

	public Customer(String iD, String fullName, String telephoneNumber,double point) {
		super(iD,fullName,telephoneNumber);
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
	public static String genID() {
		String a = Integer.toString(++idNumber);
		StringBuilder build = new StringBuilder();
		build.append("CS");
		for(int i=0;i<8-a.length()-2;i++) {
			build.append("0");
		}
		build.append(a);
		return build.toString();
	}
}

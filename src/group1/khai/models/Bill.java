package group1.khai.models;

import java.sql.Timestamp;

public class Bill {
	private BillDetail billDetail;
	
	private String ID;
	private String employeeID;
	private String customerID;
	private Timestamp sellTimestamp;
	public static int idNumber;
	public Bill(String employeeID, String customerID, Timestamp e) {
		this.employeeID = employeeID;
		this.customerID = customerID;
		this.setSellTimestamp(e);
	}

	public BillDetail getBillDetail() {
		return billDetail;
	}


	public void setBillDetail(BillDetail billDetail) {
		this.billDetail = billDetail;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * ID must be a 8 Character String
	 * 
	 * @param iD
	 *            is a String
	 */
	public void setEmployeeID(String employeeID) {
		if (employeeID.length() == 8)
			this.employeeID = employeeID;
	}

	public String getCustomerID() {
		return customerID;
	}

	/**
	 * ID must be a 8 Character String
	 * 
	 * @param iD
	 *            is a String
	 */
	public void setCustomerID(String customerID) {
		if (customerID.length() == 8)
			this.customerID = customerID;
	}
	
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the sellTimestamp
	 */
	public Timestamp getSellTimestamp() {
		return sellTimestamp;
	}

	/**
	 * @param sellTimestamp the sellTimestamp to set
	 */
	public void setSellTimestamp(Timestamp sellTimestamp) {
		this.sellTimestamp = sellTimestamp;
	}

}

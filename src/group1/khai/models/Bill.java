package group1.khai.models;




public class Bill {
	private BillDetail billDetail;
	
	private String ID;
	private String employeeID;
	private String customerID;
	public static int idNumber;
	public Bill(String employeeID, String customerID) {
		this.employeeID = employeeID;
		this.customerID = customerID;
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

}

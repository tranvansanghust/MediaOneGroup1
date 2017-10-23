package group1.khai.models;

import java.sql.Timestamp;

public class Paid {
	private String ID;
	private String feeName;
	private boolean paid;
	private double feeValue;
	private Timestamp requestTime;
	private Timestamp paidTime;
	public static int idNumber;
	
	
	
	public Paid(String iD, String feeName, boolean status, double feeValue, Timestamp requestTime, Timestamp paidTime) {
		super();
		ID = iD;
		this.feeName = feeName;
		this.paid = status;
		this.feeValue = feeValue;
		this.requestTime = requestTime;
		this.paidTime = paidTime;
	}

	public double getFeeValue() {
		return feeValue;
	}

	public void setFeeValue(double feeValue) {
		this.feeValue = feeValue;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFeeName() {
		return feeName;
	}
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setStatus(boolean status) {
		this.paid = status;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public Timestamp getPaidTime() {
		return paidTime;
	}
	public void setPaidTime(Timestamp paidTime) {
		this.paidTime = paidTime;
	}
	public static String genID() {
		String a = Integer.toString(++idNumber);
		StringBuilder build = new StringBuilder();
		build.append("PD");
		for(int i=0;i<8-a.length()-2;i++) {
			build.append("0");
		}
		build.append(a);
		return build.toString();
	}
	
}

package nhom1.Khai.pack;

public class Human {
	private String ID;
	private String fullName;
	private String telephoneNumber;

	public Human() {

	}

	public Human(String iD, String fullName, String telephoneNumber) {
		setID(iD);
		setFullName(fullName);
		setTelephoneNumber(telephoneNumber);
	}

	public String getID() {
		return ID;
	}

	public String getFullName() {
		return fullName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * ID must be a 8 Character String
	 * 
	 * @param iD
	 *            is a String
	 */
	public void setID(String iD) {

		if (iD.length() == 8) {
			this.ID = iD;
		}
	}

	/**
	 * fullName must be < 256 character and not have number
	 * 
	 * @param fullName
	 *            is a String
	 */
	public void setFullName(String fullName) {
		for (int i = 0; i < fullName.length(); i++) {
			if (Character.isDigit(fullName.charAt(i)))
				return;
		}
		if (fullName.length() < 256)
			this.fullName = fullName;
	}

	/**
	 * telephoneNumber must start by 0 and be a 11 or 10 Digit String
	 * 
	 * @param telephoneNumber
	 *            is a String
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		for (int i = 0; i < telephoneNumber.length(); i++) {
			if (!Character.isDigit(telephoneNumber.charAt(i)))
				return;
		}
		if (telephoneNumber.length() == 10 && telephoneNumber.length() == 11 && telephoneNumber.charAt(0) == '0') {
			this.telephoneNumber = telephoneNumber;
		}
	}
}

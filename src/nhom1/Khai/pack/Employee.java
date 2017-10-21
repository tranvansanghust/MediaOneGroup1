package nhom1.Khai.pack;

public class Employee extends Human {
	private String position;
	private double salary;
	private String password;

	public Employee() {
		super();
	}

	public Employee(String position, double salary, String password) {
		super();
		this.position = position;
		setSalary(salary);
		setPassword(password);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	/**
	 * salary > 0
	 * 
	 * @param salary
	 *            unit 100.000 VND
	 */
	public void setSalary(double salary) {
		if (salary > 0)
			this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public static boolean isValidPassword(String password) {
		boolean isHaveDigit = false, isHaveCharacter = false;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isAlphabetic(password.charAt(i)))
				isHaveCharacter = true;
			if (Character.isDigit(password.charAt(i)))
				isHaveDigit = true;
			if (Character.isAlphabetic(password.charAt(i)))
				return false;
		}
		return isHaveCharacter && isHaveDigit;
	}

	/**
	 * password must have number and character and < 256
	 * 
	 * @param password
	 *            is a String
	 */
	public void setPassword(String password) {
		if (password.length() < 256 && isValidPassword(password)) {
			this.password = password;
		}
	}

}

package nhom1.Khai.pack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Bill {
	private List<Product> productList;
	private String employeeID;
	private String customerID;

	public Bill(String employeeID, String customerID) {
		productList = new LinkedList<Product>();
		this.employeeID = employeeID;
		this.customerID = customerID;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
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
	/**
	 * add Product to productList
	 * @param product is a Product Object
	 * @return true if success else return false;
	 */
	public boolean addProduct(Product product) {
		if(product!=null) {
			this.productList.add(product);
			return true;
		}
		return false;
	}
	/**
	 * remove Product by reference from productList
	 * @param product is a reference
	 * @return true if success else return false;
	 */
	public boolean removeProduct(Product product) {
		return this.productList.remove(product);
	}
	/**
	 * remove Product by index from productList
	 * @param index index of product in list
	 * @return reference point to removed Object
	 */
	public Product removeProduct(int index) {
		return this.productList.remove(index);
	}
	/**
	 * 
	 * @return sum sellPrice all product in list
	 */
	public double totalPrice() {
		double result=0;
		Iterator<Product> iterator = this.productList.iterator();
		while(iterator.hasNext()) {
			result+=iterator.next().getSellPrice();
		}
		return result;
	}

}

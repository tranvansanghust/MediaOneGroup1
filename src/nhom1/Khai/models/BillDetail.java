package nhom1.khai.models;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BillDetail {
	private String ID;
	private List<Product> productList;
	public static int idNumber;
	public BillDetail() {
		
	}
	public BillDetail(String iD) {
		super();
		ID = iD;
		this.productList = new LinkedList<>();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
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

	/**
	 * @return the iD
	 */
}

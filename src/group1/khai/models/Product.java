package group1.khai.models;

import java.sql.Timestamp;

public class Product {
	public static final int BOOK = 1, MUSIC_DISC = 2, MOVIE_DISC = 3;
	private String ID;
	private String productName;
	private int productType;
	private long productQuota;
	private double buyPrice;
	private double sellPrice;
	private Timestamp buyTimestamp;
	public Product() {
		
	}
	public Product(String iD, String productName, int productType, long productQuota, double buyPrice, double sellPrice,
			Timestamp buyTimestamp) {
		super();
		setID(iD);
		setProductName(productName);
		setProductType(productType);
		setProductQuota(productQuota);
		setBuyPrice(buyPrice);
		setSellPrice(sellPrice);
		this.buyTimestamp = buyTimestamp;
		
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


	public String getID() {
		return ID;
	}
	public String getProductName() {
		return productName;
	}

	/**
	 * fullName must be < 256 character 
	 * 
	 * @param fullName
	 *            is a String
	 */
	public void setProductName(String productName) {
		
		if (productName.length() < 256)
			this.productName = productName;
	}

	public int getProductType() {
		return productType;
	}

	/**
	 * BOOK=1, MUSIC_DISC =2, MOVIE_DISC =3
	 * 
	 * @param productType
	 */
	public void setProductType(int productType) {
		if (productType == 1 || productType == 2 || productType == 3) {
			this.productType = productType;
		}
	}

	public long getProductQuota() {
		return productQuota;
	}

	/**
	 * Quota >0
	 * 
	 * @param productQuota
	 */
	public void setProductQuota(long productQuota) {
		if (productQuota > 0)
			this.productQuota = productQuota;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * Price >0
	 * 
	 * @param buyPrice
	 */
	public void setBuyPrice(double buyPrice) {
		if (buyPrice > 0)
			this.buyPrice = buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	/**
	 * Price >0
	 * 
	 * @param sellPrice
	 */
	public void setSellPrice(double sellPrice) {
		if (sellPrice > 0)
			this.sellPrice = sellPrice;
	}

	public Timestamp getBuyTimestamp() {
		return buyTimestamp;
	}

	public void setBuyTimestamp(Timestamp buyTimestamp) {
		this.buyTimestamp = buyTimestamp;
	}



}

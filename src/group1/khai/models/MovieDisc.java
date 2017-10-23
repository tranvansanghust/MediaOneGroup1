package group1.khai.models;

import java.sql.Timestamp;

public class MovieDisc extends Product {
	private String directorName;
	private String actorName;
	private String dicsType;
	public static int idNumber;
	public MovieDisc() {
		super();
	}

	public MovieDisc(String iD, String productName, int productType, long productQuota, double buyPrice, double sellPrice,
			Timestamp buyTimestamp,String directorName, String actorName, String dicsType) {
		super(iD,productName,productType,productQuota,buyPrice,sellPrice,buyTimestamp);
		this.directorName = directorName;
		this.actorName = actorName;
		this.dicsType = dicsType;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getDicsType() {
		return dicsType;
	}

	public void setDicsType(String dicsType) {
		this.dicsType = dicsType;
	}

}
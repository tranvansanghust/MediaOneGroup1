package group1.khai.models;

import java.sql.Timestamp;

public class MusicDisc extends Product{
	private String authorName;
	private String singerName;
	private String dicsType;
	public static int idNumber;
	public MusicDisc() {
		super();
	}
	
	public MusicDisc(String iD, String productName, int productType, long productQuota, double buyPrice, double sellPrice,
			Timestamp buyTimestamp,String authorName, String singerName, String dicsType) {
		super(iD,productName,productType,productQuota,buyPrice,sellPrice,buyTimestamp);
		this.authorName = authorName;
		this.singerName = singerName;
		this.dicsType = dicsType;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getDicsType() {
		return dicsType;
	}
	public void setDicsType(String dicsType) {
		this.dicsType = dicsType;
	}
	public static String genID() {
		String a = Integer.toString(++idNumber);
		StringBuilder build = new StringBuilder();
		build.append("MS");
		for(int i=0;i<8-a.length()-2;i++) {
			build.append("0");
		}
		build.append(a);
		return build.toString();
	}
}

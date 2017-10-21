package nhom1.Khai.pack;

public class MusicDisc extends Product{
	private String authorName;
	private String singerName;
	private String dicsType;
	public static int idNumber;
	public MusicDisc() {
		super();
	}
	
	public MusicDisc(String authorName, String singerName, String dicsType) {
		super();
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
	
}

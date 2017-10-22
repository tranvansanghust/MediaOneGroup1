package group1.khai.models;

public class MovieDisc extends Product {
	private String directorName;
	private String actorName;
	private String dicsType;
	public static int idNumber;
	public MovieDisc() {
		super();
	}

	public MovieDisc(String directorName, String actorName, String dicsType) {
		super();
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
package nhom1.Khai.pack;

public class MovieDisc extends Product {
	private String directorName;
	private String actorName;
	private int dicsType;

	public MovieDisc() {
		super();
	}

	public MovieDisc(String directorName, String actorName, int dicsType) {
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

	public int getDicsType() {
		return dicsType;
	}

	public void setDicsType(int dicsType) {
		this.dicsType = dicsType;
	}

}
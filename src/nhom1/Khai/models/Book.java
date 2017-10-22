package nhom1.khai.models;

public class Book extends Product{
	private String publishingCompany;
	private String authorName;
	private String bookType;
	public static int idNumber;
	public Book() {
		super();
	}
	public Book(String publishingCompany, String authorName, String bookType) {
		super();
		this.publishingCompany = publishingCompany;
		this.authorName = authorName;
		this.bookType = bookType;
	}
	public String getPublishingCompany() {
		return publishingCompany;
	}
	public String getAuthorName() {
		return authorName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
}

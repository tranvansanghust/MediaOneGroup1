package nhom1.Khai.pack;

public class Book extends Product{
	private String publishingCompany;
	private String authorName;
	private int bookType;
	public Book() {
		super();
	}
	public Book(String publishingCompany, String authorName, int bookType) {
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
	public int getBookType() {
		return bookType;
	}
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setBookType(int bookType) {
		this.bookType = bookType;
	}
	
}

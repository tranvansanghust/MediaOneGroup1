package group1.khai.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import group1.khai.models.Book;
import group1.khai.models.Customer;
import group1.khai.models.Employee;
import group1.khai.models.MovieDisc;
import group1.khai.models.MusicDisc;
import group1.khai.models.Product;

public class DBConnector {
	private Connection con;
	private ResultSet rs;
	private Statement stm;

	public Connection getCon() {
		return con;
	}

	public ResultSet getRs() {
		return rs;
	}

	public Statement getStm() {
		return stm;
	}

	public DBConnector() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mediaone"
							+ "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull",
					"root", "khailinh1997");
			stm = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean saveBook(Book book) {
		try {

			String query = "insert into Product(id,productName,productType,productQuota,"
					+ "buyPrice,sellPrice,buyTimestamp)" + "values ('" + book.getID() + "','" + book.getProductName()
					+ "','" + Product.BOOK + "','" + book.getProductQuota() + "','" + book.getBuyPrice() + "','"
					+ book.getSellPrice() + "','" + book.getBuyTimestamp() + "');";
			stm.executeUpdate(query);

			query = "insert into Book(ID,publishingCompany,authorName,bookType) values ('" + book.getID() + "','"
					+ book.getPublishingCompany() + "','" + book.getAuthorName() + "','" + book.getBookType() + "');";
			stm.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveMovieDisc(MovieDisc book) {
		try {

			String query = "insert into Product(id,productName,productType,productQuota,"
					+ "buyPrice,sellPrice,buyTimestamp)" + "values ('" + book.getID() + "','" + book.getProductName()
					+ "','" + Product.MOVIE_DISC + "','" + book.getProductQuota() + "','" + book.getBuyPrice() + "','"
					+ book.getSellPrice() + "','" + book.getBuyTimestamp() + "');";
			stm.executeUpdate(query);

			query = "insert into MovieDisc(ID,directorName,actorName,dicstype) values ('" + book.getID() + "','"
					+ book.getDirectorName() + "','" + book.getActorName() + "','" + book.getDicsType() + "');";
			stm.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveMusicDisc(MusicDisc book) {
		try {
			String query;

			query = "insert into Product(id,productName,productType,productQuota," + "buyPrice,sellPrice,buyTimestamp)"
					+ "values ('" + book.getID() + "','" + book.getProductName() + "','" + Product.BOOK + "','"
					+ book.getProductQuota() + "','" + book.getBuyPrice() + "','" + book.getSellPrice() + "','"
					+ book.getBuyTimestamp() + "');";
			stm.executeUpdate(query);

			query = "insert into MusicDisc(ID,authorName,singerName,dicstype) values ('" + book.getID() + "','"
					+ book.getAuthorName() + "','" + book.getSingerName() + "','" + book.getDicsType() + "');";
			stm.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee findEmployee(String id, String password) {
		try {
			String query = "select * from Human,Employee where Human.id = employee.id and Human.ID='" + id + "';";
			rs = stm.executeQuery(query);
			if (!rs.next())
				return null;
			if (!rs.getString("password").equals(password))
				return null;
			return new Employee(id, rs.getString("fullName"), rs.getString("telephoneNumber"), rs.getDouble("salary"),
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Book findBook(String ID) {
		try {
			String query = "select * from Book,Product where book.id=product.id and book.ID='" + ID + "';";
			rs = stm.executeQuery(query);
			if (!rs.next())
				return null;
			String iD = rs.getString("ID");
			String productName = rs.getString("productName");
			int productType = Product.BOOK;
			long productQuota = rs.getLong("productQuota");
			double buyPrice = rs.getDouble("buyPrice");
			double sellPrice = rs.getDouble("sellPrice");
			Timestamp buyTimestamp = rs.getTimestamp("buyTimestamp");
			String publishingCompany = rs.getString("publishingCompany");
			String authorName = rs.getString("authorName");
			String bookType = rs.getString("bookType");
			return new Book(iD, productName, productType, productQuota, buyPrice, sellPrice, buyTimestamp,
					publishingCompany, authorName, bookType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MovieDisc findMovieDisc(String ID) {
		try {
			String query = "select * from MovieDisc,product where product.id=moviedisc.id and product.ID='" + ID + "';";
			rs = stm.executeQuery(query);
			if (!rs.next())
				return null;
			String iD = rs.getString("ID");
			String productName = rs.getString("productName");
			int productType = Product.MOVIE_DISC;
			long productQuota = rs.getLong("productQuota");
			double buyPrice = rs.getDouble("buyPrice");
			double sellPrice = rs.getDouble("sellPrice");
			Timestamp buyTimestamp = rs.getTimestamp("buyTimestamp");
			String director = rs.getString("directorName");
			String actor = rs.getString("actorName");
			String dicsType = rs.getString("dicsType");
			return new MovieDisc(iD, productName, productType, productQuota, buyPrice, sellPrice, buyTimestamp,
					director, actor, dicsType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public MusicDisc findMusicDisc(String ID) {
		try {
			String query = "select * from MusicDisc,product where musicdisc.id=product.id and product.ID='" + ID + "';";
			rs = stm.executeQuery(query);
			if (!rs.next())
				return null;
			String iD = rs.getString("ID");
			String productName = rs.getString("productName");
			int productType = Product.MUSIC_DISC;
			long productQuota = rs.getLong("productQuota");
			double buyPrice = rs.getDouble("buyPrice");
			double sellPrice = rs.getDouble("sellPrice");
			Timestamp buyTimestamp = rs.getTimestamp("buyTimestamp");
			String author = rs.getString("authorName");
			String singer = rs.getString("singerName");
			String dicsType = rs.getString("dicsType");
			return new MusicDisc(iD, productName, productType, productQuota, buyPrice, sellPrice, buyTimestamp, author,
					singer, dicsType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> getAllBooks() {
		List<Book> result = new LinkedList<Book>();
		try {
			String query = "select * from book,product where book.id=product.id";
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String iD = rs.getString("ID");
				String productName = rs.getString("productName");
				int productType = Product.BOOK;
				long productQuota = rs.getLong("productQuota");
				double buyPrice = rs.getDouble("buyPrice");
				double sellPrice = rs.getDouble("sellPrice");
				Timestamp buyTimestamp = rs.getTimestamp("buyTimestamp");
				String publishingCompany = rs.getString("publishingCompany");
				String authorName = rs.getString("authorName");
				String bookType = rs.getString("bookType");
				result.add(new Book(iD, productName, productType, productQuota, buyPrice, sellPrice, buyTimestamp,
						publishingCompany, authorName, bookType));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MusicDisc> getAllMusicDiscs() {
		List<MusicDisc> result = new LinkedList<MusicDisc>();
		try {
			String query = "select * from musicdisc,product where musicdisc.id=product.id";
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String iD = rs.getString("ID");
				String productName = rs.getString("productName");
				int productType = Product.BOOK;
				long productQuota = rs.getLong("productQuota");
				double buyPrice = rs.getDouble("buyPrice");
				double sellPrice = rs.getDouble("sellPrice");
				Timestamp buyTimestamp = rs.getTimestamp("buyTimestamp");
				String authorName = rs.getString("authorName");
				String singerName = rs.getString("singerName");
				String dicsType = rs.getString("dicsType");
				result.add(new MusicDisc(iD, productName, productType, productQuota, buyPrice, sellPrice, buyTimestamp,
						authorName, singerName, dicsType));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MovieDisc> getAllMovieDiscs() {
		List<MovieDisc> result = new LinkedList<MovieDisc>();
		try {
			String query = "select * from MovieDisc,product where MovieDisc.id=product.id";
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String iD = rs.getString("ID");
				String productName = rs.getString("productName");
				int productType = Product.BOOK;
				long productQuota = rs.getLong("productQuota");
				double buyPrice = rs.getDouble("buyPrice");
				double sellPrice = rs.getDouble("sellPrice");
				Timestamp buyTimestamp = rs.getTimestamp("buyTimestamp");
				String directorName = rs.getString("directorName");
				String actorName = rs.getString("actorName");
				String dicsType = rs.getString("dicsType");
				result.add(new MovieDisc(iD, productName, productType, productQuota, buyPrice, sellPrice, buyTimestamp,
						directorName, actorName, dicsType));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> result = new LinkedList<Customer>();
		try {
			String query = "select * from Customer,human where Customer.id=human.id";
			rs = stm.executeQuery(query);
			while (rs.next()) {
				String iD = rs.getString("ID");
				String fullName = rs.getString("fullName");
				String telephoneNumber = rs.getString("telephoneNumber");
				double point = rs.getDouble("point");
				result.add(new Customer(iD, fullName, telephoneNumber, point));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deleteBook(String id) {
		try {
			String query = "delete from Book where id='" + id + "';";
			stm.executeUpdate(query);
			query = "delete from Product where id='" + id + "';";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMovieDisc(String id) {
		try {
			String query = "delete from MovieDisc where id='" + id + "';";
			stm.executeUpdate(query);
			query = "delete from Product where id='" + id + "';";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteMusicDisc(String id) {
		try {
			String query = "delete from MusicDisc where id='" + id + "';";
			stm.executeUpdate(query);
			query = "delete from Product where id='" + id + "';";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateBook(Book bk) {
		try {
			String query = "update Product set productName='" + bk.getProductName() + "',"
					+ " productQuota='"+bk.getProductQuota()+"',"
					+"  buyPrice="+bk.getBuyPrice()+","
					+" sellPrice="+bk.getSellPrice()+" where id='"+bk.getID()+"';";
			stm.executeUpdate(query);
			query = "update  Book "+"set publishingCompany='"+bk.getPublishingCompany()
			+"',authorName='"+bk.getAuthorName()+"'"+" where id='" + bk.getID() + "';";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateMovieDisc(MovieDisc bk) {
		try {
			String query = "update Product set productName='" + bk.getProductName() + "',"
					+ " productQuota='"+bk.getProductQuota()+"',"
					+"  buyPrice="+bk.getBuyPrice()+","
					+" sellPrice="+bk.getSellPrice()+" where id='"+bk.getID()+"';";
			stm.executeUpdate(query);
			query = "update  MovieDisc "+"set DirectorName='"+bk.getDirectorName()
			+"',actorName='"+bk.getActorName()+"'"+" where id='" + bk.getID() + "';";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateMusicDisc(MusicDisc bk) {
		try {
			String query = "update Product set productName='" + bk.getProductName() + "',"
					+ " productQuota='"+bk.getProductQuota()+"',"
					+"  buyPrice="+bk.getBuyPrice()+","
					+" sellPrice="+bk.getSellPrice()+" where id='"+bk.getID()+"';";
			stm.executeUpdate(query);
			query = "update  MusicDisc "+"set authorName='"+bk.getAuthorName()
			+"',singerName='"+bk.getSingerName()+"'"+" where id='" + bk.getID() + "';";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

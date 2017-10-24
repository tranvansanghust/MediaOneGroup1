package group1.appilication;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import group1.khai.book.controllers.AddBookController;
import group1.khai.book.controllers.DeleteBookController;
import group1.khai.book.controllers.EditBookController;
import group1.khai.db.DBConnector;
import group1.khai.fee.controllers.AddFeeController;
import group1.khai.fee.controllers.DeleteFeeController;
import group1.khai.fee.controllers.EditFeeController;
import group1.khai.fee.controllers.PaidFeeController;
import group1.khai.main.controllers.ChangeTableController;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Bill;
import group1.khai.models.Book;
import group1.khai.models.Customer;
import group1.khai.models.Employee;
import group1.khai.models.MovieDisc;
import group1.khai.models.MusicDisc;
import group1.khai.models.Paid;
import group1.khai.models.Store;
import group1.khai.moviedisc.controllers.AddMoviesController;
import group1.khai.moviedisc.controllers.DeleteMoviesController;
import group1.khai.moviedisc.controllers.EditMoviesController;
import group1.khai.musicdisc.controllers.AddMusicController;
import group1.khai.musicdisc.controllers.DeleteMusicController;
import group1.khai.musicdisc.controllers.EditMusicController;

public class App {
	public static void main(String[] args) {
		
		
		DBConnector db = new DBConnector();
		Store media = new Store("MediaOne", 100000000, db);
		initIO(media);
		MainFrame a = new MainFrame(new Employee("20151998","Nguyễn Bá Khải","01699417566",1000,"khailinh1997")
				, db,media);
		 /*			CHANGE MAINPANEL     		*/
		ChangeTableController changCon= new ChangeTableController(a,db);
		AddBookController addBookCon = new AddBookController(a, db, media);
		AddMoviesController addMoviCon = new AddMoviesController(a, db,media);
		AddMusicController addMusCon = new AddMusicController(a, db,media);
		AddFeeController addFeeCon = new AddFeeController(a, db,media);
		DeleteBookController deleBookCon = new DeleteBookController(a, db);
		DeleteMoviesController deleMCon = new DeleteMoviesController(a, db);
		DeleteMusicController deleMusCOn = new DeleteMusicController(a, db);
		DeleteFeeController delefeeCon = new DeleteFeeController(a, db,media);
		EditBookController editBookController = new EditBookController(a, db);
		EditMoviesController ediMovie = new EditMoviesController(a, db);
		EditMusicController editMusic = new EditMusicController(a, db);
		EditFeeController editFee = new EditFeeController(a, db);
		
		PaidFeeController paidCon = new PaidFeeController(a, db,media);
	}
	public static void initIO(Store store) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("data.dat"));
			Book.idNumber=in.readInt();
			MusicDisc.idNumber=in.readInt();
			MovieDisc.idNumber=in.readInt();
			Employee.idNumber=in.readInt();
			Customer.idNumber=in.readInt();
			Bill.idNumber=in.readInt();
			Paid.idNumber=in.readInt();
			store.setTotalMoney(in.readDouble());
			in.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

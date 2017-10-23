package group1.appilication;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import group1.khai.book.controllers.AddBookController;
import group1.khai.book.controllers.DeleteBookController;
import group1.khai.book.controllers.EditBookController;
import group1.khai.db.DBConnector;
import group1.khai.main.controllers.ChangeTableController;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Bill;
import group1.khai.models.Book;
import group1.khai.models.Customer;
import group1.khai.models.Employee;
import group1.khai.models.MovieDisc;
import group1.khai.models.MusicDisc;
import group1.khai.moviedisc.controllers.AddMoviesController;
import group1.khai.moviedisc.controllers.DeleteMoviesController;
import group1.khai.moviedisc.controllers.EditMoviesController;
import group1.khai.musicdisc.controllers.AddMusicController;
import group1.khai.musicdisc.controllers.DeleteMusicController;
import group1.khai.musicdisc.controllers.EditMusicController;

public class App {
	public static void main(String[] args) {
		initIO();
		DBConnector db = new DBConnector();
		MainFrame a = new MainFrame(new Employee("20151998","Nguyễn Bá Khải","01699417566",1000,"khailinh1997")
				, db);
		 /*			CHANGE MAINPANEL     		*/
		ChangeTableController changCon= new ChangeTableController(a,db);
		AddBookController addBookCon = new AddBookController(a, db);
		AddMoviesController addMoviCon = new AddMoviesController(a, db);
		AddMusicController addMusCon = new AddMusicController(a, db);
		DeleteBookController deleBookCon = new DeleteBookController(a, db);
		DeleteMoviesController deleMCon = new DeleteMoviesController(a, db);
		DeleteMusicController deleMusCOn = new DeleteMusicController(a, db);
		EditBookController editBookController = new EditBookController(a, db);
		EditMoviesController ediMovie = new EditMoviesController(a, db);
		EditMusicController editMusic = new EditMusicController(a, db);
		
	}
	public static void initIO() {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream("data.dat"));
			Book.idNumber=in.readInt();
			MusicDisc.idNumber=in.readInt();
			MovieDisc.idNumber=in.readInt();
			Employee.idNumber=in.readInt();
			Customer.idNumber=in.readInt();
			Bill.idNumber=in.readInt();
			in.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

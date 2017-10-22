package app;

import nhom1.khai.db.DBConnector;
import nhom1.khai.models.Store;

public class App {
	public static void main(String[] args) {
		DBConnector db = new DBConnector();
		Store khaiStore = new Store("MediaOne", 1000000, db);
		khaiStore.setStoreName("MediaOne");
		
	}
}

package group1.khai.main.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import group1.khai.book.controllers.AddBookController;
import group1.khai.book.view.FuncBookPanel;
import group1.khai.customer.view.FuncCusPanel;
import group1.khai.customer.view.TableCusPanel;
import group1.khai.db.DBConnector;
import group1.khai.employee.view.FuncEmployeePanel;
import group1.khai.employee.view.TableEmployeePanel;
import group1.khai.main.controllers.ChangeTableController;
import group1.khai.models.Employee;
import group1.khai.moviedisc.controllers.AddMoviesController;
import group1.khai.moviedisc.view.FuncMoviesPanel;
import group1.khai.musicdisc.controllers.AddMusicController;
import group1.khai.musicdisc.view.FuncMusicPanel;



@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	private TopInfoPanel topInfoPanel;
	private ChoicePanel  choicePanel;
	
	private TableCusPanel tableCusPanel;
	
	
	private FuncCusPanel funcCusPanel;
	private FuncBookPanel funcBookPanel;
	private FuncMoviesPanel funcMoviesPanel;
	private FuncMusicPanel funcMusicPanel;
	
	private TabbedProduct tabbedProduct;
	
	private JPanel mainPanel;
	private JPanel tablePanel;
	private JPanel funcPanel;
	private DBConnector  db;
	private Employee onlineEmp;
	public MainFrame(Employee emp,DBConnector db) {
		this.db=db;
		this.setOnlineEmp(emp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,600);
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		/* 			NORTH MAINFRAME			*/
		topInfoPanel 	= new TopInfoPanel(emp.getFullName(), db);
		
		/*			WEST MAINFRAME			*/
		choicePanel  = new ChoicePanel();
		
		
		
		/*			PANELS OF CUSTOMERS		*/
		tableCusPanel	= new TableCusPanel();
		funcCusPanel 	= new FuncCusPanel();
		
		/*			PANELS OF PRODUCTS		*/
		tabbedProduct	 = new TabbedProduct();
		
		/*			PANELS OF BOOKS		*/
		
		funcBookPanel 	 = new FuncBookPanel();
		
		
		/*			PANELS OF MOVIES		*/
	
		funcMoviesPanel 	= new FuncMoviesPanel();
		
		
		/*			PANELS OF MUSICS		*/
		
		funcMusicPanel 		= new FuncMusicPanel();
		
		
		add(topInfoPanel,BorderLayout.NORTH);
		add(choicePanel,BorderLayout.WEST);
		add(createMainPanel(),BorderLayout.CENTER);
		
		
		
		
		setVisible(true);
	}
	
	private JPanel createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(20,20));
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(tableCusPanel, BorderLayout.CENTER);
		
		funcPanel = new JPanel();
		funcPanel.setLayout(new BorderLayout());
		funcPanel.add(funcCusPanel, BorderLayout.CENTER);
		
		mainPanel.add(tablePanel,BorderLayout.SOUTH);
		mainPanel.add(funcPanel,BorderLayout.CENTER);
		
		return mainPanel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JPanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public JPanel getFuncPanel() {
		return funcPanel;
	}

	public void setFuncPanel(JPanel funcPanel) {
		this.funcPanel = funcPanel;
	}

	public DBConnector getDb() {
		return db;
	}

	public void setDb(DBConnector db) {
		this.db = db;
	}

	public TableCusPanel getTableCusPanel() {
		return tableCusPanel;
	}


	public void setTableCusPanel(TableCusPanel tableCusPanel) {
		this.tableCusPanel = tableCusPanel;
	}


	public FuncCusPanel getFuncCusPanel() {
		return funcCusPanel;
	}


	public void setFuncCusPanel(FuncCusPanel funcCusPanel) {
		this.funcCusPanel = funcCusPanel;
	}
	public TopInfoPanel getTopInfoPanel() {
		return topInfoPanel;
	}


	public void setTopInfoPanel(TopInfoPanel topInfoPanel) {
		this.topInfoPanel = topInfoPanel;
	}


	public TabbedProduct getTabbedProduct() {
		return tabbedProduct;
	}

	public void setTabbedProduct(TabbedProduct tabbedProduct) {
		this.tabbedProduct = tabbedProduct;
	}

	public ChoicePanel getChoicePanel() {
		return choicePanel;
	}


	public void setChoicePanel(ChoicePanel choicePanel) {
		this.choicePanel = choicePanel;
	}





	public FuncBookPanel getFuncBookPanel() {
		return funcBookPanel;
	}

	public void setFuncBookPanel(FuncBookPanel funcBookPanel) {
		this.funcBookPanel = funcBookPanel;
	}

	public FuncMoviesPanel getFuncMoviesPanel() {
		return funcMoviesPanel;
	}

	public void setFuncmoviesPanel(FuncMoviesPanel funcMoviesPanel) {
		this.funcMoviesPanel = funcMoviesPanel;
	}

	public FuncMusicPanel getFuncMusicPanel() {
		return funcMusicPanel;
	}

	public void setFuncMusicPanel(FuncMusicPanel funcMusicPanel) {
		this.funcMusicPanel = funcMusicPanel;
	}
	
	/**
	 * @return the onlineEmp
	 */
	public Employee getOnlineEmp() {
		return onlineEmp;
	}

	/**
	 * @param onlineEmp the onlineEmp to set
	 */
	public void setOnlineEmp(Employee onlineEmp) {
		this.onlineEmp = onlineEmp;
	}

	public static void main(String[] args) {
		DBConnector db = new DBConnector();
		MainFrame a = new MainFrame(new Employee("20151998","Nguyễn Bá Khải","01699417566",1000,"khailinh1997")
				, db);
		 /*			CHANGE MAINPANEL     		*/
		ChangeTableController changCon= new ChangeTableController(a,db);
		AddBookController addBookCon = new AddBookController(a, db);
		AddMoviesController addMoviCon = new AddMoviesController(a, db);
		AddMusicController addMusCon = new AddMusicController(a, db);
	}

}

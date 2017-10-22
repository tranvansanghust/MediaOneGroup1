package group1.khai.employee.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import group1.khai.db.DBConnector;




public class AddEmployeeView extends JDialog   {
	private static final int WARNING_MESSAGE = 0;
	private static final int INFORMATION_MESSAGE = 0;
	private JLabel lbID, lbHoTen, lbNgaySinh,   lbSDT, lbLuong,lbPassword;
	private JTextField tfID, tfHoTen, tfNgaySinh,  tfSDT, tfLuong,tfPassword;
	private JPanel p1, p2,p3;
	private JButton btnThem, btnHuy;
	private DBConnector db;
	private TableEmployeePanel tablePanel;
	
	public AddEmployeeView(DBConnector db, TableEmployeePanel tablePanel) {
		this.db = db;
		this.tablePanel=tablePanel;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		setTitle("Thêm nhân viên");

		lbID       = new JLabel("ID");
		lbHoTen    = new JLabel("Họ Tên");
		lbSDT      = new JLabel("SĐT");
		lbLuong    = new JLabel("Lương");
		lbPassword = new JLabel("Password");
		
		tfID       = new JTextField(15);
		tfHoTen    = new JTextField(15);
		tfSDT      = new JTextField(15);
		tfLuong    = new JTextField(15);
		tfPassword = new JTextField(15);
		
		btnThem    = new JButton("Thêm");		
		btnHuy     = new JButton("Hủy ");		
		
		
		
		
		p1 = new JPanel(); 
		p2 = new JPanel(); 
		p3 = new JPanel();
		
		p1.setLayout(new GridLayout(8, 1, 10, 10));		p1.setBorder(new EmptyBorder(10,10,10,10));
		p2.setLayout(new GridLayout(8, 1, 10, 10));		p2.setBorder(new EmptyBorder(10,10,10,10));
		p3.setLayout(new GridLayout(1, 2, 10, 10));		p3.setBorder(new EmptyBorder(10,10,10,10));
		
		p1.add(lbID);           p2.add(tfID);
		p1.add(lbHoTen);		p2.add(tfHoTen);	 
		p1.add(lbNgaySinh);		p2.add(tfNgaySinh);	

		p1.add(lbSDT);			p2.add(tfSDT);
		p1.add(lbLuong);		p2.add(tfLuong);

		p1.add(lbPassword);		p2.add(tfPassword);
		
		p3.add(btnThem);		p3.add(btnHuy);
		
		add(p1,BorderLayout.WEST);
		add(p3,BorderLayout.SOUTH);
		add(p2,BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}

	
	
	
	
}

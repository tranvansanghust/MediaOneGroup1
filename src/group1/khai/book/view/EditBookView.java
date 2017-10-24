package group1.khai.book.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import group1.khai.db.DBConnector;
import group1.khai.models.Book;




public class EditBookView extends JDialog  implements ActionListener{
	private static final int WARNING_MESSAGE = 0;
	private static final int INFORMATION_MESSAGE = 0;
	
	private JLabel 		 lbTenSP, lbSoLuong, lbGiaMua,lbTheLoai, lbGiaBan, lbNXB, lbTacGia;
	private JTextField 	 tfTenSP, tfSoLuong, tfGiaMua,tfTheLoai, tfGiaBan, tfNXB, tfTacGia;
	private JPanel p1, p2,p3;
	private JButton btnSua, btnHuy;
	private DBConnector db;
	private TableBookPanel tableBookPanel;
	private Book sach;
	
	public EditBookView(DBConnector db, TableBookPanel tableBookPanel,Book sach) {
		this.db = db;
		this.tableBookPanel=tableBookPanel;
		this.sach = sach;
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		setTitle("Sửa thông tin sách");

		lbTenSP    	= new JLabel("Tên sách");
		lbTheLoai    	= new JLabel("Thể loại");
		lbSoLuong 	= new JLabel("Số lượng");
		lbGiaMua 	= new JLabel("Giá mua");
		lbGiaBan 	= new JLabel("Giá bán");
		lbNXB   	= new JLabel("Nhà XB");
		lbTacGia    = new JLabel("Tác giả");
		
		
		tfTenSP    	= new JTextField(20); tfTenSP.setText(sach.getProductName());
		tfSoLuong 	= new JTextField(20); tfSoLuong.setText(Long.toString(sach.getProductQuota()));
		tfGiaMua   	= new JTextField(20); tfGiaMua.setText(Double.toString(sach.getBuyPrice()));
		tfGiaBan    = new JTextField(20); tfGiaBan.setText(Double.toString(sach.getSellPrice()));
		tfNXB   	= new JTextField(20); tfNXB.setText(sach.getPublishingCompany());
		tfTacGia    = new JTextField(20); tfTacGia.setText(sach.getAuthorName());
		tfTheLoai = new JTextField(20); tfTheLoai.setText(sach.getBookType());
		
		btnSua    = new JButton("SỬA");		btnSua.addActionListener(this);
		btnHuy     = new JButton("HỦY ");	btnHuy.addActionListener(this);
		
		
		
		
		p1 = new JPanel(); 
		p2 = new JPanel(); 
		p3 = new JPanel();
		
		p1.setLayout(new GridLayout(8, 1, 10, 10));		p1.setBorder(new EmptyBorder(10,10,10,10));
		p2.setLayout(new GridLayout(8, 1, 10, 10));		p2.setBorder(new EmptyBorder(10,10,10,10));
		p3.setLayout(new GridLayout(1, 2, 10, 10));		p3.setBorder(new EmptyBorder(10,10,10,10));
		
		p1.add(lbTenSP);		p2.add(tfTenSP);
		p1.add(lbNXB);			p2.add(tfNXB);
		p1.add(lbTacGia);		p2.add(tfTacGia);
		p1.add(lbTheLoai);		p2.add(tfTheLoai);
		p1.add(lbSoLuong);		p2.add(tfSoLuong);	
		p1.add(lbGiaMua);		p2.add(tfGiaMua);	 
		p1.add(lbGiaBan);		p2.add(tfGiaBan);	
		
		
		
		p3.add(btnSua);		p3.add(btnHuy);
		
		add(p1,BorderLayout.WEST);
		add(p3,BorderLayout.SOUTH);
		add(p2,BorderLayout.CENTER);
		
		
		
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnHuy) {
			this.dispose();
		}
		else if(e.getSource()==btnSua) {
			if(tfTenSP.getText().equals(null) || tfTenSP.getText().equals("") ||
					tfSoLuong.getText().equals(null) || tfSoLuong.getText().equals("") ||
					tfTacGia.getText().equals(null) || tfTacGia.getText().equals("") ||
					tfNXB.getText().equals(null) || tfNXB.getText().equals("") ||
					tfGiaMua.getText().equals(null) || tfGiaMua.getText().equals("") ||
					tfTheLoai.getText().equals(null) || tfTheLoai.getText().equals("") ||
					tfGiaBan.getText().equals(null) || tfGiaBan.getText().equals("") )
			{
				JOptionPane.showMessageDialog(null, "Các trường dữ liệu không được để trống","Cảnh báo",JOptionPane.WARNING_MESSAGE);
			}
			else if(sach.getProductName().equals(tfTenSP.getText())&&sach.getProductQuota()==Long.parseLong(tfSoLuong.getText())
					&&sach.getBuyPrice()==Double.parseDouble(tfGiaMua.getText())
					&&sach.getSellPrice()==Double.parseDouble(tfGiaBan.getText())
					&&sach.getPublishingCompany().equals(tfNXB.getText())
					&&sach.getBookType().equals(tfTheLoai.getText())
					&&sach.getAuthorName().equals(tfTacGia.getText())) {
				JOptionPane.showMessageDialog(null, "Chưa thay đổi");
			}
			else {
				sach.setProductName(tfTenSP.getText());
				sach.setProductQuota(Long.parseLong(tfSoLuong.getText()));
				sach.setBuyPrice(Double.parseDouble(tfGiaMua.getText()));
				sach.setSellPrice(Double.parseDouble(tfGiaBan.getText()));
				sach.setPublishingCompany(tfNXB.getText());
				sach.setAuthorName(tfTacGia.getText());
				sach.setBookType(tfTheLoai.getText());
				db.updateBook(sach);
				this.dispose();
				List<Book> list = db.getAllBooks(tableBookPanel.getCurrentPage());
				tableBookPanel.updateTable(list);
			}
		}
		
	}

	
}

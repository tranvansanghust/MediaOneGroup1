package group1.khai.musicdisc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.MusicDisc;
import group1.khai.models.Product;
import group1.khai.models.Store;


public class AddMusicView extends JDialog  implements ActionListener{

	
	private JLabel 	 lbTenSP, lbSoLuong, lbGiaMua,lbTheLoai, lbGiaBan, lbtacgia, lbCaSi;
	private JTextField 	tfTenSP, tfSoLuong, tfGiaMua,tfTheLoai, tfGiaBan, tftacgia, tfCaSi;
	private JPanel p1, p2,p3;
	private JButton btnThem, btnHuy;
	private DBConnector db;
	private TableMusicPanel tableMusicPanel;
	private Store store;
	private MainFrame mainFrame;
	public AddMusicView(DBConnector db,MainFrame main, TableMusicPanel tableMusicPanel,Store store) {
		this.db = db;
		this.tableMusicPanel=tableMusicPanel;
		this.store=store;
		this.mainFrame=main;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		setTitle("Thêm Đĩa Nhạc");

		lbTenSP    	= new JLabel("Tên đĩa nhạc");
		lbSoLuong 	= new JLabel("Số lượng");
		lbGiaMua 	= new JLabel("Giá mua");
		lbGiaBan 	= new JLabel("Giá bán");
		lbtacgia   	= new JLabel("Tác giả");
		lbCaSi    = new JLabel("Ca sĩ");
		lbTheLoai = new JLabel("Thể loại");
		
		tfTenSP    	= new JTextField(20);
		tfSoLuong 	= new JTextField(20);
		tfGiaMua   	= new JTextField(20);
		tfGiaBan    = new JTextField(20);
		tftacgia   	= new JTextField(20);
		tfCaSi    = new JTextField(20);
		tfTheLoai = new JTextField(20);
		

		btnThem    = new JButton("Thêm");		btnThem.addActionListener(this);
		btnHuy     = new JButton("Hủy ");	btnHuy.addActionListener(this);
		
		
		
		p1 = new JPanel(); 
		p2 = new JPanel(); 
		p3 = new JPanel();
		
		p1.setLayout(new GridLayout(8, 1, 10, 10));		p1.setBorder(new EmptyBorder(10,10,10,10));
		p2.setLayout(new GridLayout(8, 1, 10, 10));		p2.setBorder(new EmptyBorder(10,10,10,10));
		p3.setLayout(new GridLayout(1, 2, 10, 10));		p3.setBorder(new EmptyBorder(10,10,10,10));
		
		p1.add(lbTenSP);		p2.add(tfTenSP);
		p1.add(lbtacgia);			p2.add(tftacgia);
		p1.add(lbCaSi);		p2.add(tfCaSi);
		p1.add(lbTheLoai);		p2.add(tfTheLoai);
		p1.add(lbSoLuong);		p2.add(tfSoLuong);	
		p1.add(lbGiaMua);		p2.add(tfGiaMua);	 
		p1.add(lbGiaBan);		p2.add(tfGiaBan);	
		
		
		p3.add(btnThem);		p3.add(btnHuy);
		
		add(p1,BorderLayout.WEST);
		add(p3,BorderLayout.SOUTH);
		add(p2,BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnHuy) {
			dispose();
		}
		if (e.getSource() == btnThem) {
			DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
			
			if(checkFormat() == true){
			
				
				try {
					String tensp 	= tfTenSP.getText();
					int soluong 	= Integer.parseInt(tfSoLuong.getText());
					double giamua 	= Double.parseDouble(tfGiaMua.getText());
					double giaban 	= Double.parseDouble(tfGiaBan.getText());
					Date time = new Date();
					Timestamp buytime = new Timestamp(time.getYear(), time.getMonth(), time.getDate(), time.getHours(), time.getMinutes(), time.getSeconds(), 0);
					String tacgia 		= tftacgia.getText();
					String casi = tfCaSi.getText();
					String theloai =tfTheLoai.getText();
					
					MusicDisc sach = new MusicDisc(MusicDisc.genID(),tensp,Product.BOOK,soluong,giamua,giaban,buytime,tacgia,casi,theloai);
					
					db.saveMusicDisc(sach);
					store.setTotalMoney(store.getTotalMoney()-giamua*soluong);
					
					mainFrame.getTopInfoPanel().getLbTotalMoney().setText(format.format(store.getTotalMoney()).toString());
					dispose();
					
					List<MusicDisc> list = db.getAllMusicDiscs(tableMusicPanel.getCurrentPage());
					tableMusicPanel.updateTable(list);
					JOptionPane.showMessageDialog(null, "Thêm đĩa thành công");
					
					 
				} catch (Exception e1) {
				
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}
	

	
	private boolean checkFormat(){
		if(tfTenSP.getText().equals(null) || tfTenSP.getText().equals("") ||
				tfSoLuong.getText().equals(null) || tfSoLuong.getText().equals("") ||
				tfCaSi.getText().equals(null) || tfCaSi.getText().equals("") ||
				tftacgia.getText().equals(null) || tftacgia.getText().equals("") ||
				tfGiaMua.getText().equals(null) || tfGiaMua.getText().equals("") ||
				tfTheLoai.getText().equals(null) || tfTheLoai.getText().equals("") ||
				tfGiaBan.getText().equals(null) || tfGiaBan.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Các trường dữ liệu không được để trống","Cảnh báo",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if( Long.parseLong(tfGiaMua.getText()) <0 ||
				 Long.parseLong(tfGiaMua.getText()) <0 ||
				 Integer.parseInt(tfSoLuong.getText()) < 0
				){
			
			JOptionPane.showMessageDialog(null, "Số lượng, giá mua và giá bán phải lớn hơn 0","Cảnh báo",0);
			return false;
		}
		return true;
	}
	
	
}

package group1.khai.musicdisc.view;

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
import group1.khai.models.MovieDisc;
import group1.khai.models.MusicDisc;


public class EditMusicView extends JDialog  implements ActionListener{

	
	private JLabel 		 lbTenSP, lbSoLuong, lbGiaMua,lbTheLoai, lbGiaBan, lbTacGia, lbCaSi;
	private JTextField 	 tfTenSP, tfSoLuong, tfGiaMua,tfTheLoai, tfGiaBan, tfTacGia, tfCaSi;
	private JPanel p1, p2,p3;
	private JButton btnSua, btnHuy;
	private DBConnector db;
	private TableMusicPanel tableMusicPanel;
	private MusicDisc dianhac;
	public EditMusicView(DBConnector db, TableMusicPanel tableMusicPanel, MusicDisc dianhac) {
		this.db = db;
		this.tableMusicPanel=tableMusicPanel;
		this.dianhac = dianhac;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		setTitle("Sửa thông tin đĩa nhạc");

		lbTenSP    	= new JLabel("Tên đĩa nhạc");
		lbSoLuong 	= new JLabel("Số lượng");
		lbGiaMua 	= new JLabel("Giá mua");
		lbGiaBan 	= new JLabel("Giá bán");
		lbTheLoai = new JLabel("Thể Loại");
		lbTacGia   	= new JLabel("Tác giả");
		lbCaSi    = new JLabel("Ca sĩ");
		
		

		tfTenSP    	= new JTextField(20); tfTenSP.setText(dianhac.getProductName());
		tfSoLuong 	= new JTextField(20); tfSoLuong.setText(Long.toString(dianhac.getProductQuota()));
		tfGiaMua   	= new JTextField(20); tfGiaMua.setText(Double.toString(dianhac.getBuyPrice()));
		tfGiaBan    = new JTextField(20); tfGiaBan.setText(Double.toString(dianhac.getSellPrice()));
		tfCaSi   	= new JTextField(20); tfCaSi.setText(dianhac.getSingerName());
		tfTacGia    = new JTextField(20); tfTacGia.setText(dianhac.getAuthorName());
		tfTheLoai = new JTextField(20); tfTheLoai.setText(dianhac.getDicsType());
		
		btnSua    = new JButton("Thêm");		btnSua.addActionListener(this);
		btnHuy     = new JButton("Hủy ");		btnHuy.addActionListener(this);
		
		
		
		
		p1 = new JPanel(); 
		p2 = new JPanel(); 
		p3 = new JPanel();
		
		p1.setLayout(new GridLayout(8, 1, 10, 10));		p1.setBorder(new EmptyBorder(10,10,10,10));
		p2.setLayout(new GridLayout(8, 1, 10, 10));		p2.setBorder(new EmptyBorder(10,10,10,10));
		p3.setLayout(new GridLayout(1, 2, 10, 10));		p3.setBorder(new EmptyBorder(10,10,10,10));
		
	
		p1.add(lbTenSP);		p2.add(tfTenSP);
		p1.add(lbTacGia);			p2.add(tfTacGia);
		p1.add(lbCaSi);		p2.add(tfCaSi);
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
					tfCaSi.getText().equals(null) || tfCaSi.getText().equals("") ||
					tfTheLoai.getText().equals(null) || tfTheLoai.getText().equals("") ||
					tfGiaMua.getText().equals(null) || tfGiaMua.getText().equals("") ||
					tfGiaBan.getText().equals(null) || tfGiaBan.getText().equals("") )
			{
				JOptionPane.showMessageDialog(null, "Các trường dữ liệu không được để trống","Cảnh báo",JOptionPane.WARNING_MESSAGE);
			}
			else if(dianhac.getProductName().equals(tfTenSP.getText())&&dianhac.getProductQuota()==Long.parseLong(tfSoLuong.getText())
					&&dianhac.getBuyPrice()==Double.parseDouble(tfGiaMua.getText())
					&&dianhac.getSellPrice()==Double.parseDouble(tfGiaBan.getText())
					&&dianhac.getAuthorName().equals(tfTacGia.getText())
					&&dianhac.getDicsType().equals(tfTheLoai.getText())
					&&dianhac.getSingerName().equals(tfCaSi.getText())) {
				JOptionPane.showMessageDialog(null, "Chưa thay đổi");
			}
			else {
				dianhac.setProductName(tfTenSP.getText());
				dianhac.setProductQuota(Long.parseLong(tfSoLuong.getText()));
				dianhac.setBuyPrice(Double.parseDouble(tfGiaMua.getText()));
				dianhac.setSellPrice(Double.parseDouble(tfGiaBan.getText()));
				dianhac.setAuthorName(tfTacGia.getText());
				dianhac.setSingerName(tfCaSi.getText());
				dianhac.setDicsType(tfTheLoai.getText());
				db.updateMusicDisc(dianhac);
				this.dispose();
				List<MusicDisc> list = db.getAllMusicDiscs(tableMusicPanel.getCurrentPage());
				tableMusicPanel.updateTable(list);
			}
		}
		
	}
	
	
}
package group1.khai.fee.view;

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
import group1.khai.models.Fee;




public class EditFeeView extends JDialog  implements ActionListener{
	private static final int WARNING_MESSAGE = 0;
	private static final int INFORMATION_MESSAGE = 0;
	
	private JLabel 		 lbTenChiPhi, lbGiatri, lbChuKy;
	private JTextField 	 tfTenChiPhi, tfGiatri, tfChuKy;
	private JPanel p1, p2,p3;
	private JButton btnSua, btnHuy;
	private DBConnector db;
	private TableFeePanel tableFeePanel;
	private Fee fee;
	
	public EditFeeView(DBConnector db, TableFeePanel tableFeePanel,Fee fee) {
		this.db = db;
		this.tableFeePanel=tableFeePanel;
		this.fee = fee;
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		setTitle("Sửa thông tin chi phí");

		lbTenChiPhi    	= new JLabel("Tên chi phí");
		lbGiatri 	= new JLabel("Giá trị");
		lbChuKy 	= new JLabel("Chu kỳ");
		
		
		tfTenChiPhi    	= new JTextField(20); tfTenChiPhi.setText(fee.getFeeName());
		tfGiatri 	= new JTextField(20); tfGiatri.setText(Double.toString(fee.getFeeValue()));
		tfChuKy   	= new JTextField(20); tfChuKy.setText(Integer.toString(fee.getFeeCycle()));
		
		
		btnSua    = new JButton("SỬA");		btnSua.addActionListener(this);
		btnHuy     = new JButton("HỦY ");	btnHuy.addActionListener(this);
		
		
		
		
		p1 = new JPanel(); 
		p2 = new JPanel(); 
		p3 = new JPanel();
		
		p1.setLayout(new GridLayout(8, 1, 10, 10));		p1.setBorder(new EmptyBorder(10,10,10,10));
		p2.setLayout(new GridLayout(8, 1, 10, 10));		p2.setBorder(new EmptyBorder(10,10,10,10));
		p3.setLayout(new GridLayout(1, 2, 10, 10));		p3.setBorder(new EmptyBorder(10,10,10,10));
		
		p1.add(lbTenChiPhi);		p2.add(tfTenChiPhi);
		p1.add(lbGiatri);			p2.add(tfGiatri);
		p1.add(lbChuKy);		p2.add(tfChuKy);
	

		
		
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
			if(tfTenChiPhi.getText().equals(null) || tfTenChiPhi.getText().equals("") ||
					tfGiatri.getText().equals(null) || tfGiatri.getText().equals("") ||
					tfChuKy.getText().equals(null) || tfChuKy.getText().equals(""))

			{
				JOptionPane.showMessageDialog(null, "Các trường dữ liệu không được để trống","Cảnh báo",JOptionPane.WARNING_MESSAGE);
			}
			else if(fee.getFeeName().equals(tfTenChiPhi.getText())
					&&fee.getFeeValue()==Double.parseDouble(tfGiatri.getText())
					&&fee.getFeeCycle()==Integer.parseInt(tfChuKy.getText())
				) 
			{
				JOptionPane.showMessageDialog(null, "Chưa thay đổi");
			}
			else {
				fee.setFeeName(tfTenChiPhi.getText());
				fee.setFeeValue(Double.parseDouble(tfGiatri.getText()));
				fee.setFeeCycle(Integer.parseInt(tfChuKy.getText()));
				db.updateFee(fee);
				this.dispose();
				List<Fee> list = db.getAllFees();
				tableFeePanel.updateTable(list);
			}
		}
		
	}

	
}

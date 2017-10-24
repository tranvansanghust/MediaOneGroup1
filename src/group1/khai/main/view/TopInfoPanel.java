package group1.khai.main.view;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import group1.khai.db.DBConnector;
import group1.khai.models.Store;

@SuppressWarnings("serial")
public class TopInfoPanel extends JPanel{
	private JLabel lbUser,lbTableName,lbTotalMoney;
	public TopInfoPanel(String fullName,DBConnector db,Store store) {
		setLayout(new BorderLayout(10,10));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		setSize(990,30);
		lbUser = new JLabel("Nhân Viên: "+fullName);
		lbUser.setHorizontalAlignment(JLabel.CENTER);
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		lbTotalMoney = new JLabel(format.format(store.getTotalMoney()).toString());
		
		
		add(lbUser,BorderLayout.WEST);
		add(lbTotalMoney,BorderLayout.CENTER);
		
		
	}

	public JLabel getLbUser() {
		return lbUser;
	}

	public void setLbUser(JLabel lbUser) {
		this.lbUser = lbUser;
	}

	public JLabel getLbTableName() {
		return lbTableName;
	}

	public void setLbTableName(JLabel lbTableName) {
		this.lbTableName = lbTableName;
	}

	public JLabel getLbTotalMoney() {
		return lbTotalMoney;
	}

	public void setLbTotalMoney(JLabel lbTotalMoney) {
		this.lbTotalMoney = lbTotalMoney;
	}

}

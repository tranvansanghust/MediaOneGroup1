package group1.khai.main.view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import group1.khai.db.DBConnector;

@SuppressWarnings("serial")
public class TopInfoPanel extends JPanel{
	private JLabel lbUser,lbTableName;
	public TopInfoPanel(String fullName,DBConnector db) {
		setLayout(new BorderLayout(10,10));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		setSize(990,30);
		lbUser = new JLabel("Nhân Viên: "+fullName);
		lbUser.setHorizontalAlignment(JLabel.CENTER);
	
		
		
		add(lbUser,BorderLayout.WEST);
		
		
		add(new JLabel("Type:  Quan ly"),BorderLayout.CENTER);
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

}

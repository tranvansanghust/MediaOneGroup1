package group1.khai.fee.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.fee.view.AddFeeView;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Store;

public class AddFeeController {
	private JButton btnThem;
	private TableFeePanel tableFeePanel;
	
	public AddFeeController(MainFrame mainFrame,DBConnector db,Store store) {
		btnThem = mainFrame.getFuncfeePanel().getBtnThem();
		tableFeePanel = mainFrame.getTableFeePanel();
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFeeView(db,mainFrame, tableFeePanel,store);
				
			}
		});
	}
}

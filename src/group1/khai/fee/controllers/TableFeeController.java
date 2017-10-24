package group1.khai.fee.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Fee;

public class TableFeeController {
	private JButton btNext,btBack;
	private TableFeePanel taFeePanel;
	public TableFeeController(MainFrame mainFrame,DBConnector db) {
		taFeePanel=mainFrame.getTableFeePanel();
		btNext =taFeePanel.getBtNext();
		btBack =taFeePanel.getBtBack();
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =taFeePanel.getCurrentPage();
				if(page>0) {
					page=page-1;
					taFeePanel.setCurrentPage(page);
					List<Fee> list = db.getAllFees(page);
					taFeePanel.updateTable(list);
				}
				
			}
		});
		btNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =taFeePanel.getCurrentPage();
				if(page<db.getMaxID("fee")/50) {
					page=page+1;
					taFeePanel.setCurrentPage(page);
					List<Fee> list = db.getAllFees(page);
					taFeePanel.updateTable(list);
				}
				
			}
		});
	}
}

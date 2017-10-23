package group1.khai.fee.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.fee.view.PaidFeeView;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Paid;
import group1.khai.models.Store;

public class PaidFeeController {
	private JButton btnThanhToan;
	private TableFeePanel tableFeePanel;

	public PaidFeeController(MainFrame mainFrame, DBConnector db,Store store) {
		btnThanhToan = mainFrame.getFuncfeePanel().getBtnThanhToan();
		tableFeePanel = mainFrame.getTableFeePanel();

		btnThanhToan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Paid> list = db.getAllUnPaid();
				PaidFeeView paidFeeView=new PaidFeeView(db, tableFeePanel,store);
				paidFeeView.updateTable(list);
			}
		});
	}
}

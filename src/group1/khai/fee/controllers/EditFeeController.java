package group1.khai.fee.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.book.view.EditBookView;
import group1.khai.db.DBConnector;
import group1.khai.fee.view.EditFeeView;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Fee;

public class EditFeeController {
	private JButton btnSua;
	private TableFeePanel tableFeePanel;

	public EditFeeController(MainFrame mainFrame, DBConnector db) {
		btnSua = mainFrame.getFuncfeePanel().getBtnSua();
		tableFeePanel = mainFrame.getTableFeePanel();

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = tableFeePanel.getTable().getSelectedRow();

				// if a row is chosen
				if (index >= 0) {
					String name = tableFeePanel.getTable().getModel().getValueAt(index, 0).toString();

					Fee fee = db.findFee(name);
					new EditFeeView(db, tableFeePanel, fee);
				} else {

					JOptionPane.showMessageDialog(null, "Vui lòng chọn sách cần sửa !", "Thông báo",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});
	}
}

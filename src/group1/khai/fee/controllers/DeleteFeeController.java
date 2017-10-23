package group1.khai.fee.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.db.DBConnector;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Fee;
import group1.khai.models.Store;

public class DeleteFeeController {
	private JButton btnXoa;
	private TableFeePanel tableFeePanel;
	
	public DeleteFeeController(MainFrame mainFrame,DBConnector db,Store store) {
		btnXoa = mainFrame.getFuncfeePanel().getBtnXoa();
		tableFeePanel = mainFrame.getTableFeePanel();
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableFeePanel.getTable().getSelectedRow();
				
				if(index >=0) {
					String ten = tableFeePanel.getTable().getModel().getValueAt(index, 0).toString();
					int a =JOptionPane.showConfirmDialog(tableFeePanel, "Bạn muốn xóa chi phí '"+ten+"'?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.YES_OPTION) {
						db.deleteFee(ten);
						List<Fee> list = db.getAllFees();
						store.setCostList(list);
						tableFeePanel.updateTable(list);
						JOptionPane.showMessageDialog(null, "Xóa sách thành công");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sách cần xóa !","Thông báo",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
	}
}

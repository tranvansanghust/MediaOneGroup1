package group1.khai.book.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.book.view.TableBookPanel;
import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Book;

public class DeleteBookController {
	private JButton btnXoa;
	private TableBookPanel tableBookPanel;
	
	public DeleteBookController(MainFrame mainFrame,DBConnector db) {
		btnXoa = mainFrame.getFuncBookPanel().getBtnXoa();
		tableBookPanel = mainFrame.getTabbedProduct().getTableBookPanel();
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableBookPanel.getTable().getSelectedRow();
				
				if(index >=0) {
					String id = tableBookPanel.getTable().getModel().getValueAt(index, 0).toString();
					int a =JOptionPane.showConfirmDialog(tableBookPanel, "Bạn muốn xóa sách mã '"+id+"'?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
					if(a==JOptionPane.YES_OPTION) {
						db.deleteBook(id);
						List<Book> list = db.getAllBooks();
						tableBookPanel.updateTable(list);
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

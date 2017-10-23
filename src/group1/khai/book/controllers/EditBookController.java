package group1.khai.book.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.book.view.EditBookView;
import group1.khai.book.view.TableBookPanel;
import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Book;

public class EditBookController {
	private JButton btnSua;
	private TableBookPanel tableBookPanel;

	public EditBookController(MainFrame mainFrame, DBConnector db) {
		btnSua = mainFrame.getFuncBookPanel().getBtnSua();
		tableBookPanel = mainFrame.getTabbedProduct().getTableBookPanel();

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = tableBookPanel.getTable().getSelectedRow();

				// if a row is chosen
				if (index >= 0) {
					String id = tableBookPanel.getTable().getModel().getValueAt(index, 0).toString();

					Book sach = db.findBook(id);
					new EditBookView(db, tableBookPanel, sach);
				} else {

					JOptionPane.showMessageDialog(null, "Vui lòng chọn sách cần sửa !", "Thông báo",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});
	}
}

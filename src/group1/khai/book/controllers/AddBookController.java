package group1.khai.book.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import group1.khai.book.view.AddBookView;
import group1.khai.book.view.TableBookPanel;
import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Store;

public class AddBookController {
	private JButton btnThem;
	private TableBookPanel tableBookPanel;
	
	public AddBookController(MainFrame mainFrame,DBConnector db,Store store) {
		btnThem = mainFrame.getFuncBookPanel().getBtnThem();
		tableBookPanel = mainFrame.getTabbedProduct().getTableBookPanel();
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookView(db,mainFrame, tableBookPanel, store);
				
			}
		});
	}
}

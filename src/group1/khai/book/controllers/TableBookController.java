package group1.khai.book.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import group1.khai.book.view.TableBookPanel;
import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Book;

public class TableBookController {
	private JButton btNext,btBack;
	private TableBookPanel tableBookPanel;
	public TableBookController(MainFrame mainFrame,DBConnector db) {
		tableBookPanel=mainFrame.getTabbedProduct().getTableBookPanel();
		btNext =tableBookPanel.getBtNext();
		btBack =tableBookPanel.getBtBack();
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =tableBookPanel.getCurrentPage();
				if(page>0) {
					page=page-1;
					tableBookPanel.setCurrentPage(page);
					List<Book> list = db.getAllBooks(page);
					tableBookPanel.updateTable(list);
				}
				
			}
		});
		btNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =tableBookPanel.getCurrentPage();
				if(page<db.getMaxID("book")/50) {
					page=page+1;
					tableBookPanel.setCurrentPage(page);
					List<Book> list = db.getAllBooks(page);
					tableBookPanel.updateTable(list);
				}
				
			}
		});
	}
}

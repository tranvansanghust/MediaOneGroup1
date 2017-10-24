package group1.khai.moviedisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Store;
import group1.khai.moviedisc.view.AddMoviesView;
import group1.khai.moviedisc.view.TableMoviesPanel;

public class AddMoviesController {
	private JButton btnThem;
	private TableMoviesPanel tableMoviesPanel;
	
	public AddMoviesController(MainFrame mainFrame,DBConnector db,Store store) {
		btnThem = mainFrame.getFuncMoviesPanel().getBtnThem();
		tableMoviesPanel = mainFrame.getTabbedProduct().getTableMoviesPanel();
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new AddMoviesView(db,mainFrame, tableMoviesPanel,store);
				
			}
		});
	}
}

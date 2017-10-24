package group1.khai.moviedisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Fee;
import group1.khai.models.MovieDisc;
import group1.khai.moviedisc.view.TableMoviesPanel;

public class TableMovieDiscController {
	private JButton btNext,btBack;
	private TableMoviesPanel tableMoviesPanel;
	public TableMovieDiscController(MainFrame mainFrame,DBConnector db) {
		tableMoviesPanel=mainFrame.getTabbedProduct().getTableMoviesPanel();
		btNext =tableMoviesPanel.getBtNext();
		btBack =tableMoviesPanel.getBtBack();
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =tableMoviesPanel.getCurrentPage();
				if(page>0) {
					page=page-1;
					tableMoviesPanel.setCurrentPage(page);
					List<MovieDisc> list = db.getAllMovieDiscs(page);
					tableMoviesPanel.updateTable(list);
				}
				
			}
		});
		btNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =tableMoviesPanel.getCurrentPage();
				if(page<db.getMaxID("moviedisc")/50) {
					page=page+1;
					tableMoviesPanel.setCurrentPage(page);
					List<MovieDisc> list = db.getAllMovieDiscs(page);
					tableMoviesPanel.updateTable(list);
				}
				
			}
		});
	}
}

package group1.khai.musicdisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Fee;
import group1.khai.models.MovieDisc;
import group1.khai.models.MusicDisc;
import group1.khai.moviedisc.view.TableMoviesPanel;
import group1.khai.musicdisc.view.TableMusicPanel;

public class TableMusicDiscController {
	private JButton btNext,btBack;
	private TableMusicPanel tableMusicPanel;
	public TableMusicDiscController(MainFrame mainFrame,DBConnector db) {
		tableMusicPanel=mainFrame.getTabbedProduct().getTableMusicPanel();
		btNext =tableMusicPanel.getBtNext();
		btBack =tableMusicPanel.getBtBack();
		btBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =tableMusicPanel.getCurrentPage();
				if(page>0) {
					page=page-1;
					tableMusicPanel.setCurrentPage(page);
					List<MusicDisc> list = db.getAllMusicDiscs(page);
					tableMusicPanel.updateTable(list);
				}
				
			}
		});
		btNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int page =tableMusicPanel.getCurrentPage();
				if(page<db.getMaxID("musicdisc")/50) {
					page=page+1;
					tableMusicPanel.setCurrentPage(page);
					List<MusicDisc> list = db.getAllMusicDiscs(page);
					tableMusicPanel.updateTable(list);
				}
				
			}
		});
	}
}

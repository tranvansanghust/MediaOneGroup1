package group1.khai.musicdisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Store;
import group1.khai.musicdisc.view.AddMusicView;
import group1.khai.musicdisc.view.TableMusicPanel;

public class AddMusicController {
	private JButton btnThem;
	private TableMusicPanel tableMusicPanel;
	
	public AddMusicController(MainFrame mainFrame,DBConnector db,Store store) {
		btnThem = mainFrame.getFuncMusicPanel().getBtnThem();
		tableMusicPanel = mainFrame.getTabbedProduct().getTableMusicPanel();
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new AddMusicView(db,mainFrame, tableMusicPanel,store);
				
			}
		});
	}
}

package group1.khai.main.view;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import group1.khai.book.view.TableBookPanel;
import group1.khai.moviedisc.view.TableMoviesPanel;
import group1.khai.musicdisc.view.TableMusicPanel;

@SuppressWarnings("serial")
public class TabbedProduct extends JTabbedPane {
	private TableBookPanel tableBookPanel;
	private TableMoviesPanel tableMoviesPanel; 
	private TableMusicPanel tableMusicPanel;
	
	public TabbedProduct() {
		setPreferredSize(new Dimension(500, 440));
		tableBookPanel = new TableBookPanel();
		tableMoviesPanel = new TableMoviesPanel();
		tableMusicPanel = new TableMusicPanel();
		
		
		addTab("Sách", tableBookPanel);
		addTab("Đĩa phim",tableMoviesPanel);
		addTab("Đĩa nhạc",tableMusicPanel);
		
		
	}

	public TableBookPanel getTableBookPanel() {
		return tableBookPanel;
	}

	public void setTableBookPanel(TableBookPanel tableBookPanel) {
		this.tableBookPanel = tableBookPanel;
	}

	public TableMoviesPanel getTableMoviesPanel() {
		return tableMoviesPanel;
	}

	public void setTableMoviesPanel(TableMoviesPanel tableMoviesPanel) {
		this.tableMoviesPanel = tableMoviesPanel;
	}

	public TableMusicPanel getTableMusicPanel() {
		return tableMusicPanel;
	}

	public void setTableMusicPanel(TableMusicPanel tableMusicPanel) {
		this.tableMusicPanel = tableMusicPanel;
	}
	
}

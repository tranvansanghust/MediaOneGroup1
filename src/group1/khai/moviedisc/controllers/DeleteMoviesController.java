package group1.khai.moviedisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.MovieDisc;
import group1.khai.moviedisc.view.TableMoviesPanel;

public class DeleteMoviesController {
	private JButton btnXoa;
	private TableMoviesPanel tableMoviesPanel;
	
	public DeleteMoviesController(MainFrame mainFrame,DBConnector db) {
		btnXoa = mainFrame.getFuncMoviesPanel().getBtnXoa();
		tableMoviesPanel = mainFrame.getTabbedProduct().getTableMoviesPanel();
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableMoviesPanel.getTable().getSelectedRow();
				
				if(index >=0) {
					String id = tableMoviesPanel.getTable().getModel().getValueAt(index, 0).toString();
					int a=JOptionPane.showConfirmDialog(tableMoviesPanel, "Bạn muốn xóa đĩa phim mã '"+id+"'?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
					if(JOptionPane.YES_OPTION==a) {
						db.deleteMovieDisc(id);
						List<MovieDisc> list = db.getAllMovieDiscs();
						tableMoviesPanel.updateTable(list);
						JOptionPane.showMessageDialog(null, "Xóa đĩa phim thành công");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn đĩa phim cần xóa !","Thông báo",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
	}
}

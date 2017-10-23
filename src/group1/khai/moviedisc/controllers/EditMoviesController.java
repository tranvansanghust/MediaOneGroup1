package group1.khai.moviedisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.MovieDisc;
import group1.khai.moviedisc.view.EditMoviesView;
import group1.khai.moviedisc.view.TableMoviesPanel;

public class EditMoviesController {
	private JButton btnSua;
	private TableMoviesPanel tableMoviescPanel;

	public EditMoviesController(MainFrame mainFrame, DBConnector db) {
		btnSua = mainFrame.getFuncMoviesPanel().getBtnSua();
		tableMoviescPanel = mainFrame.getTabbedProduct().getTableMoviesPanel();

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = tableMoviescPanel.getTable().getSelectedRow();

				// if a row is chosen
				if (index >= 0) {
					String id = tableMoviescPanel.getTable().getModel().getValueAt(index, 0).toString();

					MovieDisc diaphim = db.findMovieDisc(id);
					new EditMoviesView(db, tableMoviescPanel, diaphim);
				} else {

					JOptionPane.showMessageDialog(null, "Vui lòng chọn đĩa phim cần sửa !", "Thông báo",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});
	}
}

package group1.khai.musicdisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.MusicDisc;
import group1.khai.musicdisc.view.EditMusicView;
import group1.khai.musicdisc.view.TableMusicPanel;

public class EditMusicController {
	private JButton btnSua;
	private TableMusicPanel tableMusicPanel;

	public EditMusicController(MainFrame mainFrame, DBConnector db) {
		btnSua = mainFrame.getFuncMusicPanel().getBtnSua();
		tableMusicPanel = mainFrame.getTabbedProduct().getTableMusicPanel();

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int index = tableMusicPanel.getTable().getSelectedRow();

				// if a row is chosen
				if (index >= 0) {
					String id = tableMusicPanel.getTable().getModel().getValueAt(index, 0).toString();

					MusicDisc dianhac = db.findMusicDisc(id);
					new EditMusicView(db, tableMusicPanel, dianhac);
				} else {

					JOptionPane.showMessageDialog(null, "Vui lòng chọn sách cần sửa !", "Thông báo",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});
	}
}

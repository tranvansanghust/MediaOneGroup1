package group1.khai.musicdisc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.MusicDisc;
import group1.khai.musicdisc.view.TableMusicPanel;

public class DeleteMusicController {
	private JButton btnXoa;
	private TableMusicPanel tableMusicPanel;
	
	public DeleteMusicController(MainFrame mainFrame,DBConnector db) {
		btnXoa = mainFrame.getFuncMusicPanel().getBtnXoa();
		tableMusicPanel = mainFrame.getTabbedProduct().getTableMusicPanel();
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableMusicPanel.getTable().getSelectedRow();
				
				if(index >=0) {
					String id = tableMusicPanel.getTable().getModel().getValueAt(index, 0).toString();
					int a=JOptionPane.showConfirmDialog(tableMusicPanel, "Bạn muốn xóa dĩa nhạc mã '"+id+"'?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
					if(JOptionPane.YES_OPTION==a) {
						db.deleteMusicDisc(id);
						List<MusicDisc> list = db.getAllMusicDiscs();
						tableMusicPanel.updateTable(list);
						JOptionPane.showMessageDialog(null, "Xóa đĩa nhạc thành công");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn đĩa nhạc cần xóa !","Thông báo",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
	}
}

package group1.khai.musicdisc.view;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import group1.khai.models.MusicDisc;

@SuppressWarnings("serial")
public class TableMusicPanel extends JPanel{
	private JTable table;
	private JScrollPane scroll;
	private JButton btNext,btBack;
	private int currentPage;
	private String[] columns = { "ID", "Tên đĩa nhạc", "Tác giả", "Ca sĩ","Thể loại", "Số lượng tồn kho", "giá mua","giá bán","ngày nhập hàng cuối" };

	public TableMusicPanel() {
		setLayout(new BorderLayout(10, 0));
		// setBorder(BorderFactory.createEtcheBorder(EtchedBorder.RAISED));
		// setBorder(BorderFactory.createEtchedBorder());
		
		
		
		
		// create table
		table = new JTable();
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		loadData(table);

		// add table to scroll
		scroll = new JScrollPane();
		// scroll.setPreferredSize();
		scroll.setViewportView(table);
		//add(namePanel(),BorderLayout.PAGE_START);
		add(scroll, BorderLayout.CENTER);
		
		//bt
		btNext = new JButton("Trang sau");
		btBack = new JButton("Trang trước");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(btNext,BorderLayout.EAST);
		panel.add(btBack,BorderLayout.WEST);
		
		add(panel,BorderLayout.SOUTH);
	}

//	public JPanel createTablePanel() {
//		
//		panel.add(scroll, BorderLayout.CENTER);
//		return panel;
//
//	}
	
	private void loadData(JTable table) {
		String[][] data = null;

		DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.setModel(tableModel);

	}
	


	public void updateTable(List<MusicDisc> list){
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		String[][] data =  new String[list.size()][columns.length];
		for(int i=0;i<list.size();i++){
			MusicDisc s = list.get(i);
			data[i][0] = s.getID();
			data[i][1] = s.getProductName();
			data[i][2] = s.getAuthorName();
			data[i][3] = s.getSingerName();
			data[i][4]=s.getDicsType();
			data[i][5] = Long.toString(s.getProductQuota());
			data[i][6] = format.format(s.getBuyPrice()).toString();
			data[i][7] = format.format(s.getSellPrice()).toString();
			data[i][8] = s.getBuyTimestamp().toString();
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
		
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public String[] getColumns() {
		return columns;
	}

	public void setColumns(String[] columns) {
		this.columns = columns;
	}

	public JButton getBtNext() {
		return btNext;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setBtNext(JButton btNext) {
		this.btNext = btNext;
	}

	public JButton getBtBack() {
		return btBack;
	}

	public void setBtBack(JButton btBack) {
		this.btBack = btBack;
	}
	
}

package group1.khai.moviedisc.view;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import group1.khai.models.MovieDisc;

@SuppressWarnings("serial")
public class TableMoviesPanel extends JPanel{
	private JTable table;
	private JScrollPane scroll;

	private String[] columns = { "ID", "Tên đĩa phim", "Đạo diễn", "Diễn viên", "Số lượng tồn kho", "giá mua","giá bán","ngày nhập hàng cuối" };

	public TableMoviesPanel() {
		setLayout(new BorderLayout(10, 0));
		// setBorder(BorderFactory.createEtcheBorder(EtchedBorder.RAISED));
		// setBorder(BorderFactory.createEtchedBorder());
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		
		
		
		// create table
		table = new JTable();
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		loadData(table);

		// add table to scroll
		scroll = new JScrollPane();
		
		scroll.setViewportView(table);
		
		add(scroll, BorderLayout.CENTER);
		
	}

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
	

	public void updateTable(List<MovieDisc> list){
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		String[][] data =  new String[list.size()][columns.length];
		for(int i=0;i<list.size();i++){
			MovieDisc s = list.get(i);
			data[i][0] = s.getID();
			data[i][1] = s.getProductName();
			data[i][2] = s.getDirectorName();
			data[i][3] = s.getActorName();
			data[i][4] = Long.toString(s.getProductQuota());
			data[i][5] = format.format(s.getBuyPrice()).toString();
			data[i][6] = format.format(s.getSellPrice()).toString();
			data[i][7] = s.getBuyTimestamp().toString();
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
}

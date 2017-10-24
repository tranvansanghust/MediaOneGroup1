package group1.khai.fee.view;

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

import group1.khai.models.Fee;



@SuppressWarnings("serial")
public class TableFeePanel extends JPanel{
	private JTable table;
	private JScrollPane scroll;
	private JButton btNext,btBack;
	private int currentPage;
	private String[] columns =   {"Tên chi phí", "Giá trị", "Chu kỳ","Lần trả gần nhất" };

	public TableFeePanel() {
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
		scroll.setViewportView(table);
		
		add(scroll, BorderLayout.CENTER);
		//bt
		btNext = new JButton("Trang sau");
		btBack = new JButton("Trang trước");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(btNext,BorderLayout.EAST);
		panel.add(btBack,BorderLayout.WEST);
		
		add(panel,BorderLayout.SOUTH);
		
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
	
	public void updateTable(List<Fee> list){
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		String[][] data =  new String[list.size()][columns.length];
		
		for(int i=0;i<list.size();i++){
			Fee s = list.get(i);
			data[i][0] = s.getFeeName();
			data[i][1] = format.format(s.getFeeValue()).toString();
			data[i][2] = Integer.toString(s.getFeeCycle());
			data[i][3] = s.getLastRequest().toString();
		
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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

package nhom1.Khai.View.Employee;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import nhom1.Khai.model.Employee;


@SuppressWarnings("serial")
public class TableEmployeePanel extends JPanel {
	private JTable table;
	private JLabel lbName;
	private JScrollPane scroll;

	private String[] columns = { "ID", "Họ tên", "Số điện thoại", "Lương" };

	public TableEmployeePanel() {
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
		// scroll.setPreferredSize();
		scroll.setViewportView(table);
		add(namePanel(),BorderLayout.PAGE_START);
		add(scroll, BorderLayout.CENTER);
		
	}

//	public JPanel createTablePanel() {
//		
//		panel.add(scroll, BorderLayout.CENTER);
//		return panel;
//
//	}
	
	private JPanel namePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(""));
		//create label
				lbName = new JLabel("DANH SÁCH NHÂN VIÊN");
				lbName.setHorizontalAlignment(JLabel.CENTER);
			panel.add(lbName,BorderLayout.CENTER);
			
			return panel;
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

	public void updateTable(List<Employee> list){
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi","VN"));
		String[][] data =  new String[list.size()][columns.length];
		for(int i=0;i<list.size();i++){
			Employee nv = list.get(i);
			data[i][0] 	= nv.getID();
			data[i][1] 	= nv.getFullName();
			data[i][2] 	= nv.getTelephoneNumber();
			data[i][3] 	= format.format(nv.getSalary()).toString();
	
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

package group1.khai.fee.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import group1.khai.db.DBConnector;
import group1.khai.main.view.MainFrame;
import group1.khai.models.Fee;
import group1.khai.models.Paid;
import group1.khai.models.Store;

public class PaidFeeView extends JDialog implements ActionListener {
	private Store store;
	private JButton bnThanhToan;
	private DBConnector db;
	private TableFeePanel tablefeePanel;
	private JTable table;
	private JScrollPane scroll;
	private JButton btNext, btBack;
	private MainFrame mainFrame;
	private String[] columns = { "ID", "Tên chi phí", "Giá trị", "Ngày yêu cầu", "Ngày thanh toán", "Trạng thái" };
	private int currentPage;
	public PaidFeeView(DBConnector db, MainFrame main, TableFeePanel tableFeePanel, Store store) {
		this.db = db;
		this.store = store;
		this.tablefeePanel = tableFeePanel;
		this.mainFrame = main;
		setSize(1000, 600);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Các chi phí");
		setLayout(new BorderLayout(10, 0));
		// setBorder(BorderFactory.createEtcheBorder(EtchedBorder.RAISED));
		// setBorder(BorderFactory.createEtchedBorder());
		table = new JTable();
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loadData(table);

		// add table to scroll
		scroll = new JScrollPane();
		scroll.setViewportView(table);

		// bt
		btNext = new JButton("Trang sau");
		btBack = new JButton("Trang trước");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(btNext, BorderLayout.EAST);
		panel.add(btBack, BorderLayout.WEST);
		bnThanhToan = new JButton("Thanh Toán");
		bnThanhToan.addActionListener(this);
		panel.add(bnThanhToan, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);

		add(scroll, BorderLayout.CENTER);
		setVisible(true);
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

	public void updateTable(List<Paid> list) {
		DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi", "VN"));
		String[][] data = new String[list.size()][columns.length];

		for (int i = 0; i < list.size(); i++) {
			Paid s = list.get(i);
			data[i][0] = s.getID();
			data[i][1] = s.getFeeName();
			data[i][2] = format.format(s.getFeeValue()).toString();
			data[i][3] = s.getRequestTime().toString();
			if (s.getPaidTime() == null) {
				data[i][4] = "null";
			} else
				data[i][4] = s.getPaidTime().toString();
			data[i][5] = Boolean.toString(s.isPaid());

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btBack) {
			if(currentPage>0) {
				currentPage--;
				List<Paid> list = db.getAllUnPaid(currentPage);
				updateTable(list);
			}
		}
		else if(e.getSource()==btNext) {
			if(currentPage<db.getMaxID("paid")/50) {
				currentPage++;
				List<Paid> list = db.getAllUnPaid(currentPage);
				updateTable(list);
			}
		}
		else if (e.getSource() == bnThanhToan) {
			int index = this.getTable().getSelectedRow();

			if (index >= 0) {
				String id = this.getTable().getModel().getValueAt(index, 0).toString();
				int a = JOptionPane.showConfirmDialog(this, "Bạn muốn thanh toán chi phí với id: '" + id + "'?",
						"Cảnh báo", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					Paid paid = db.findPaid(id);
					db.paidPaid(paid);
					store.setTotalMoney(store.getTotalMoney() - paid.getFeeValue());
					DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(new Locale("vi", "VN"));
					mainFrame.getTopInfoPanel().getLbTotalMoney()
							.setText(format.format(store.getTotalMoney()).toString());
					List<Paid> list = db.getAllUnPaid(tablefeePanel.getCurrentPage());
					this.updateTable(list);
					JOptionPane.showMessageDialog(null, "Thanh toán thành công");

				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn chi phí cần thanh toán !", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public JButton getBnThanhToan() {
		return bnThanhToan;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setBnThanhToan(JButton bnThanhToan) {
		this.bnThanhToan = bnThanhToan;
	}

	public DBConnector getDb() {
		return db;
	}

	public void setDb(DBConnector db) {
		this.db = db;
	}

	public TableFeePanel getTablefeePanel() {
		return tablefeePanel;
	}

	public void setTablefeePanel(TableFeePanel tablefeePanel) {
		this.tablefeePanel = tablefeePanel;
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

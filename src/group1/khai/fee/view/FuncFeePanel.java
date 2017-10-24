package group1.khai.fee.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class FuncFeePanel extends JPanel implements ActionListener{
	private JButton btnThanhToan;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTimKiem;
	private JTextField tfSearch;
	private String[] s =  {"Tên chi phí", "Giá trị", "Chu kỳ" };
	private JComboBox<String> cbType ;
	
	
	public FuncFeePanel() {
	
		setLayout(new BorderLayout(10,10));
		setBorder(BorderFactory.createTitledBorder("Chức năng"));
		add(createSearchPanel(),BorderLayout.NORTH);
		add(createActionPanel(),BorderLayout.CENTER);
	}
	
	

	private JPanel createSearchPanel() {
		btnTimKiem  = createButtons("TÌM KIẾM");
		cbType = new JComboBox<>(s);
		tfSearch = new JTextField(30);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(20,0));
		
		JPanel panelBtn = new JPanel();
		panelBtn.setLayout(new BorderLayout(20,0));
		
		panelBtn.add(new JLabel("Tìm kiếm theo:"),BorderLayout.WEST);
		panelBtn.add(cbType,BorderLayout.CENTER);
		panelBtn.add(btnTimKiem,BorderLayout.EAST);
		
		panel.add(new JLabel("Ô tìm kiếm:"),BorderLayout.WEST);
		panel.add(tfSearch, BorderLayout.CENTER);
		panel.add(panelBtn,BorderLayout.EAST);
		return panel;
	}
	
	private JPanel createActionPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4, 10, 10));
		
		btnThanhToan = createButtons("CÁC CHI PHÍ CẦN THANH TOÁN");
		btnThem     = createButtons("THÊM");
		btnSua      = createButtons("SỬA");
		btnXoa      = createButtons("XÓA");
		
		
		panel.add(btnThem);
		panel.add(btnSua);
		panel.add(btnXoa);
		panel.add(btnThanhToan);
		
		return panel;
	}
	
	public JButton createButtons(String name){
		JButton button = new JButton(name);
		button.addActionListener(this);
		return button;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	


	public JButton getBtnThanhToan() {
		return btnThanhToan;
	}



	public void setBtnThanhToan(JButton btnThanhToan) {
		this.btnThanhToan = btnThanhToan;
	}



	public JButton getBtnThem() {
		return btnThem;
	}


	public void setBtnThem(JButton btnThem) {
		this.btnThem = btnThem;
	}


	public JButton getBtnSua() {
		return btnSua;
	}


	public void setBtnSua(JButton btnSua) {
		this.btnSua = btnSua;
	}


	public JButton getBtnXoa() {
		return btnXoa;
	}


	public void setBtnXoa(JButton btnXoa) {
		this.btnXoa = btnXoa;
	}


	public JButton getBtnTimKiem() {
		return btnTimKiem;
	}


	public void setBtnTimKiem(JButton btnTimKiem) {
		this.btnTimKiem = btnTimKiem;
	}


	public JTextField getTfSearch() {
		return tfSearch;
	}


	public void setTfSearch(JTextField tfSearch) {
		this.tfSearch = tfSearch;
	}



	public JComboBox<String> getCbType() {
		return cbType;
	}


	public void setCbType(JComboBox<String> cbType) {
		this.cbType = cbType;
	}
	
}

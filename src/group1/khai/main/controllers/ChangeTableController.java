package group1.khai.main.controllers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import group1.khai.book.view.FuncBookPanel;
import group1.khai.book.view.TableBookPanel;
import group1.khai.customer.view.FuncCusPanel;
import group1.khai.customer.view.TableCusPanel;
import group1.khai.db.DBConnector;
import group1.khai.fee.view.FuncFeePanel;
import group1.khai.fee.view.TableFeePanel;
import group1.khai.main.view.MainFrame;
import group1.khai.main.view.TabbedProduct;
import group1.khai.models.Book;
import group1.khai.models.Customer;
import group1.khai.models.Fee;
import group1.khai.models.MovieDisc;
import group1.khai.models.MusicDisc;
import group1.khai.moviedisc.view.FuncMoviesPanel;
import group1.khai.moviedisc.view.TableMoviesPanel;
import group1.khai.musicdisc.view.FuncMusicPanel;
import group1.khai.musicdisc.view.TableMusicPanel;


public class ChangeTableController {
	
	private FuncCusPanel 	funcCusPanel;
	private FuncBookPanel 	funcBookPanel;
	private FuncMoviesPanel funcMoviesPanel;
	private FuncMusicPanel 	funcMusicPanel;
	private FuncFeePanel funcFeePanel;
	
	private TableCusPanel 		tableCusPanel;
	private TabbedProduct 		tabbedProduct;
	private TableBookPanel 		tableBookPanel;
	private TableMoviesPanel 	tableMoviesPanel;
	private TableMusicPanel 	tableMusicPanel;
	private TableFeePanel tableFeePanel;
	
	private JButton btnCus;
	private JButton btnProduct;
	private JButton btnFee;
	
	public ChangeTableController(MainFrame mainFrame,DBConnector db) {
		btnCus 		= mainFrame.getChoicePanel().getBtnKhachHang();
		btnProduct 	= mainFrame.getChoicePanel().getBtnSanPham();
		btnFee = mainFrame.getChoicePanel().getBtnChiPhi();
		
		funcCusPanel 	= mainFrame.getFuncCusPanel();
		funcBookPanel 	= mainFrame.getFuncBookPanel();
		funcMoviesPanel = mainFrame.getFuncMoviesPanel();
		funcMusicPanel 	= mainFrame.getFuncMusicPanel();
		funcFeePanel = mainFrame.getFuncfeePanel();
		
		
		tableCusPanel 	= mainFrame.getTableCusPanel();
		tabbedProduct 	= mainFrame.getTabbedProduct();
		tableFeePanel = mainFrame.getTableFeePanel();
		
		tableBookPanel 		= mainFrame.getTabbedProduct().getTableBookPanel();
		tableMoviesPanel 	= mainFrame.getTabbedProduct().getTableMoviesPanel();
		tableMusicPanel 	= mainFrame.getTabbedProduct().getTableMusicPanel();
		
		
		JPanel funcPanel 	= mainFrame.getFuncPanel();
		JPanel tablePanel 	= mainFrame.getTablePanel();
		
		
		btnCus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.remove(tablePanel.getComponent(0));
				tablePanel.add(tableCusPanel, BorderLayout.CENTER);
				tablePanel.revalidate();
				tablePanel.repaint();
				
				funcPanel.remove(funcPanel.getComponent(0));
				funcPanel.add(funcCusPanel, BorderLayout.CENTER);
				funcPanel.revalidate();
				funcPanel.repaint();
				
				List<Customer > list = db.getAllCustomers();
				tableCusPanel.updateTable(list);
			}
		});
		
		btnProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.remove(tablePanel.getComponent(0));
				tablePanel.add(tabbedProduct, BorderLayout.CENTER);
				tablePanel.revalidate();
				tablePanel.repaint();

				if (tabbedProduct.getSelectedIndex() == 0) {
					funcPanel.remove(funcPanel.getComponent(0));
					funcPanel.add(funcBookPanel, BorderLayout.CENTER);
					funcPanel.revalidate();
					funcPanel.repaint();

				}

				else if (tabbedProduct.getSelectedIndex() == 1) {
					funcPanel.remove(funcPanel.getComponent(0));
					funcPanel.add(funcMoviesPanel, BorderLayout.CENTER);
					funcPanel.revalidate();
					funcPanel.repaint();

				} else if (tabbedProduct.getSelectedIndex() == 2) {
					funcPanel.remove(funcPanel.getComponent(0));
					funcPanel.add(funcMusicPanel, BorderLayout.CENTER);
					funcPanel.revalidate();

				}

				List<Book> list = db.getAllBooks();
				tableBookPanel.updateTable(list);

			}
		});
		btnFee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tablePanel.remove(tablePanel.getComponent(0));
				tablePanel.add(tableFeePanel, BorderLayout.CENTER);
				tablePanel.revalidate();
				tablePanel.repaint();

				funcPanel.remove(funcPanel.getComponent(0));
				funcPanel.add(funcFeePanel, BorderLayout.CENTER);
				funcPanel.revalidate();
				funcPanel.repaint();
				
				List<Fee > list = db.getAllFees();
				tableFeePanel.updateTable(list);

			}
		});
		
		tabbedProduct.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            if(tabbedProduct.getSelectedIndex() == 0) {
	            	funcPanel.remove(funcPanel.getComponent(0));
					funcPanel.add(funcBookPanel, BorderLayout.CENTER);
					funcPanel.revalidate();
					funcPanel.repaint();
	            }
	            else if(tabbedProduct.getSelectedIndex() == 1) {
	            	funcPanel.remove(funcPanel.getComponent(0));
					funcPanel.add(funcMoviesPanel, BorderLayout.CENTER);
					funcPanel.revalidate();
					funcPanel.repaint();
					
					List<MovieDisc > list1 = db.getAllMovieDiscs();
					tableMoviesPanel.updateTable(list1);
	            }
	            else if(tabbedProduct.getSelectedIndex() == 2) {
	            	funcPanel.remove(funcPanel.getComponent(0));
					funcPanel.add(funcMusicPanel, BorderLayout.CENTER);
					funcPanel.revalidate();
					funcPanel.repaint();
					
					List<MusicDisc > list2 = db.getAllMusicDiscs();
					tableMusicPanel.updateTable(list2);
	            }
	        }
	    });
	}
}

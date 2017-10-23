package group1.khai.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.swing.Timer;

import group1.khai.db.DBConnector;

public class Store {
	private String storeName;
	private double totalMoney;
	private List<Fee> costList;
	private DBConnector dbconnector;
	public Store(String storeName, double totalMoney, DBConnector dbconnector) {
		this.storeName = storeName;
		this.totalMoney = totalMoney;
		this.costList = dbconnector.getAllFees();
		this.dbconnector = new DBConnector();
		
		Date time = new Date();
		Timestamp now = new Timestamp(time.getYear(), time.getMonth(), time.getDate(), time.getHours(), time.getMinutes(), time.getSeconds(), 0);
		for(Fee fe:costList) {
			Timestamp last = fe.getLastRequest();
			int day=(now.getYear()-last.getYear())*360+(now.getMonth()-last.getMonth()*30+now.getDate()-last.getDate());
			int count = day/fe.getFeeCycle();
			for(int i=0;i<count;i++) {
				dbconnector.savePaid(new Paid(Paid.genID(), fe.getFeeName(), false, fe.getFeeValue(), now, null));
				fe.setLastRequest(now);
				dbconnector.updateFee(fe);
			}
		}
		Timer timer = new Timer(86400 ,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date time = new Date();
				Timestamp now = new Timestamp(time.getYear(), time.getMonth(), time.getDate(), time.getHours(), time.getMinutes(), time.getSeconds(), 0);
				for(Fee fe:costList) {
					Timestamp last = fe.getLastRequest();
					int day=(now.getYear()-last.getYear())*360+(now.getMonth()-last.getMonth()*30+now.getDate()-last.getDate());
					int count = day/fe.getFeeCycle();
					for(int i=0;i<count;i++) {
						dbconnector.savePaid(new Paid(Paid.genID(), fe.getFeeName(), false, fe.getFeeValue(), now, null));
						fe.setLastRequest(now);
						dbconnector.updateFee(fe);
					}
				}
				
			}
		});
		timer.start();
	}
	/**
	 * add cost to costlist
	 * @param cost
	 * @return true if success else false
	 */
	public boolean addCost(Fee cost) {
		if(cost!=null) {
			costList.add(cost);
			return true;
		}
		return false;
	}
	/**
	 * remove cost by reference
	 * @param cost
	 * @return true true if success else false 
	 */
	public boolean removeCost(Fee cost) {
		return this.costList.remove(cost);
	}
	/**
	 * remove cost by index 
	 * @param index index of cost in list
	 * @return true if success else false
	 */
	public boolean removeCost(int index) {
		if(this.costList.remove(index)==null) return false;
		return true;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public List<Fee> getCostList() {
		return costList;
	}
	public void setCostList(List<Fee> costList) {
		this.costList = costList;
	}
	public DBConnector getDbconnector() {
		return dbconnector;
	}
	
	
}

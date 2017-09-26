package model;

import java.util.Date;

import org.hibernate.Session;

import model.misc.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//stock 
		Stock stock = new Stock();
		stock.setStockCode("7052");
		stock.setStockName("hTC");
		session.save(stock);
		
		// stockDailyRecord
		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("2.2"));
		stockDailyRecords.setPriceClose(new Float("2.1"));
		stockDailyRecords.setPriceChange(new Float("10.2"));
		stockDailyRecords.setVolume(600);
		stockDailyRecords.setDate(new Date());
		stockDailyRecords.setStock(stock);
		stock.getStockDailyRecords().add(stockDailyRecords);
		session.save(stockDailyRecords);
		session.getTransaction().commit();
		
	}

}

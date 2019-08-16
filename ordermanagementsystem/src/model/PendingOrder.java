package model;

public class PendingOrder {
	
	int ordercode;
	int totalprice;
	int paidamount;
	int dueamount;
	String deliverydate;
	
	public PendingOrder(int ordercode,int totalprice,int paidamount,int dueamount,String deliverydate) {
		this.ordercode=ordercode;
		this.totalprice=totalprice;
		this.paidamount=paidamount;
		this.dueamount=dueamount;
		this.deliverydate=deliverydate;
	}

	public int getOrdercode() {
		return ordercode;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public int getPaidamount() {
		return paidamount;
	}

	public int getDueamount() {
		return dueamount;
	}

	public String getProductdetail() {
		return deliverydate;
	}

}

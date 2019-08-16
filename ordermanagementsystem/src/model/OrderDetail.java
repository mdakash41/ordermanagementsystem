package model;

public class OrderDetail {
	
	int orderCode,productid,price;
	long customerNumber;
	String orderDate,deliveryDate,deliverd;
	
	public OrderDetail(int orderCode,int productid,long customerNumber,String orderDate,String deliveryDate, String deliverd,int price) {
	this.orderCode=orderCode;
	this.productid=productid;
	this.customerNumber=customerNumber;
	this.orderDate=orderDate;
	this.deliveryDate=deliveryDate;
	this.deliverd=deliverd;
	this.price=price;
	}

	public int getOrderCode() {
		return orderCode;
	}


	public int getPrice() {
		return price;
	}

	public int getProductid() {
		return productid;
	}

	public long getCustomerNumber() {
		return customerNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public String isDeliverd() {
		return deliverd;
	}
	

}

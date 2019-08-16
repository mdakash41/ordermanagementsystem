package model;

public class ProductDetail {
	
	int productserial;
	String brand ;
	String productmodel ;
	String producttype;
	String productdetail;
	
	public ProductDetail(int serial,String brand,String modle,String ptype,String detail) {
		this.productserial=serial;
		this.brand=brand;
		this.productmodel=modle;
		this.producttype=ptype;
		this.productdetail=detail;
	}

	public int getProductserial() {
		return productserial;
	}

	public String getBrand() {
		return brand;
	}

	public String getProductmodel() {
		return productmodel;
	}

	public String getProducttype() {
		return producttype;
	}

	public String getProductdetail() {
		return productdetail;
	}

}

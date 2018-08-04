package com.java.parser;

public class ParserVO {
	//날짜	종가	전일비	시가	고가	저가	거래량
	private String date; // 날짜
	private String endPrice; // 종가
	private String startPrice; // 시가
	private String upDownPrice; //전일비
	private String maxPrice; // 고가
	private String minPrice; // 저가
	private String tansaction; // 거래량
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}
	public String getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(String stratPrice) {
		this.startPrice = stratPrice;
	}
	public String getUpDownSize() {
		return upDownPrice;
	}
	public void setUpDownSize(String upDownSize) {
		this.upDownPrice = upDownSize;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public String getTansaction() {
		return tansaction;
	}
	public void setTansaction(String tansaction) {
		this.tansaction = tansaction;
	}
	
	
	
}

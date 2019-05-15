package com.mnq;

public class ClientInfo {
	
	private String country;
	private String city;
	private String gender;
	private String currency;
	private Double averageIncome;
	
	public ClientInfo() {
		
	}
	
	public ClientInfo(String country, String city,  String gender, String currency, Double averageIncome) {
		super();
		this.country = country;
		this.city = city;
		this.gender = gender;
		this.currency = currency;
		this.averageIncome = averageIncome;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(Double averageIncome) {
		this.averageIncome = averageIncome;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ClientInfo [country=" + country + ", city=" + city + ", gender=" + gender + ", currency=" + currency
				+ ", averageIncome=" + averageIncome + "]";
	}
	
}

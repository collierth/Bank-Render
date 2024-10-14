package com.fdmgroup.bankUserStories.geoCoder;

public class Standard 
{
	private String city;
    private String prov;
     
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	@Override
	public String toString() {
		return "Standard [city=" + city + ", prov=" + prov + "]";
	}
}

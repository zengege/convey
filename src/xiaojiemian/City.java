package xiaojiemian;

public class City {
	
	private int Cityid;
	private String city;
	public int getCityid() {
		return Cityid;
	}
	public void setCityid(int cityid) {
		Cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
public String toString() {
	return city;
}
}

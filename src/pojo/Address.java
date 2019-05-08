package pojo;

public class Address {
	private int addressid ;
public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
private String address;

public String toString() {
	return address;
}

}

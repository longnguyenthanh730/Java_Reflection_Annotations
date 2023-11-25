
import org.json.JSONObject;

public class Address {
	@XMLElement(name = "street")
	public String street;
	@XMLElement(name = "suite")
	public String suite;
	@XMLElement(name = "city")
	public String city;
	@XMLElement(name = "zipcode")
	public String zipcode;
	public Geo geo;

	public Address(String street, String suite, String city, String zipcode, Geo geo) {
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.geo = geo;
	}

	public Address(JSONObject address) {
		this.street = address.getString("street");
		this.city = address.optString("city");
		this.suite = address.getString("suite");
		this.zipcode = address.getString("zipcode");
		this.geo = new Geo((JSONObject) address.get("geo"));
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	public String toString() {
		return "[street: " + street + ", suite: " + suite + ", city: " + city + ", zipcode: " + zipcode
				+ ", geo: " + geo + "]";
	}

}


import org.json.JSONObject;


public class User {
	@XMLElement(name = "id")
	private int id;
	@XMLElement(name = "name")
	private String name;
	@XMLElement(name = "username")
	private String username;
	@XMLElement(name = "email")
	private String email;
	public Address address;
	@XMLElement(name = "phone")
	private String phone;
	@XMLElement(name = "website")
	private String website;
	private Company company;

	public User(int id, String name, String username, String email, Address address, String phone, String website,
			Company company) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}

	public User(JSONObject user) {
		this.id = Integer.parseInt(user.get("id").toString());
		this.name = user.get("name").toString();
		this.username = user.get("username").toString();
		this.email = user.get("email").toString();
		this.phone = user.get("phone").toString();
		this.website = user.get("website").toString();
		this.address = new Address((JSONObject) user.get("address"));
		this.company = new Company((JSONObject) user.get("company"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAdress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String toString() {
		return "User{" + "id: " + id + ", name: '" + name + '\'' + ", username: '" + username + '\'' + ", email: '"
				+ email + '\'' + ", address: " + address + ", phone: '" + phone + '\'' + ", website: '" + website + '\''
				+ ", company: " + company + '}';
	}
}

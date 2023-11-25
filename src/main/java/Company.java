// import java.util.List;

import org.json.JSONObject;

public class Company {
	@XMLElement(name = "name")
	private String name;
	@XMLElement(name = "catchPhrase")
	private String catchPhrase;
	@XMLElement(name = "bs")
	private String bs;

	public Company(String name, String catchPhrase, String bs) {
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
	}

	public Company(JSONObject company) {
		this.name = company.get("name").toString();
		this.catchPhrase = company.get("catchPhrase").toString();
		this.bs = company.get("bs").toString();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String toString() {
		return "Company [name: " + name + ", catchPhrase: " + catchPhrase + ", bs: " + bs + "]";
	}
}


import org.json.JSONObject;

public class Geo {
	@XMLElement(name = "lat")
	private float lat;
	@XMLElement(name = "lng")
	private float lng;

	public Geo(float lat, float lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public Geo(JSONObject geo) {
		this.lat = Float.parseFloat(geo.get("lat").toString());
		this.lng = Float.parseFloat(geo.get("lng").toString());
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public String toString() {
		return "[lat: " + lat + ", lng: " + lng + "]";
	}

}

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {
		public final static String stringUrl = "https://jsonplaceholder.typicode.com/users";

	    public static String callHttpRequestByHttpClient(String stringUrl) {
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(stringUrl)).build();
	        String res = "";
	        try {
	        	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            if (response.statusCode() == 200) {
	                res = response.body();
	            }
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	        return res;	
	    }
		public static JSONObject parseToJSON(String value) {
			return new JSONObject(value);
		}

		 public static List<User> createListUser(JSONArray data) {
		        List<User> users = new ArrayList<>();
		        for (int i = 0; i < data.length(); i++) {
		            users.add(new User(data.getJSONObject(i)));
		        }
		        return users;
		    }

		 public static void main(String[] args) {
			    String data = callHttpRequestByHttpClient(stringUrl);
			    JSONArray jsonData = new JSONArray(data);	

			    List<User> users = new ArrayList<>();
			    for (int i = 0; i < jsonData.length(); i++) {
			        JSONObject userJson = jsonData.getJSONObject(i);
			        JSONObject addressJson = (JSONObject) userJson.get("address");
			        User user = new User(userJson);
			        Address address = new Address(addressJson);
			        user.setAddress(address);
			        users.add(user);
			    }
			    			    
			    StringBuilder xml = new StringBuilder();
					for (User user : users) {
						xml.append(ObjectToXMLConverter.convertToXML(user));
				}
					
					 File save = new File("./users.xml");
					    try {
					        FileWriter fs = new FileWriter(save);
					        fs.write(xml.toString());
					        fs.close();
			        
					    } catch (IOException e) {
					        e.printStackTrace();
					    }
				System.out.println("OK");
			}
	}

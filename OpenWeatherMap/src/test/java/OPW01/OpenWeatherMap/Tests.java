package OPW01.OpenWeatherMap;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tests
{

	public void URL()
	{
		RestAssured.baseURI="http://api.openweathermap.org";
		
	}

	public void PostRequest()
	{
		RequestSpecification httprqst= RestAssured.given();
		httprqst.queryParam("appid", "4f9c5e4b5ca800c3e322c051318ce554");
		httprqst.header("Content-Type","application/json");
		
		JSONObject request1=new JSONObject();
		request1.put("external_id","DEMO_TEST001");
		request1.put("name", "Khandwa");
		request1.put("latitude",33.33);
		request1.put("longitude",-111.43);
		request1.put("altitude",444);
		
		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST, "/data/3.0/stations");
	    JsonPath jp=new JsonPath(response.body().asString());
	    Assert.assertEquals(201,response.getStatusCode());
		response.getBody().prettyPrint();
	}
	
	public void GetRequest()
	{RequestSpecification httprqst= RestAssured.given();
	httprqst.queryParam("appid", "4f9c5e4b5ca800c3e322c051318ce554");
	httprqst.header("Content-Type","application/json");
	 Response response=httprqst.request(Method.GET, "/data/3.0/stations?name=Khandwa & name =Bhopal");
	  Assert.assertEquals(200,response.getStatusCode());
	}
	
	public void DeleteRequest()
	{
		 RequestSpecification httprqst= RestAssured.given();
			httprqst.queryParam("appid", "4f9c5e4b5ca800c3e322c051318ce554");
			httprqst.header("Content-Type","application/json");
			Response response=httprqst.request(Method.DELETE, "/data/3.0/stations/604e2edf09e7430001b9e185");
			response.getBody().prettyPrint();
			    
			Assert.assertEquals(response.getStatusCode(), 204);
			System.out.println(response);
	}
	
	
}

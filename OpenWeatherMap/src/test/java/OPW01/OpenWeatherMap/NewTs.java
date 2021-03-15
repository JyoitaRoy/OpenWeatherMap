package OPW01.OpenWeatherMap;

import static io.restassured.RestAssured.given;

import java.awt.print.Printable;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import static org.hamcrest.Matchers.*;
import bsh.Console;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTs 
{
	@BeforeMethod
	public void URL()
	{
		RestAssured.baseURI="http://api.openweathermap.org";
		
	}
 
	@Test(priority=1)
	public void test1() throws Exception
	{
		RestAssured.baseURI="http://api.openweathermap.org";
		RequestSpecification httprqst=RestAssured.given();
		JSONObject request1=new JSONObject();
		request1.put("external_id","DEMO_TEST001");
		request1.put("name interviw station", "Khandwa");
		request1.put("latitude",33.33);
		request1.put("longitude",-111.43);
		request1.put("altitude",444);
		
		httprqst.header("Content-Type","application/json");
		httprqst.body(request1.toJSONString());
		Response response=httprqst.request(Method.POST,"/data/3.0/stations");
		
		JsonPath jp=new JsonPath(response.body().asString());
		Assert.assertEquals(401, response.getStatusCode());
		Assert.assertEquals("Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.", jp.get("message"));
	}
	
	@Test(priority=2)
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
	
	@Test(priority=3)
	public void GetRequest()
	{RequestSpecification httprqst= RestAssured.given();
	httprqst.queryParam("appid", "4f9c5e4b5ca800c3e322c051318ce554");
	httprqst.header("Content-Type","application/json");
	 Response response=httprqst.request(Method.GET, "/data/3.0/stations?name=Khandwa & name =Bhopal");
	  Assert.assertEquals(200,response.getStatusCode());
	}
	
	@Test(priority=4)
	public void DeleteRequest()
	{
		 RequestSpecification httprqst= RestAssured.given();
			httprqst.queryParam("appid", "4f9c5e4b5ca800c3e322c051318ce554");
			httprqst.header("Content-Type","application/json");
			Response response=httprqst.request(Method.DELETE, "/data/3.0/stations/604ed41709e7430001b9e18c");
			response.getBody().prettyPrint();
			    
			Assert.assertEquals(response.getStatusCode(), 204);
			System.out.println(response);
		
	}
}








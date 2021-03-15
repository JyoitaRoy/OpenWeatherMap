package OPW01.OpenWeatherMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefinition 
{
	Tests ts=new Tests();
	 @Given("^The url$")
	    public void the_url() throws Throwable
	    {
		 ts.URL();
	    }

	  @When("^I Post the request and the details successfully stored in DB$")
	    public void i_post_the_request_and_the_details_successfully_stored_in_db() throws Throwable 
	  {
		  ts.PostRequest();
	    }

	    @When("^I Get the request and  I able to see the details$")
	    public void i_get_the_request_and_i_able_to_see_the_details() throws Throwable
	    {
	    	ts.GetRequest();
	    }

	    @When("^I Delete the request and the details successfully deleted$")
	    public void i_delete_the_request_and_the_details_successfully_deleted() throws Throwable 
	    {
	    	ts.DeleteRequest();
	    }
}

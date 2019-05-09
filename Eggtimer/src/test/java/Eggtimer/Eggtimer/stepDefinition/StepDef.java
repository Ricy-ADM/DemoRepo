package Eggtimer.Eggtimer.stepDefinition;

import Eggtimer.Eggtimer.SeleniumTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	SeleniumTest obj1=null;
	
	@Before
	public void init(Scenario scenario)
	{
		obj1 = new SeleniumTest();
		
	}
	@Given("^User navigates to \"([^\"]*)\"$")
	public void User_navigates_to(String arg1) throws Throwable {
       obj1.NavigateToURL(arg1);
       
	}

	@When("^Enters \"([^\"]*)\" as \"([^\"]*)\"$")
	public void Enters_as(String arg1, String arg2) throws Throwable {
		obj1.EnterInTextBox(arg1, arg2);
	}
	

	@When("^Clicks on \"([^\"]*)\" [^\"]*$")
	public void Clicks_on_link(String arg1) throws Throwable {
		obj1.Click(arg1);

	}

	@Then("^Counter should start and decriment per second on page$")
	public void Verify_page_counter() throws Throwable {
		obj1.VerifyPageCounter();
	}
	
	@After
	public void afterTest()
	{
		obj1.QuitDriver();
		obj1 = null;
	}

}

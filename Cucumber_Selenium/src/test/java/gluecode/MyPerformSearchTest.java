package gluecode;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Repository;
import common.CommonUtil;
import common.CommonWorkflowUtil;

public class MyPerformSearchTest {

    CommonUtil commonUtil = new CommonUtil();
	CommonWorkflowUtil commonWorkflowUtil = new CommonWorkflowUtil();

	@Given("^Open application$")
	public void open_application() throws Throwable {
        commonUtil.createWebDriverInstance();
	}

	@When("^Perform search$")
	public void performSearch() throws Throwable {
		commonWorkflowUtil.performSearch("pens");
	    System.out.println("Searching for ....");
	}

	@Then("^Successfully search results are displayed$")
	public boolean validateSearchResults() throws Throwable {
		return commonWorkflowUtil.validateElementDisplayed(Repository.Common.eleResults);
	}


}

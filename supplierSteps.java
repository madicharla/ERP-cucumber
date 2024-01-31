package stepDefination;

import org.openqa.selenium.WebDriver;

import commonFunction.functionLibrary;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class supplierSteps {
	WebDriver driver;
	@When("Open browser")
	public void open_browser() throws Throwable {
		functionLibrary.startBrowser();
		 
	}

	@When("Open application url {string}")
	public void open_application_url(String string) throws Throwable {
	    functionLibrary.openApplcation(driver, string);
	}

	@When("wait for username with {string} and {string}")
	public void wait_for_username_with_and(String string, String string2) {
	    functionLibrary.waitForElement1(driver, string2, string, "10");
	    
	}
	

	@When("click on reset button with {string} and {string}")
	public void click_on_reset_button_with_and(String string, String string2) {
	    functionLibrary.clickAction1(driver, string, string2);
	}


	@When("enter username with {string} and {string}")
	public void enter_username_with_and(String string, String string2) {
		functionLibrary.typeAction1(driver, string2, string, "admin");
		
		
	}

	@When("enter password with {string} and {string}")
	public void enter_password_with_and(String string, String string2) {
		functionLibrary.typeAction1(driver, string2, string, "master");
	}

	@When("click on login with {string} and {string}")
	public void click_on_login_with_and(String string, String string2) {
	    functionLibrary.clickAction1(driver, string2, string);
	}

	@When("wait for supplier link with {string} and {string}")
	public void wait_for_supplier_link_with_and(String string, String string2) {
	    functionLibrary.waitForElement1(driver, string2, string, "10");
	}

	@When("click on supplier link with\"x-Path\" and {string}")
	public void click_on_supplier_link_with_x_path_and(String string) {
	   functionLibrary.clickAction1(driver, string, string);
	}

	@When("wait for addbutton with\"x-Path\" and {string}")
	public void wait_for_addbutton_with_x_path_and(String string) {
		functionLibrary.waitForElement1(driver, string, string, "10");
	}

	@When("click on addbutton with\"x-path\" and {string}")
	public void click_on_addbutton_with_x_path_and(String string) {
		functionLibrary.clickAction1(driver, string, string);
		} 

	@When("wait for supplier number with {string} and {string}")
	public void wait_for_supplier_number_with_and(String string, String string2) {
		functionLibrary.waitForElement1(driver, string, string, "10"); 
	}

	@Then("capture supplier number with {string} and\"\\/\\/input[@data-field={string}]\"")
	public void capture_supplier_number_with_and_input_data_field(String string, String string2) throws Throwable {
	    functionLibrary.captureSupp1(driver, string, string2);
	}

	@When("enter supplier name {string} with {string} and\"x_Supplier_Name\"")
	public void enter_supplier_name_with_and_x_supplier_name(String string, String string2) {
	    functionLibrary.typeAction1(driver, string2, string, "supplier name");
	}

	@When("enter address {string} with {string} and {string}")
	public void enter_address_with_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<address>");
	}

	@When("enter city name {string} with {string} and {string}")
	public void enter_city_name_with_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<city name>");
	}

	@When("enter country {string} with {string} and {string}")
	public void enter_country_with_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<country>");
	}

	@When("enter contact person {string} with {string} and {string}")
	public void enter_contact_person_with_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<contact person>");
	}

	@When("enter phone number {string} wwith {string} and {string}")
	public void enter_phone_number_wwith_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<phone number>");
	}

	@When("enter email {string} with {string} and {string}")
	public void enter_email_with_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<email>");
	}

	@When("enter mobile  number {string}  with {string} and {string}")
	public void enter_mobile_number_with_and(String string, String string2, String string3) {
		functionLibrary.typeAction1(driver, string2, string, "<mobile number>");
	}

	@When("enter notes {string} with {string} and {string}")
	public void enter_notes_with_and(String string, String string2, String string3) {
	    functionLibrary.typeAction1(driver, string2, string, "<notes>");
	}

	@When("click on add button with {string} and {string}")
	public void click_on_add_button_with_and(String string, String string2) {
	   functionLibrary.clickAction1(driver, string, string2);
	}

	@When("wait for ok button with {string} and {string}")
	public void wait_for_ok_button_with_and(String string, String string2) {
	    functionLibrary.waitForElement1(driver, string2, string, "10");
	}

	@When("click on ok button with {string} and {string}")
	public void click_on_ok_button_with_and(String string, String string2) {
		functionLibrary.clickAction1(driver, string, string2);
	}

	@Then("user validate supplier table")
	public void user_validate_supplier_table() {
	    functionLibrary.validateTitle1(driver, "supplier table");
	}

	@When("close the browser")
	public void close_the_browser() {
	    functionLibrary.closeBrowser1(driver);
	}



}

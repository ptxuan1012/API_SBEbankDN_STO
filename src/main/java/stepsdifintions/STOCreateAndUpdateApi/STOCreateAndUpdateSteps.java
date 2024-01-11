package stepsdifintions.STOCreateAndUpdateApi;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class STOCreateAndUpdateSteps {
	String url, requestBodyFilePath, requestBody;
	HttpResponse<String> response;
	JsonUtils jsonUtils = new JsonUtils();
	ApiUtils apiUtils = new ApiUtils();

	@Given("I have url and Method and request body")
	public void i_have_url_and_method_and_request_body(DataTable givenTable) {
		List<Map<String, String>> list = givenTable.asMaps(String.class, String.class);
		String requestBodyName = "";
		for (Map<String, String> m : list) {
			url = m.get("URL");
			requestBodyName = m.get("RequestBodyName");
		}
		requestBodyFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\" + requestBodyName;
	}

	@When("I send request")
	public void i_send_request() {
		requestBody = jsonUtils.readJsonFile(requestBodyFilePath);
		response = apiUtils.sendPostRequest(url, requestBody);
	}

	@Then("I check {int} correctly")
	public void i_check_correctly(int expectedStatusCode) {
		assertEquals(response.statusCode(), expectedStatusCode);
	}

}
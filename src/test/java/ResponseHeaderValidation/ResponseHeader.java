  package ResponseHeaderValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ResponseHeader {
	@Test
	public void validateResponse()
	{
		baseURI="http://rmgtestingserver"; 
		port=8084;
		
		String expected_statusLine="HTTP/1.1 200 ";
		String expected_vary="Access-Control-Request-Headers";
		String expected_contentType="application/json";
		String expected_pragma="no-cache";
		String expected_connection="keep-alive";
		
		Response resp = when().get("projects/TY_PROJ_25153");
		
		String statusLine = resp.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, expected_statusLine);
		
		Headers headers = resp.getHeaders();
		System.out.println(headers);
		
		String actual_contentType=resp.getHeader("Content-Type");
		Assert.assertEquals(actual_contentType, expected_contentType);
		
		String actual_pragma = resp.getHeader("Pragma");
		Assert.assertEquals(actual_pragma, expected_pragma);
		
		String actual_connection = resp.getHeader("Connection");
		Assert.assertEquals(actual_connection, expected_connection);
		
		String actual_vary = resp.getHeader("Vary");
		Assert.assertEquals(actual_vary, expected_vary);
		
		resp.then().log().all();
	}

}

package InterviewQuestions;

import java.util.HashSet;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class HowToKeepSensitiveData {
	@Test
	public void sensitiveData()
	{
		HashSet<String> set=new HashSet<String>();
		set.add("X-REGION");
		set.add("content-type");
		given().baseUri("http://rmgtestingserver:8084")
		.headers("X-REGION", "NAME")
		.config(config.logConfig(LogConfig.logConfig().blacklistHeaders(set)))
		.log().all()
		.when().get("/employees")
		.then().assertThat().statusCode(200);
		
		
	}

	private RequestSpecification config(RestAssuredConfig logConfig) {
		// TODO Auto-generated method stub
		return null;
	}

}

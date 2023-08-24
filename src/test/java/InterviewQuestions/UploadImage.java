package InterviewQuestions;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class UploadImage {
	@Test
	public void createPet()
	{
		baseURI="https://petstore.swagger.io/v2";
		JSONObject jobj=new JSONObject();
		jobj.put("id", 85);
		jobj.put("id", 6);
		jobj.put("name", "jimmy");
		given().body(jobj).contentType(ContentType.JSON)
		.when().post("/pet")
		.then().log().all();
	}
	
	@Test
	public void uploadImage()
	{
		File f=new File("C:\\Users\\DELL\\Downloads\\gimmy.jpg");
		String image="https://petstore.swagger.io/v2/pet/6/uploadImage";
		Response resp=given().multiPart("file",image)
		.when().post(image);
		System.out.println("response: "+ resp.asString());
		System.out.println("status code: "+resp.statusCode());
	} 

}

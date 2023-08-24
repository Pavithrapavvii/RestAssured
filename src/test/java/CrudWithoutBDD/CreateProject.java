package CrudWithoutBDD;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class CreateProject {

	public static void main(String[] args) {
		JSONObject jobj=new JSONObject();
		jobj.put("name", "pavithra");
		jobj.put("job", "tester");
		
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		Response response = req.post("https://reqres.in/api/users");
		//System.out.println(response.asString());
		//System.out.println(response.prettyPrint());
		//System.out.println(response.prettyPeek());
		System.out.println(response.getContentType());
		

	}

}

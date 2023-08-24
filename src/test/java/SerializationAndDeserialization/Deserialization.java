package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.Employee;

public class Deserialization {
	@Test
	public void empDeser() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper ob=new ObjectMapper();
		Employee data = ob.readValue(new File("./ser.json"), Employee.class);
		System.out.println(data.getName());
		System.out.println(data.getPhone());
		System.out.println(data.getEmail());
		System.out.println(data.getId());
	}

}

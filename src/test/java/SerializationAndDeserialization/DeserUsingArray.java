package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.EmployeeArray;

public class DeserUsingArray {
	@Test
	public void deserUsingArray() throws IOException
	{
		ObjectMapper ob=new ObjectMapper();
		EmployeeArray data = ob.readValue(new File("./emp.json"),EmployeeArray.class);
		System.out.println(data.getName());
		System.out.println(data.getMail());
		
		//System.out.println(data.getPhno()[0]);
	}

}

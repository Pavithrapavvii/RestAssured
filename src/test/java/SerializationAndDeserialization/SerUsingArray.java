package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.EmployeeArray;

public class SerUsingArray {
	@Test
	public void serUsingArray() throws JsonGenerationException, JsonMappingException, IOException
	{
		int[]phno= {12345,98745};
		EmployeeArray e=new EmployeeArray("pavi", "pavi@gmail.com", phno);
		ObjectMapper ob=new ObjectMapper();
		ob.writeValue(new File("./emp.json"), e);
	}

}

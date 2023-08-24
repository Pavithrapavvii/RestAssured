package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.Employee;

public class Serialization {
	@Test
	public void empSer() throws JsonGenerationException, JsonMappingException, IOException
	{
		Employee e=new Employee("pavithra", "pavi123@gmail.com", 123456, 52);
		 ObjectMapper ob=new ObjectMapper();
		 ob.writerWithDefaultPrettyPrinter().writeValue(new File("./ser.json"), e);
		 
	}

}

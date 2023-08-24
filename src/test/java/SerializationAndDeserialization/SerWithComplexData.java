package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.EmployeeArray;
import PojoClass.EmployeeArrayWithComplex;
import PojoClass.Spouse;

public class SerWithComplexData {
	@Test
	public void serWithComplex() throws JsonGenerationException, JsonMappingException, IOException
	{
		int []phno= {45484,85655};
		Spouse s=new Spouse("gowri", "gowri@gmail.com", phno);
		
		int [] ph= {25488,26874};
		EmployeeArrayWithComplex e=new EmployeeArrayWithComplex("pavi", "p@gmail.com", phno, s);
		ObjectMapper ob=new ObjectMapper();
		ob.writerWithDefaultPrettyPrinter().writeValue(new File("./spouse.json"), e);
		
	}

}

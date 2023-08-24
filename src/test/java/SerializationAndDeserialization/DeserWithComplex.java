package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PojoClass.EmployeeArray;
import PojoClass.EmployeeArrayWithComplex;

public class DeserWithComplex {
	@Test
	public void deser() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper ob=new ObjectMapper();
		EmployeeArrayWithComplex e=ob.readValue(new File("./spouse.json"), EmployeeArrayWithComplex.class);
		System.out.println("emp name is "+e.getName());
		System.out.println("emp mail is "+e.getMail());
		System.out.println("emp phone number is "+e.getPhno()[0]);
		System.out.println("spouse name is "+e.getSpouse().getName());
		System.out.println("spouse mail is "+e.getSpouse().getMail());
		System.out.println("spouse phone no is "+e.getSpouse().getPhno()[1]);
		
	}
}

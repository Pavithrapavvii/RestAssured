package GenericUtilities;

import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtilities {
	@Test
	public int randomNumber()
	{
		Random r=new Random();
		int random = r.nextInt(500);
		return random;
	}

}

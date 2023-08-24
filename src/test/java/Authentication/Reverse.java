package Authentication;

import org.testng.annotations.Test;

public class Reverse {
	@Test
	public void reverse()
	{
		 String[] str={"welcome","to","ty"};
		 for(int i=0;i<str.length;i++)
		 {
			 String c = str[i];
			 for(int j=c.length()-1;j>=0;j--)
			 {
				 
				 System.out.print(c.charAt(j));
			 }
			 System.out.print(" ");
		 }
			
			
	}

}

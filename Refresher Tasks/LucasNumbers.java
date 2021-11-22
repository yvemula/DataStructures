import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;


public class LucasNumbers
{
			private ArrayList<BigInteger> nums;

	public LucasNumbers()
	{

		File name = new File("LucasInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			int counter = 0;
			ArrayList<BigInteger>indexes = new ArrayList<BigInteger>();
			String inside;
			while((inside = input.readLine()) != null)
			{
					BigInteger numbers = new BigInteger(inside);
					System.out.println("Lucas Numbers: "+findNum(numbers));
		}
	}
		catch (IOException io)
		{
			System.err.println("Sorry, File does not exist");
		}
	}
	public BigInteger findNum(BigInteger num){
		BigInteger c = new BigInteger("2");
		BigInteger d =  BigInteger.ONE;
		if(num.equals(BigInteger.valueOf(0))){
		return c;
	}
		BigInteger e=d;
		for(BigInteger i=c;i.compareTo(num)<=0;i=i.add(BigInteger.ONE)){
			e=c.add(d);
			c=d;
			d=e;

		}
		return c;
	}

	public static void main(String args[])
	{
		LucasNumbers timeTravel = new LucasNumbers();
	}
}

import java.io.*;
import java.util.ArrayList;//this is the only one that is necessary for this template.
//You might need others depending on the task.

public class ANum
{


	public ANum()
	{
		File name = new File("AmicableInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String [] num = text.split(" ");
				int a = Integer.parseInt(num[0]);
				int b = Integer.parseInt(num[1]);
				Amicable(a,b);
				System.out.println();


			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public void Amicable(int a, int b)
	{
		ArrayList<Integer> Divs1 = new ArrayList<Integer>();
		ArrayList<Integer> Divs2 = new ArrayList<Integer>();

		int sum1 = 0;
		int sum2 = 0;

		for(int i = 1;i<a;i++)
		{
			if(a%i==0)
			{
				Divs1.add(i);
				sum1+=i;
			}
		}
		for(int j = 1;j<b;j++)
		{
			if(b%j==0)
			{
				Divs2.add(j);
				sum2+=j;
			}
		}
		if((sum1==b)&&(sum2==a))
			System.out.println("The numbers "+a+" and "+b+" are amicable.");
		else
			System.out.println("The numbers "+a+" and "+b+" are not amicable.");
		Print_FS(Divs1,sum1, a);
		Print_FS(Divs2,sum2, b);
	}

	public void Print_FS(ArrayList<Integer> arr, int sum, int a)
	{
		System.out.print("Factors of "+a+" are ");
		for(int i = 0;i<arr.size();i++)
		{
			if(i!=arr.size()-1)
				System.out.print(arr.get(i)+", ");
			else
				System.out.print("and "+arr.get(i));
		}
		System.out.println(". Sum is "+sum+".");
	}
	public static void main(String args[])
	{
		ANum app = new ANum();
	}
}


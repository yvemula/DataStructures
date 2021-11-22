import java.io.*;	//this is the only one that is necessary for this template.
import java.util.ArrayList;

public class JollySorting
{
	public JollySorting()
	{
		File name = new File("JollyInput.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));


			String text,output="";

			while((text=input.readLine())!= null)
			{

				String parts[] = text.split(" ");

				int list[] = new int[parts.length];

				for(int i = 0; i < parts.length; i++)
					list[i] = Integer.parseInt(parts[i]);


				for(int j = 0; j < list.length-1; j++)
				{
					int num = list[j];

					if(j%2 == 0)
					{
						if(list[j] > list[j+1])
						{
							int temp = list[j]; //swap code1
							list[j] = list[j+1];
							list[j+1] = temp;
						}
					}
					else
					{
						if(list[j] < list[j+1])
						{
							int swap = list[j]; //swap code2
							list[j] = list[j+1];
							list[j+1] = swap;
						}
					}
				}


				for(int x = 0; x < list.length; x++)//for displaying the list
				{
					System.out.print(list[x] + " ");
				}
				System.out.println();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}



	public static void main(String args[])
	{
		JollySorting app = new JollySorting();
	}
}
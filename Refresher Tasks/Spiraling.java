import java.io.*;	//this is the only one that is necessary for this template.
//You might need others depending on the task.

public class Spiraling
{
	int start_r;
	int start_c;
	int end_r;
	int end_c ;
	public Spiraling()
	{
		File name = new File("SpiralInput.txt");
		/*int start_r;
		int start_c;
		int end_r;
		int end_c;*/
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));

			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String[][]two_dirr = new String[Integer.parseInt(text)][Integer.parseInt(text)];
				start_r = 0;
				start_c = 0;
				end_r = two_dirr[0].length-1;
				end_c = two_dirr.length-1;
				Fill_arr(two_dirr);
				Put_Star(two_dirr);
				Display_arr(two_dirr);
			}

		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public void Fill_arr(String[][] a)
	{
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				a[i][j] = "-";
			}
		}
	}

	public void Put_Star(String[][] a)
	{
		int d = 0;
		d=a.length;

		boolean ended = false;

		do
		{

			for(int i = start_c;i<=end_c;i++)
			{
				a[start_r][i] = "*";

			}
			start_r++;
			if(start_c>0)
				start_c++;
			for(int j = start_r;j<=end_r;j++)
			{

				a[j][end_c] = "*";

			}
			end_c--;
			start_r++;
			for(int k = end_c;k>=start_c;k--)
			{

				a[end_r][k] = "*";
			}
			end_r--;
			end_c--;
			for(int n = end_r;n>=start_r;n--)
			{
				a[n][start_c] = "*";
			}
			start_c++;
			end_r--;

		}while(start_r<=end_r && start_c<=end_c);
int middle = 0;
middle = d/2;
		if(d%4==2)
			a[middle--][middle--] = "-";

	}

	public void Display_arr(String[][] a)
	{
		System.out.println();
		System.out.println("Dimension: "+a.length+"x"+a.length);
		for(int i = 0;i<a.length;i++)
		{
			for(int j = 0;j<a[0].length;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Spiraling app = new Spiraling();
	}
}


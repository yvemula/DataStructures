import java.io.*;
import java.util.ArrayList;


public class Matrix
{
	private ArrayList<int[][]> matricies;


	public Matrix()
	{
		matricies = new ArrayList<>();
		File name = new File("Matrix.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String inside;
			while((inside = input.readLine()) != null)
			{
					printMatrix(inside);
					getDifSum();
					getProd();
			}
		}
		catch (IOException io)
		{
			System.err.println("Sorry, File does not exist");
		}
	}
	public void printMatrix(String inside){
		String[] arr = inside.split("\t");
		for(int i =0;i<arr.length;i++)
		{
			String removeBrace = arr[i].substring(2,arr[i].length()-2);
			String[] rows = removeBrace.split("},\\{");
			String[] cols = rows[0].split(",");
			int numRows = rows.length;
			int numCols = cols.length;
			int[][] matrix = new int[numRows][numCols];
			for(int row = 0;row<numRows;row++){
					for(int col = 0;col<numCols;col++){
							matrix[row][col] = Integer.parseInt(rows[row].split(",")[col]);
						}
					}
					System.out.println("Matrix "+(i+1)+":");
					printMatrix(matrix);
					System.out.println();
					matricies.add(matrix);



		}


	}
	public void getDifSum() {
			int[][] matrix1 = matricies.get(0);
			int[][] matrix2 = matricies.get(1);
			if(matrix1.length==matrix2.length && matrix1[0].length == matrix2[0].length){
				int numRows = matrix1.length;
				int numCols = matrix1[0].length;
				int[][] sumMatrix = new int[numRows][numCols];
				int[][] differenceMatrix = new int [numRows][numCols];

				for(int row=0;row<numRows;row++){


			for(int col = 0;col<numCols;col++){
				sumMatrix[row][col] = matrix1[row][col] + matrix2[row][col];
				differenceMatrix[row][col] = matrix1[row][col] - matrix2[row][col];
			}
		}
		System.out.println("Sum:");
		printMatrix(sumMatrix);
		System.out.println();
		System.out.println("Difference:");
		printMatrix(differenceMatrix);
	}
	else{
		System.out.println("Sum: ");
		System.out.println("\tSum is not possible.");
		System.out.println();
		System.out.println("Difference: ");
		System.out.println("\tDifference is not possible.");
		}
		System.out.println();





	}
	public void getProd()
	{
		int[][] matrix1 = matricies.get(0);
		int[][] matrix2 = matricies.get(1);
		if(matrix1[0].length == matrix2.length)
		{
			int nunRows = matrix1.length;
			int numCols = matrix2[0].length;
			int[][] productMatrix = new int[numRows][numCols];
			for(int row = 0;row<numRows;row++){
					for(int col = 0;col<numCols;col++){
						for(int i=0;i<matrix1[0].length;i++){
							productMatrix[row][col] +=matrix1[row][i]*matrix2[i][col];
						}
					}
				}
				System.out.println("Product: ");
				printMatrix(productMatrix);


		}
		else{
			System.out.println("Product not possible");
		}
		System.out.println();

	}
public void printMatrix(int[][] matrix){
	for(int row = 0;row<numRows;row++){
					for(int col = 0;col<numCols;col++){
						System.out.print(matrix[row][col]+"\t");
					}
					System.out.println();
				}
			}

	public static void main(String args[])
	{
		Matrix timeTravel = new Matrix();
	}
}




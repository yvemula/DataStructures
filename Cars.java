import java.nio.file.*;
import java.io.*;
import java.util.*;
import  java.util.Arrays;
public class Cars{

	public static void main(String[]args){
		ReadTask();
	}
	public static void ReadTask(){
		try{
		Queue<Car>  queue = new LinkedList<>();
				 PriorityQueue<Car> pq = new PriorityQueue<>();
         PriorityQueue<Car> rpq = new PriorityQueue<>();
		File file = new File("CarData.txt");
             BufferedReader input = new BufferedReader(new FileReader(file));
            String text;
             input.readLine();
             String pieces[];
 while ((text = input.readLine()) != null) {

	pieces=text.split("\t");
	for(int i =1;i<pieces.length;i++){
	               queue.add(new Car((Integer.valueOf(pieces[1])), (Integer.valueOf(pieces[2])), (Integer.valueOf(pieces[3])), (Integer.valueOf(pieces[4])), (Integer.valueOf(pieces[5])), pieces[6], (Integer.valueOf(pieces[7]))));
            }
}
            while(!queue.isEmpty()) {
				System.out.println("MPG\tEngineSize\thorsePwr+\tweight\t\tacc     \tcountry\t\tcyl");
                System.out.println(queue.poll().toString());
            }

	}catch(IOException e) {
            e.printStackTrace();
		}

	}
	}
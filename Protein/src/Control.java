import java.util.Random;
import java.util.*;
import java.io.IOException;
public class Control {

	public static void main(String[] args) throws IOException 
	{
		String protein = "12122112122121122121";
		String p_movements = "";
		ArrayList<Node> list = new ArrayList<Node>();
		double[] array_fitness = {}; //Array to hold fitness + log file data
		double b_fitness = -10000;
		double generation = 1;
		double bonds = 0;
		int i = 0;
		int j = 0;
		
		
		
	    String movement = "UDRL";
		int N = movement.length();
		int P = protein.length();
		
		Random r = new Random();
		
		//For loop to create a string of random movements e.g UUUDDDLLLRRR
		for(i=0; i<P; i++)
		{
			p_movements = p_movements + (movement.charAt(r.nextInt(N)));
		}
		
		
		System.out.println(p_movements);
		
		
		//Store nodes in an Arraylist (Redundant)
		for(i=0;i<P;i++)
		{
			Node n1 = new Node(protein.charAt(i), i, p_movements.charAt(i));
			list.add(n1);
		}
		
		ArrayMaker a1 = new ArrayMaker(protein.length()); //Make an instance of arraymaker class
		int[][] TwoDArray = a1.ArrayReturn();			  //Use arraymaker function to generate array based on size 
														  //of sequence
		
		
																	//Create fitness object
		Fitness f1 = new Fitness(protein,TwoDArray,p_movements);
		
		array_fitness = f1.FitnessCalculator();	//Call fitness calculator
		
		if (array_fitness[0] > b_fitness)
		{
			b_fitness = array_fitness[0];
			bonds = array_fitness[1];
			
		}
		
		double[] array_bfitness = {generation,b_fitness,bonds}; 
		LogWriter l1 = new LogWriter(array_bfitness);
		l1.writeLog();
		
		
		
		
		//System.out.println(list);
		
		
	}


}

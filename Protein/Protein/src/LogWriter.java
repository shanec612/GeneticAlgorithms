import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter 
{
	private double[] array_fitness;
	private String filename = "C:\\Users\\Shane\\SomeDirectory\\logfile.txt";
	
	public LogWriter(double[] array_fitness)
	{
		this.array_fitness = array_fitness;
	}
	
	public void writeLog() throws IOException
	{
		String LogFile = ("Protein Log File" + System.lineSeparator() + 
						  "--------------------------" + System.lineSeparator() +
						  "Generation Number: " + array_fitness[0] + System.lineSeparator() + 
						  "Fitness of Best Candidate: " + array_fitness[1] + System.lineSeparator() +
						  "No. of Bonds for Best Candidate: " + array_fitness[2]
						  );
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(LogFile);
		writer.close();
	}
	
}

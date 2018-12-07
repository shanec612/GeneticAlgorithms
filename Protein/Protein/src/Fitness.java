import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fitness 
{
	private String protein;			//Stores the protein sequence
	private int[][] TwoDArray;		//Stores the empty 2-D array
	private String p_movements;		//Stores the list of movements
	private double g_num;			//Stores current generation number
	private double b_fitness;		//Stores best fitness in this generation
	private double bonds;			//Stores hydrophobic bonds
	
	public Fitness(String protein, int[][] TwoDArray, String p_movements)
	{
		this.protein = protein;
		this.TwoDArray = TwoDArray;
		this.p_movements = p_movements;
	}
	
	public double[] FitnessCalculator()
	{
		
		g_num = 1; //Generation number = 1 
		b_fitness = -100;
		bonds = 0;
		
		
		double fitness = 0;
		
		int starti = (int)protein.length()/2;
		int startj = (int)protein.length()/2;
		
		//Plot movements and calculate fitness
		for (int i=0;i<protein.length();i++)
		{
			
			char current = protein.charAt(i);
			
			if(p_movements.charAt(i) == 'R')
			{
				int temp = Character.getNumericValue(current);
				starti = starti + 1; //Move Right
				
				
				if(TwoDArray[starti][startj] == 0)
				{
					TwoDArray[starti][startj] = temp;
					
					if(temp == 1)
					{
						if(TwoDArray[starti + 1][startj] == 1 || //Looks Above
						   TwoDArray[starti - 1][startj] == 1 || //Looks Below
						   TwoDArray[starti][startj + 1] == 1)	 //Looks Right
						{
							fitness++;
							bonds = bonds + 1;
						}
					}
				}
				else		//Else it's an overlap
				{
					TwoDArray[starti][startj] = temp;
					fitness = fitness - 1.5;
				}
				
				
				
			} 
			
			if(p_movements.charAt(i) == 'L')
			{
				int temp = Character.getNumericValue(current);
				starti = starti - 1;
				
				if(TwoDArray[starti][startj] == 0)
				{
					TwoDArray[starti][startj] = temp;
					
					if(temp == 1)
					{
						if(TwoDArray[starti + 1][startj] == 1 || //Looks Above
						   TwoDArray[starti - 1][startj] == 1 || //Looks Below
						   TwoDArray[starti][startj - 1] == 1)	 //Looks Left
								{
									fitness++;
									bonds = bonds + 1;
								}
					}
					
						
				
				}
				else //Else it's an overlap
				{
					TwoDArray[starti][startj] = temp;
					fitness = fitness - 1.5;
				}
			}
			
			if(p_movements.charAt(i) == 'D')
			{
				int temp = Character.getNumericValue(current);
				startj = startj + 1;
				
				if(TwoDArray[starti][startj] == 0)
				{
					TwoDArray[starti][startj] = temp;
					
					if (temp == 1)
					{
						if(TwoDArray[starti - 1][startj] == 1 || //Looks Below
						   TwoDArray[starti][startj + 1] == 1 || //Looks Right
						   TwoDArray[starti][startj - 1] == 1)	 //Looks Left
							{
								fitness++;
								bonds = bonds + 1;
							}
					}
				}
				else
				{
					TwoDArray[starti][startj] = temp;
					fitness = fitness - 1.5;
				}
			}
			
			if(p_movements.charAt(i) == 'U')
			{
				int temp = Character.getNumericValue(current);
				startj = startj - 1;
				
				if(TwoDArray[starti][startj] == 0)
				{
					TwoDArray[starti][startj] = temp;
					
					if (temp == 1)
					{
						if(TwoDArray[starti + 1][startj] == 1 || //Looks Up
						   TwoDArray[starti][startj + 1] == 1 || //Looks Right
						   TwoDArray[starti][startj - 1] == 1)	 //Looks Left
						{
							fitness++;
							bonds = bonds + 1;
						}
					}
				}
				else
				{
					TwoDArray[starti][startj] = temp;
					fitness = fitness - 1.5;
				}
			}
			
			
		}//End of fitness calculation 
		
		//Update best fitness
		if(fitness > b_fitness)
		{
			b_fitness = fitness;
		}
		
		
		for (int i=0;i<protein.length();i++)
		{
			System.out.print('\n');
			
			for (int j=0;j<protein.length();j++)
			{
				System.out.print(TwoDArray[j][i]);
			}
		}
		
		System.out.print(fitness);
		
		double[] fitness_array = {fitness, bonds}; //Creates array to store fitness + log file data
		return fitness_array; //Returns Array
	}
	
	
	
	
	
	
	
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
	public int[][] getTwoDArray() {
		return TwoDArray;
	}
	public void setTwoDArray(int[][] twoDArray) {
		TwoDArray = twoDArray;
	}
	public String getP_movements() {
		return p_movements;
	}
	public void setP_movements(String p_movements) {
		this.p_movements = p_movements;
	}
	
	
	
	
}

import java.util.Random;
import java.util.*;

public class Control {

	public static void main(String[] args) 
	{
		String protein = "10100110100101100101";
		String p_movements = "";
		ArrayList<Node> list = new ArrayList<Node>();
		
		
		final String movement = "UDRL";
		final int N = movement.length();
		final int P = protein.length();
		
		Random r = new Random();
		
		for(int i=0; i<P; i++)
		{
			p_movements = p_movements + (movement.charAt(r.nextInt(N)));
		}
		
		System.out.println(p_movements);
		
		for(int i=0;i<P;i++)
		{
			Node n1 = new Node(protein.charAt(i), i, p_movements.charAt(i));
			list.add(n1);
		}
		
		ArrayMaker a1 = new ArrayMaker(protein.length());
		int[][] TwoDArray = a1.ArrayReturn();
		
		System.out.println(Arrays.deepToString(TwoDArray));
		
		
		
		System.out.println(list);
		
	}


}

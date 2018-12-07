import java.util.Arrays;

public class ArrayMaker 
{
	private int length;
	
	ArrayMaker(int length)
	{
		this.length = length;
		
	}
	
	//Returns 2D Array dependant on the size of the sequence
	public int[][] ArrayReturn()
	{
		int[][] array = new int[length][length];
		return array;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "ArrayMaker [length=" + length + ", ArrayReturn()=" + Arrays.toString(ArrayReturn()) + ", getLength()="
				+ getLength() + "]";
	}
	
	
	
}

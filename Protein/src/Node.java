
public class Node 
{
	private int type;
	private int index;
	private char movement;
	
	public Node(int type, int index, char movement)
	{
		this.type = type;
		this.index = index;
		this.movement = movement;
		
	}
	
	public char getMovement() {
		return movement;
	}


	public void setMovement(char movement) {
		this.movement = movement;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	@Override
	public String toString() {
		return "Node [type=" + type + ", index=" + index + ", movement=" + movement + "]";
	}
	
}

//Evan Lyons 4/15/2024
//program class Four (Node)
//This class creates a node with name and SSN. Additionally has left and right pointers for BST.
public class Node
{
	private String name;
	private int ssn;
	private Node left;
	private Node right;
	
	public Node(String name1, int num1)
	{
		name = name1;
		ssn = num1;
		left = null;
		right = null;
	}
	
	public void setSSN(int input)
	{
		ssn = input;
	}
	
	public void setName(String input1)
	{
		name = input1;
	}
	
	public int getSSN()
	{
		return ssn;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getKey()
	{
		return ssn%10000;
	}
	
	public void setLeft(Node nextLeft)
	{
		left = nextLeft;
	}
	
	public void setRight(Node nextRight)
	{
		right = nextRight;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
}

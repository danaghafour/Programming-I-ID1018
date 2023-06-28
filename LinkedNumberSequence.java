import java.util.Arrays;

// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    public int length ()
	{
		int nofNumbers = 0;
		Node n = first;
		while(n != null)
		{
			nofNumbers++;
			n = n.next;
		}
		return nofNumbers;
	}

	public double upperBound()
	{
		Node n = first;
		double max = n.number;
		while(n != null)
		{
			if(n.number > max)
			{
				max = n.number;
			}
			n = n.next;
		}
		return max;
	}

	public double lowerBound()
	{
		Node n = first;
		double min = n.number;
		while(n != null)
		{
			if(n.number < min)
			{
				min = n.number;
			}
			n = n.next;
		}
		return min;
	}

	public double numberAt(int position)
	{
		if(position < 0)
		{
			throw new IndexOutOfBoundsException("Invalid position!");
		}
		int index = 0;
		Node n = first;
		while(n != null && index <= position) 
		{
			if(index == position)
			{
				return n.number;
			}
			n = n.next;
			index++;
		}
		throw new IndexOutOfBoundsException("Invalid position!");
	}

	public int positionOf(double number) 
	{
		int counter = 0;
		Node n = first;
		while(n.next != null)
		{
			if(n.number == number)
			{
				return counter;
			}
			counter++;
			n = n.next;
		}
		return -1;
	}

	public boolean isIncreasing()
	{
		boolean found = false;
		Node prev = first;
		Node curr = prev.next;
		while(curr != null && prev.number < curr.number) //måste kolla hela sekvensen
		{
			curr = curr.next;
			prev = prev.next;
			found = true;
		}

		return found;
	}

	public boolean isDecreasing()
	{
		boolean found = false;
		Node prev = first;
		Node curr = prev.next;
		while(curr != null && prev.number > curr.number)
		{
			curr = curr.next;
			prev = prev.next;
			found = true;
		}

		return found;
	}
	
	public boolean contains(double number)
	{
		boolean exist = false;
		Node n = first;
		while(!exist && n != null)
		{
			if(n.number == number)
			{
				exist = true;
			}
			else
			{
				n = n.next;
			}
		}
		return exist;
		//System.out.println(positionOf(number));
		//return positionOf(number) != -1;
	}

	public void add(double number)
	{
		Node newNode = new Node(number);
		Node n = first;
		while(n.next != null)
		{
			n = n.next;
		}
		n.next = newNode;
	
	}

	public void insert(int position, double number)
	{
		if(position < 0 || position >= this.length())
		{
			throw new IndexOutOfBoundsException("Invalid position!");
		}

		Node newNode = new Node(number);
		if(position == 0)
		{
			newNode.next = first;
			first = newNode;
		}
		else
		{
			Node n = first;
			for(int i = 0; i < position - 1; i++)
			{
				n = n.next;
			}
			newNode.next = n.next;
			n.next = newNode;
		}
	}

	public void removeAt(int position)
	{
		if(position < 0 || position >= this.length())
		{
			throw new IndexOutOfBoundsException("Invalid position!");
		}
		if(this.length() == 2)
		{
			throw new IllegalStateException("Too short to be a sequence!");
		}

		Node n = first;
		if(position == 0)
		{
			first = n.next;
		}
		else
		{
			for(int i = 0; i < position - 1; i++)
			{
				n = n.next;
			}
			n.next = n.next.next;
		}
	}

	public double[] asArray()
	{
		int len = this.length();
		double[] newArray = new double[len];
		Node n = first;
		for(int i = 0; i < len; i++)
		{
			newArray[i] = n.number;
			n = n.next;
		}
		return newArray;
	}
}
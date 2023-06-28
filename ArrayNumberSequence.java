// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

****************************************************************/

// insert inserts the given number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    void insert (int position, double number);

	// numberAt returns the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    double numberAt (int position) throws IndexOutOfBoundsException;

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}
	

    // add code here
	public double numberAt (int position) throws IndexOutOfBoundsException // 
	{
		if (position < 0 || position >= numbers.length)
		    throw new IndexOutOfBoundsException("position out of bounds");
		return numbers[position];
		}
		public void insert (int position, double number)
		{
			if (position < 0 || position >= numbers.length) 
		    throw new IndexOutOfBoundsException("position out of bounds"); 
			double[] newNumbers = new double[numbers.length + 1];
			for (int i = 0; i < position; i++)
			{
				newNumbers[i] = numbers[i];
			}
			newNumbers[position] = number;
			for (int i = position + 1; i < newNumbers.length; i++)
			{
				newNumbers[i] = numbers[i - 1];
			}
			numbers = newNumbers;
		}
		// this method will be used for testing the insert method, and its function is to print the array of numbers in the sequence

	public int length ();
	{
		return numbers.length;
	}
	public boolean contains (double number); // returns true if the sequence contains the given number, false otherwise
	{
		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i] == number)
			{
				return true;
			}
		}
		return false;
	}
	// this method will be used for testing the contains method, and its function is to print the array of numbers in the sequence
	
	// add adds the specified number to the end of this sequence.
    public void add (double number);
	{
		double[] newNumbers = new double[numbers.length + 1];
		for (int i = 0; i < numbers.length; i++)
		{
			newNumbers[i] = numbers[i];
		}
		newNumbers[numbers.length] = number;
		numbers = newNumbers;
	}
	// this method will be used for testing the add method, and its function is to print the array of numbers in the sequence
	
	// isDecreasing returns true if this sequence is decreasing,
    // else false is returned.
    public boolean isDecreasing ();
	{
		for (int i = 0; i < numbers.length - 1; i++)
		{
			if (numbers[i] <= numbers[i + 1])
			{
				return false;
			}
		}
		return true;
	}
	// this method will be used for testing the isDecreasing method, and its function is to print the array of numbers in the sequence
	
	// isIncreasing returns true if this sequence is increasing,
    // else false is returned.
    public boolean isIncreasing ()
	{
		for (int i = 0; i < numbers.length - 1; i++)
		{
			if (numbers[i] >= numbers[i + 1])
			{
				return false;
			}
		}
		return true;
	}
	// this method will be used for testing the isIncreasing method, and its function is to print the array of numbers in the sequence

	// upperBound returns an upper bound for this sequence.
    public double upperBound ()
	{
		double upperBound = numbers[0];
		for (int i = 1; i < numbers.length; i++)
		{
			if (numbers[i] > upperBound)
			{
				upperBound = numbers[i];
			}
		}
		return upperBound;
	}
	// this method will be used for testing the upperBound method, and its function is to print the array of numbers in the sequence

    // lowerBound returns a lower bound for this sequence.
    double lowerBound ()
	{
		double lowerBound = numbers[0];
		for (int i = 1; i < numbers.length; i++)
		{
			if (numbers[i] < lowerBound)
			{
				lowerBound = numbers[i];
			}
		}
		return lowerBound;
	}
	// this method will be used for testing the lowerBound method, and its function is to print the array of numbers in the sequence

	 // removeAt removes the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    // The method throws IllegalStateException if there are
    // just two numbers in the sequence.
    public void removeAt (int position) throws IndexOutOfBoundsException
	{
		if (position < 0 || position >= numbers.length)
		    throw new IndexOutOfBoundsException("position out of bounds");
		if (numbers.length == 2)
		throw new IllegalStateException("just two numbers in the sequence");
		double[] newNumbers = new double[numbers.length - 1];
		for (int i = 0; i < position; i++)
		{
			newNumbers[i] = numbers[i];
		}
		for (int i = position; i < newNumbers.length; i++)
		{
			newNumbers[i] = numbers[i + 1];
		}
		numbers = newNumbers;
	}
	// this method will be used for testing the removeAt method, and its function is to print the array of numbers in the sequence

    // asArray returns an array containing all of the numbers in
    // this sequence, in the same order as in the sequence.
    public double[] asArray ()
	{
		double[] newNumbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		{
			newNumbers[i] = numbers[i];
		}
		return newNumbers;
	}
	// this method will be used for testing the asArray method, and its function is to print the array of numbers in the sequence
}

// insert inserts the given number at the specified position
// in this sequence.
// The method throws IndexOutOfBoundsException if the
// position is wrong.
void insert (int position, double number);

// numberAt returns the number at the specified position
// in this sequence.
// The method throws IndexOutOfBoundsException if the
// position is wrong.
double numberAt (int position) throws IndexOutOfBoundsException;

public class ArrayNumberSequence implements NumberSequence
{
// numbers in the sequence
private double[] numbers;

// create the sequence
public ArrayNumberSequence (double[] numbers)
{
    if (numbers.length < 2)
        throw new IllegalArgumentException("not a sequence");

    this.numbers = new double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
        this.numbers[i] = numbers[i];
}

public String toString()
{
// create an empty string
String s = "";

// loop through the array of numbers
for (int i = 0; i < numbers.length; i++)
{
    // append each number to the string, separated by a comma and space
    s += numbers[i] + ", ";
}

// remove the last comma and space from the string
s = s.substring(0, s.length() - 2);

// return the string
return s;
}

public double numberAt(int position) throws IndexOutOfBoundsException
{
// check if the given position is valid (i.e. within the bounds of the array)
if (position < 0 || position >= numbers.length)
{
// if not, throw an exception
throw new IndexOutOfBoundsException("position out of bounds");
}

// if the position is valid, return the number at that position
return numbers[position];
}

public void insert(int position, double number)
{
// check if the given position is valid (i.e. within the bounds of the array)
if (position < 0 || position >= numbers.length)
{
// if not, throw an exception
throw new IndexOutOfBoundsException("position out of bounds");
}

// if the position is valid, create a new array to store the numbers, with one additional element for the new number
double[] newNumbers = new double[numbers.length + 1];

// loop through the numbers in the old array
for (int i = 0; i < numbers.length; i++)
{
    // if the current position is before the given position, copy the number to the corresponding position in the new array
    if (i < position)
    {
        newNumbers[i] = numbers[i];
    }
    // if the current position is at the given position, insert the new number at that position
    else if (i == position)
    {
        newNumbers[i] = number;
    }
    // if the current position is after the given position, copy the number from the old array to the position in the new array that is one index higher than the corresponding position in the old array
    else
    {
		newNumbers[i + 1] = numbers[i];
	}
}

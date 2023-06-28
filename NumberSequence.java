// NumberSequence

/****************************************************************

NumberSequence represents a sequence of real numbers.

It is possible to obtain the length of the sequence, and to
determine upper and lower bound for the sequence.
The number at a specified position can be determined, as well
as the position for a specified number.
It is possible to examine if the sequence is increasing, or
decreasing, and to examine presence of the specified number.
A number can be added to the end of the sequence and
inserted at a specified position. The number at a specified
position can be removed.
The numbers in the sequence can be obtained in an array.

Author
Fadil Galjic

****************************************************************/

public interface NumberSequence
{
    // length returns the number of numbers in this sequence.
    int length ();

    // upperBound returns an upper bound for this sequence.
    double upperBound ();

    // lowerBound returns a lower bound for this sequence.
    double lowerBound ();

    // numberAt returns the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    double numberAt (int position) throws IndexOutOfBoundsException;

    // positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    // If the number is not present in the sequence, -1 is returned.
    int positionOf (double number);

    // isIncreasing returns true if this sequence is increasing,
    // else false is returned.
    boolean isIncreasing ();

    // isDecreasing returns true if this sequence is decreasing,
    // else false is returned.
    boolean isDecreasing ();

    // contains returns true if this sequence contains the
    // specified number, else false is returned.
    boolean contains (double number);

    // add adds the specified number to the end of this sequence.
    void add (double number);

    // insert inserts the given number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    void insert (int position, double number);

    // removeAt removes the number at the specified position
    // in this sequence.
    // The method throws IndexOutOfBoundsException if the
    // position is wrong.
    // The method throws IllegalStateException if there are
    // just two numbers in the sequence.
    void removeAt (int position) throws IndexOutOfBoundsException;

    // asArray returns an array containing all of the numbers in
    // this sequence, in the same order as in the sequence.
    double[] asArray ();
}
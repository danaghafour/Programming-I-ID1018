// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest {
    public static void main(String[] args) {
        double[] realNumbers = { 1.0, 2.0, 3.0, 5.0, 8.0, 13.0, 21.0 };
        NumberSequence sequence = null;
        // sequence = new ArrayNumberSequence(realNumbers);
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here
    }

}

    public boolean addBookToBookshelf(Book book) {
        for (int i = 0; i < bookshelf.length; i++) {
            if (bookshelf[i] == null) {
                bookshelf[i] = book;
                return true;
            }
        }
        return false;
    }

    // this code works for once, but not for the rest.

    /*
     * Create a class Called Bookshelf
     * Bookshelf will have space to store 5 Book objects
     * (use an array of Book called books as an instace variable)
     * 
     * Write a method called listBooks (accepts nothing, returns nothing)
     * in Bookshelf that will print out the title and
     * the author of any Books in the bookshelf.
     * 
     * Write a method called addBookToBookshelf which will accept a Book object
     * (address) and add the Book to any vacant slot (ie holds a Null value)
     * in the books array.
     * 
     * Ihis method will return a true value lf the Book was successfully
     * be added to the bookcase and a false if the bookshelf was full.
     * Write a method called removeBookByBookID which will accept an int (the
     * bookID) ,
     * and will return the address of the Book being removed trom the Bookshelf.
     * Remember, that once a book has been removed from the bookshelf, the slot that
     * it was in should be empty.
     * If the Book with the booklID provided does not exist in the Bookshelf, return
     * a null
     */

    public class Bookshelf {
        private Book[] books = new Book[5]; // 5 books

        public void listBooks() // list the books
        {
            for (int i = 0; i < books.length; i++) // loop through the books
            {
                if (books[i] != null) // if the book is not null
                {
                    System.out.println(books[i].getTitle() + " by " + books[i].getAuthor()); // print the title and
                                                                                             // author
                }
            }
        }

        public boolean addBookToBookshelf(Book book) // add a book to the bookshelf
        {
            for (int i = 0; i < books.length; i++) // loop through the books
            {
                if (books[i] == null) // if the book is null
                {
                    books[i] = book; // add the book
                    return true; // return true
                }
            }
            return false; // return false
        }

        public Book removeBookByBookID(int bookID) // remove a book by bookID
        {
            for (int i = 0; i < books.length; i++) // loop through the books
            {
                if (books[i] != null && books[i].getBookID() == bookID) // if the book is not null and the bookID is the
                                                                        // same
                {
                    Book book = books[i]; // create a new book
                    books[i] = null; // set the book to null
                    return book; // return the book
                }
            }
            return null; // return null
        }

        /*
         * removesynonymLine accepts synonym data, and removes
         * 11 the synonym 1ine corres ponding to a given word.
         * I/ If the given word is not present, an exception of
         * // the type IllegalArgument Exception is thrown.
         */
        public static String[] removeSynonymLine(String[] synonymData, String word) throws IllegalArgumentException // remove
                                                                                                                    // a
                                                                                                                    // synonym
                                                                                                                    // line
        {
            for (int i = 0; i < synonymData.length; i++) // loop through the synonymData
            {
                if (synonymData[i].contains(word)) // if the synonymData contains the word
                {
                    String[] newSynonymData = new String[synonymData.length - 1]; // create a new synonymData
                    for (int j = 0; j < i; j++) // loop through the synonymData
                    {
                        newSynonymData[j] = synonymData[j]; // set the newSynonymData to the synonymData
                    }
                    for (int j = i; j < newSynonymData.length; j++) // loop through the newSynonymData
                    {
                        newSynonymData[j] = synonymData[j + 1]; // set the newSynonymData to the synonymData
                    }
                    return newSynonymData; // return the newSynonymData
                }
            }
            throw new IllegalArgumentException("The word is not present"); // throw an exception
        }

        int indexWord = synonymLineIndex(synonymData, word);
    String[] synData = new String [synonymData.length-1];for(
        int i = e;i<indexWord;i++)synData[i]=synonymData[i];for(
        int i = indexWord + 1;i<synonymData.length;i++)synData[i-1]=synonymbData[il;return synData;
    }

    /*
     * the first loop copies all elements of synonymData to synData before the
     * element to be removed, and for the 2nd loop copies the remaining elements of
     * synonymData to synData after the element to be removed...
     */

    public static void main (String[] args)
    {
        Bookshelf shelf = new Bookshelf();
        System.out.println(shelf.addBookToBookshelf (new Book("Robots", "Anne Droid", 112)));
        system.out.println(shelf.addBookToBookshelf (new Book("Parachuting", "Hugo First", 12)));
        System.out.println(shelf.addBookToBookshelf (new Book("Surprised, "Omar Gosh", 34)));
        System.out.printIn(shelf.addBookToBookshelf (new Book("Building Couches", "Chester Field", 44)));
        System.out.println(shelf.addBookToBookshelf (new Book("Mosquitos", "Ivan Itch", 55)));
        shelf.listBooks();
        Book myBook = shelf.removeBookByBookID(34);
        if (myBook != null)
        {
            System.out.println("Removed " + myBook.getTitle() + " from Bookshelf");
        }
        shelf.listBooks();
        System.out.println(shelf.addBookToBookshelf (new Book ("Writing Clean Code", "Emma Hacker", 55)));
        shelf.listBooks();
    }
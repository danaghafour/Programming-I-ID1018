// SynonymHandler

/****************************************************************

 SynonymHandler handles information about synonyms for various
 words.

 The synonym data can be read from a file and handled in various
 ways. These data consists of several lines, where each line begins
 with a word, and this word is followed with a number of synonyms.

 The synonym line for a given word can be obtained. It is possible
 to add a synonym line, and to remove the synonym line for a given
 word. Also a synonym for a particular word can be added, or
 removed. The synonym data can be sorted. Lastly, the data can be
 written to a given file.

 ****************************************************************/

import java.io.*;    // FileReader, BufferedReader, PrintWriter,
// IOException
import java.util.*;  // LinkedList

class SynonymHandler
{
    // readSynonymData reads the synonym data from a given file
    // and returns the data as an array
    public static String[] readSynonymData(String synonymFile)
            throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(synonymFile));
        LinkedList<String> synonymLines = new LinkedList<>();
        String synonymLine = reader.readLine();
        while (synonymLine != null) {
            synonymLines.add(synonymLine);
            synonymLine = reader.readLine();
        }
        reader.close();

        String[] synonymData = new String[synonymLines.size()];
        synonymLines.toArray(synonymData);

        return synonymData;
    }

    // writeSynonymData writes a given synonym data to a given
    // file
    public static void writeSynonymData(String[] synonymData,
                                        String synonymFile) throws IOException {
        PrintWriter writer = new PrintWriter(synonymFile);
        for (String synonymLine : synonymData)
            writer.println(synonymLine);
        writer.close();

    }

    // synonymLineIndex accepts synonym data, and returns the
    // index of the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    private static int synonymLineIndex(String[] synonymData,
                                        String word) {
        int delimiterIndex = 0;
        String w = "";
        int i = 0;
        boolean wordFound = false;
        while (!wordFound && i < synonymData.length) {
            delimiterIndex = synonymData[i].indexOf('|');
            w = synonymData[i].substring(0, delimiterIndex).trim();
            if (w.equalsIgnoreCase(word))
                wordFound = true;
            else
                i++;
        }

        if (!wordFound)
            throw new IllegalArgumentException(
                    word + " not present");
        return i;
    }

    // getSynonymLine accepts synonym data, and returns
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String getSynonymLine(String[] synonymData,
                                        String word)
    {
        int index = synonymLineIndex(synonymData, word); // get the index of the synonym line
        return synonymData[index]; // return the synonymline
    }

    // addSynonymLine accepts synonym data, and adds a given
    // synonym line to the data
    public static String[] addSynonymLine(String[] synonymData, String synonymLine)
    {
        String[] synData = new String[synonymData.length + 1]; // create a new array
        for (int i = 0; i < synonymData.length; i++) // copy the old data
            synData[i] = synonymData[i]; // to the new array
        synData[synData.length - 1] = synonymLine; // add the new synonym line
        return synData; // return the new array
    }

    // removeSynonymLine accepts synonym data, and removes
    // the synonym line corresponding to a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static String[] removeSynonymLine(String[] synonymData,
                                             String word)
    {
        int index = synonymLineIndex(synonymData, word); // get the index of the synonym line
        String[] synData = new String[synonymData.length - 1]; // create a new array
        for (int i = 0; i < index; i++) // copy the old data to the new array
            synData[i] = synonymData[i];
        for (int i = index + 1; i < synonymData.length; i++) // copy the old data to the new array
            synData[i - 1] = synonymData[i];
        return synData; // return the new array
    }

    // addSynonym accepts synonym data, and adds a given
    // synonym for a given word.
    // If the given word is not present, an exception of
    // the type IllegalArgumentException is thrown.
    public static void addSynonym(String[] synonymData,
                                  String word, String synonym)
    {
        int index = synonymLineIndex(synonymData, word); // get the index of the synonym line
        synonymData[index] += ", " + synonym; // add the synonym to the synonym line
    }

    // removeSynonym accepts synonym data, and removes a given
    // synonym for a given word.
    // If the given word or the given synonym is not present, an
    // exception of the type IllegalArgumentException is thrown.
    public static void removeSynonym(String[] synonymData,
                                     String word, String synonym)
    {
        int i = synonymLineIndex(synonymData, word); // get the index of the synonym line
        String line = synonymData[i]; // get the synonym line
        String[] splitLine = line.split("[|]"); // split the line into words
        // System.out.println(Arrays.toString(splitLine));
        String part1 = splitLine[0]; // "word"
        // System.out.println(part1);
        String part2 = splitLine[1]; // "synonym1, synonym2"
        // System.out.println(part2);
        part2 = part2.trim();
        String[] synonyms = part2.split(", "); // split the synonyms into words
        // System.out.println(Arrays.toString(synonyms));
        String part3 = "";
        for (int j = 0; j < synonyms.length; j++) // loop through the synonyms
        {
            if (!synonyms[j].equals(synonym)) // if the synonym is not the synonym to be removed
                part3 += synonyms[j] + ", "; // add the synonyms to the string
        }
        // System.out.println(part3);
        part3 = part3.substring(0, part3.length() - 2); // remove the last ", "
        String newLine = part1 + "| " + part3; // create the new synonym line
        synonymData[i] = newLine; // replace the old synonym line with the new synonym line
    }

    // sortIgnoreCase sorts an array of strings, using
    // the selection sort algorithm
    private static void sortIgnoreCase (String[] strings)
    {
        for (int i = 0; i < strings.length - 1; i++)
        {
            int minIndex = i; // assume the first element is the smallest
            for (int j = i + 1; j < strings.length; j++) // find the smallest element
            {
                if (strings[j].compareToIgnoreCase(strings[minIndex]) < 0) // if a smaller element is found
                {
                    minIndex = j; // update the index of the smallest element
                }
            }
            if (minIndex != i) // if the smallest element is not the first element
            {
                String temp = strings[i]; // swap the first element with the smallest element
                strings[i] = strings[minIndex];
                strings[minIndex] = temp;
            }
        }
    }

    // sortSynonymLine accepts a synonym line, and sorts
    // the synonyms in this line
    private static String sortSynonymLine (String synonymLine)
    {
        int delimiterIndex = synonymLine.indexOf('|'); // find the delimiter
        String word = synonymLine.substring(0, delimiterIndex).trim(); // get the word
        String synonyms = synonymLine.substring(delimiterIndex + 1).trim(); // get the synonyms
        String[] splitSynonyms = synonyms.split(", "); // split the synonyms
        sortIgnoreCase(splitSynonyms); // sort the synonyms
        String sortedSynonyms = "";
        for (int i = 0; i < splitSynonyms.length; i++)
            sortedSynonyms += splitSynonyms[i] + ", ";  // create a string to hold the sorted synonyms
        sortedSynonyms = sortedSynonyms.substring(0, sortedSynonyms.length() - 2); // remove the last comma
        return word + " | " + sortedSynonyms; // return the sorted synonym line
    }

    // sortSynonymData accepts synonym data, and sorts its
    // synonym lines and the synonyms in these lines
    public static void sortSynonymData (String[] synonymData)
    {
        for (int i = 0; i < synonymData.length; i++)
        {
            synonymData[i] = sortSynonymLine(synonymData[i]); // sort the synonym lines
        }
        sortIgnoreCase(synonymData); // sort the synonym data
    }
}
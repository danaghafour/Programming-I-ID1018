// SynonymUser.java

/****************************************************************

SynonymUser reads the synonym data from a given file. This data
is used and modified in various ways. Finally, the modified data
is written to a new file.

See:
thesaurus.com

****************************************************************/

import java.io.*;  // IOException
import static java.lang.System.out;

class SynonymUser
{
    public static void main (String[] args) throws IOException
    {
        String[] synonymData = SynonymHandler.readSynonymData(
			"/Users/danaghafour/eclipse-workspace/A2/out/production/A2/SynonymData1.txt");
        println(synonymData);

        String synonymLine = SynonymHandler.getSynonymLine(
			synonymData, "beautiful");
        out.println(synonymLine + "\n");
        synonymLine =
            "glowing | luminous, vibrant, flaming, gleaming";
        synonymData = SynonymHandler.addSynonymLine(
			synonymData, synonymLine);
        println(synonymData);
        synonymData = SynonymHandler.removeSynonymLine(
			synonymData, "clever");
        println(synonymData);
        SynonymHandler.addSynonym(synonymData, "powerful",
            "briliant");
        println(synonymData);
        SynonymHandler.removeSynonym(synonymData, "beautiful",
            "appealing");
        println(synonymData);
        SynonymHandler.sortSynonymData(synonymData);
        println(synonymData);

        SynonymHandler.writeSynonymData(synonymData,
            "SynonymData2.txt");
    }

    public static void println (String[] synonymData)
    {
        for (String synonymLine : synonymData)
            out.println(synonymLine);
        out.println("");
	}
}
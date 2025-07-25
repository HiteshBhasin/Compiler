
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Rules {
/**
 * first we need to define the rules , by taking the .txt file or any other file ext.
 * check the ext first and return true for the
 */

private final String filename;
// constructor
public Rules(String filename ){
this.filename = filename;
ExtensionReading(filename);

}

// reading the file ext first
    protected boolean ExtensionReading(String filename){
        if (!filename.toLowerCase().endsWith(".txt")){
            System.out.println("this is the wrong ext");
            return false;
        }   else {
            System.out.println("This is correct");
            return true;
        }
    }
//    creating getters
    public String getFilename() {
        return filename;
    }

    /**
     * another class which will accept the file and split it in to tokens
     */
  private class Tokenizer{
    private String tokens;
    private String strRegex;

    public Tokenizer(String token, String strRegex){
        this.strRegex=strRegex;
        this.tokens = token;
    }

    public List<Tokenizer> readingFile(String file) throws IOException {
//        checking the rules and the beginning of the files
        List<Tokenizer> newTokenizers =  new ArrayList<>();
        String line="";
        boolean flag=false;
        BufferedReader textReader =  new BufferedReader(new FileReader(file));
        while (textReader.ready()){
            line=textReader.readLine();
            if (line.trim().equals("%%")){
                if (flag){
                    break;
                }
            }else{
                flag=true;
            }
        }

        if(flag && !line.trim().isEmpty()){
            String [] text = line.trim().split("\\s+");
            strRegex = text[0];
            tokens = text[1];
            newTokenizers.add(new Tokenizer(tokens, strRegex));

        }

        textReader.close();

        return newTokenizers;
    }
  }



}
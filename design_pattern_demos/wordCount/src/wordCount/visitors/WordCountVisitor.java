package wordCount.visitors;
import wordCount.util.*;
import wordCount.dsForStrings.*;
import java.io.FileWriter;
import java.io.IOException;

public class WordCountVisitor implements VisitorInterface
{
    StringDatabase sd;
    FileWriter fw;
    
    String outFile;
    
    public WordCountVisitor(String outFileIn)
    {
        outFile = outFileIn;
    }
    
    public void visit(FileProcessor fp)
    {
        
    }
    
    public void visit(StringDatabase sdIn)
    {
        sd = sdIn;
        int wordCount = 0;
        int distinctWords = 0;
        int characters = 0;
        
        boolean leftChecked = false;
        boolean rightChecked = false;
        
        int counter = 0;
        
        StringNode focusNode = sd.getRoot();
        wordCount++;
        distinctWords++;
        characters += focusNode.getWord().length();
        
        do
        {
//            System.out.println("Hi");
            counter++;
            if (focusNode.getLeftNode() != null && !focusNode.getLeftNode().checkedRecently())
            {
//                System.out.println(focusNode.getWord());
                wordCount++;
                distinctWords++;
                characters += focusNode.getLeftNode().getWord().length();
                focusNode = focusNode.getLeftNode();
                focusNode.check();
            }
            else if(focusNode.getDuplicateNode() != null && !focusNode.getDuplicateNode().checkedRecently())
            {
//                System.out.println(focusNode.getWord());
                wordCount++;
                characters += focusNode.getDuplicateNode().getWord().length();
                focusNode = focusNode.getDuplicateNode();
                focusNode.check();
            }
            else if(focusNode.getRightNode() != null && !focusNode.getRightNode().checkedRecently())
            {
//                System.out.println(focusNode.getWord());
                wordCount++;
                distinctWords++;
                characters += focusNode.getRightNode().getWord().length();
                focusNode = focusNode.getRightNode();
                focusNode.check();
            }
            else if (focusNode.getParentNode() != null)
            {
               focusNode = focusNode.getParentNode();
            }
        }
        while (               focusNode.getParentNode()    != null
                ||   (     ( (focusNode.getLeftNode()      != null) && !(focusNode.getLeftNode().checkedRecently()     ) )
                        || ( (focusNode.getDuplicateNode() != null) && !(focusNode.getDuplicateNode().checkedRecently()) )
                        || ( (focusNode.getRightNode()     != null) && !(focusNode.getRightNode().checkedRecently()    ) )   )   );
        
        try
        {
            fw = new FileWriter(outFile);
        
            fw.write("Total words:    " + String.valueOf(wordCount) + "\n");
            fw.write("Distinct Words: " + String.valueOf(distinctWords) + "\n");
            fw.write("Characters:     " + String.valueOf(characters) + "\n");
            
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
        finally
        {
            
        }
    }
    
}
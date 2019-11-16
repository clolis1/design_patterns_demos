package wordCount.visitors;
import wordCount.dsForStrings.*;
import wordCount.util.*;

public class AddLetterVisitor implements VisitorInterface
{
    StringNode node;
    
    public AddLetterVisitor()
    {
        
    }
    
    public void visit(FileProcessor fp)
    {
        
    }
    
    public void visit(StringDatabase sd)
    {
        node = sd.getRoot();
        
        while (node.getDuplicateNode() != null)
        {
            node.getDuplicateNode().setWord(node.getWord() + "X");
            node = node.getDuplicateNode();
        }
    }
}
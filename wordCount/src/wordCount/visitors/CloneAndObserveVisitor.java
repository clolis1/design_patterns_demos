package wordCount.visitors;
import wordCount.dsForStrings.*;
import wordCount.util.*;

public class CloneAndObserveVisitor implements VisitorInterface
{
    BackUpNode clonedRoot;
    
    public CloneAndObserveVisitor()
    {
        
    }
    
    public void visit(FileProcessor fp)
    {
        
    }
    
    public void visit(StringDatabase sd)
    {
        clonedRoot = sd.getRoot().clone();
    }
    
    public BackUpNode getClonedRoot()
    {
        return clonedRoot;
    }
}
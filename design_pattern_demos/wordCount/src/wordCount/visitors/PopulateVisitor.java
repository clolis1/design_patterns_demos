package wordCount.visitors;
import wordCount.util.*;
import wordCount.dsForStrings.*;

public class PopulateVisitor implements VisitorInterface{
    
    StringDatabase sd;
    FileProcessor fp;
    
    public PopulateVisitor(StringDatabase sdIn)
    {
        sd = sdIn;
    }
    
    public void visit(FileProcessor fpIn)
    {
        fp = fpIn;
        if (fp.canRead())
        {
            sd.setRoot(fp.readNext());
//            System.out.println(sd.getRoot().getWord());
        }
        while(fp.canRead())
        {
            sd.insert(sd.getRoot(), fp.readNext());
        }
    }
    
    public void visit(StringDatabase sdIn)
    {
        sd = sdIn;
    }
    
    
}
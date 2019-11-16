package wordCount.visitors;
import wordCount.util.*;
import wordCount.dsForStrings.*;

public interface VisitorInterface{
    public void visit(FileProcessor fp);
    public void visit(StringDatabase sd);
}
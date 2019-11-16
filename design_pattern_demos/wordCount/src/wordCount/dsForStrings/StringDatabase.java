package wordCount.dsForStrings;
import wordCount.visitors.*;
import wordCount.util.*;

public class StringDatabase
{
    
    StringNode root;
    
    public StringDatabase(){
        
    }
    
    public StringDatabase(String rootWord)
    {
        root = new StringNode(rootWord);
    }
    
    public void insert(StringNode middleNode, String toBeInserted)
    {
        if (middleNode.getWord().compareTo(toBeInserted) < 0)
        {
            if (middleNode.getRightNode() == null)
            {
                StringNode node  = new StringNode(toBeInserted);
                middleNode.setRightNode(node);
                middleNode.getRightNode().setParentNode(middleNode);
//                System.out.println(middleNode.getRightNode().getWord());
            }
            else
            {
                this.insert(middleNode.getRightNode(), toBeInserted);
            }
        }
        else if (middleNode.getWord().compareTo(toBeInserted) > 0)
        {
            if (middleNode.getLeftNode() == null)
            {
                StringNode node = new StringNode(toBeInserted);
                middleNode.setLeftNode(node);
                middleNode.getLeftNode().setParentNode(middleNode);
//                System.out.println(middleNode.getLeftNode().getWord());
            }
            else
            {
                this.insert(middleNode.getLeftNode(), toBeInserted);
            }
        }
        else
        {
            if (middleNode.getDuplicateNode() == null)
            {
                StringNode node = new StringNode(toBeInserted);
                middleNode.setDuplicateNode(node);
                middleNode.getDuplicateNode().setParentNode(middleNode);
//                System.out.println(middleNode.getDuplicateNode().getWord());
            }
            else
            {
                this.insert(middleNode.getDuplicateNode(), toBeInserted);
            }
        }
    }
    
    public StringNode getRoot()
    {
        return this.root;
    }
    
    public void setRoot(String rootIn)
    {
        root = new StringNode(rootIn);
    }
    
    public void accept(VisitorInterface visitor)
    {
        visitor.visit(this);
    }
}
package wordCount.dsForStrings;
import wordCount.util.*;

public class BackUpNode implements Observer
{
    String word;
    BackUpNode leftNode;
    BackUpNode rightNode;
    BackUpNode parentNode;
    BackUpNode duplicateNode;
    
    boolean recentlyChecked = false;
    
    public BackUpNode(String wordIn){
        word = wordIn;
        leftNode = null;
        rightNode = null;
        parentNode = null;
        duplicateNode = null;
    }
    
    public String getWord(){
        return this.word;
    }
    
    public void setWord(String wordIn)
    {
        word = wordIn;
    }
    
    public void setRightNode(BackUpNode rightNodeIn){
        rightNode = rightNodeIn;
    }
    
    public void setLeftNode(BackUpNode leftNodeIn){
        leftNode = leftNodeIn;
    }
    
    public BackUpNode getLeftNode(){
        return leftNode;
    }
    
    public BackUpNode getRightNode(){
        return rightNode;
    }
    
    public void setParentNode(BackUpNode pn)
    {
        parentNode = pn;
    }
    
    public BackUpNode getParentNode()
    {
        return parentNode;
    }
    
    public void setDuplicateNode(BackUpNode dn)
    {
        duplicateNode = dn;
    }
    
    public BackUpNode getDuplicateNode()
    {
        return duplicateNode;
    }
    
    public void check()
    {
        recentlyChecked = true;
    }
    
    public boolean checkedRecently()
    {
        return recentlyChecked;
    }
    
    public void update(String s)
    {
        this.setWord(s);
    }
}
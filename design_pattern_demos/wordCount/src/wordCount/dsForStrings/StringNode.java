package wordCount.dsForStrings;
import wordCount.util.*;
import java.util.Vector;

public class StringNode implements Cloneable, Subject
{
    String word;
    StringNode leftNode;
    StringNode rightNode;
    StringNode parentNode;
    StringNode duplicateNode;
    
    Vector<Observer> observers = new Vector<Observer>();
    
    boolean recentlyChecked = false;
    
    public StringNode(String wordIn){
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
        this.notifyObservers();
    }
    
    public void setRightNode(StringNode rightNodeIn){
        rightNode = rightNodeIn;
    }
    
    public void setLeftNode(StringNode leftNodeIn){
        leftNode = leftNodeIn;
    }
    
    public StringNode getLeftNode(){
        return leftNode;
    }
    
    public StringNode getRightNode(){
        return rightNode;
    }
    
    public void setParentNode(StringNode pn)
    {
        parentNode = pn;
    }
    
    public StringNode getParentNode()
    {
        return parentNode;
    }
    
    public void setDuplicateNode(StringNode dn)
    {
        duplicateNode = dn;
    }
    
    public StringNode getDuplicateNode()
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
    
    public BackUpNode clone()
    {
        BackUpNode bn = new BackUpNode(this.getWord());
        if (this.getLeftNode() != null)
        {
            bn.setLeftNode(this.getLeftNode().clone());
            bn.getLeftNode().setParentNode(bn);
        }
        if (this.getDuplicateNode() != null)
        {
            bn.setDuplicateNode(this.getDuplicateNode().clone());
            bn.getDuplicateNode().setParentNode(bn);
        }
        if (this.getRightNode() != null)
        {
            bn.setRightNode(this.getRightNode().clone());
            bn.getRightNode().setParentNode(bn);
        }
        this.registerObserver(bn);
        return bn;
    }
    
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }
    
    public void removeObserver(Observer o)
    {
        observers.remove(o);
    }
    
    public void notifyObservers()
    {
        for (Observer e : observers)
        {
            e.update(this.getWord());
        }
    }
}
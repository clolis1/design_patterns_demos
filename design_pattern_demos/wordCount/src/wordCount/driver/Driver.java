package wordCount.driver;
import wordCount.dsForStrings.*;
import wordCount.util.*;
import wordCount.visitors.*;

public class Driver{
    public static void main(String[] args){
        Driver driver = new Driver();
        driver.checkArgs(args);
        
        FileProcessor fp;
        StringDatabase sd = new StringDatabase();
        
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < Integer.valueOf(args[2]); i++)
        {
            
            fp = new FileProcessor(args[0]);
            sd = new StringDatabase();
            
            VisitorInterface populator = new PopulateVisitor(sd);
            VisitorInterface wordCounter = new WordCountVisitor(args[1]);
            
            fp.accept(populator);
            sd.accept(wordCounter);
            
        }
        
        long finishTime = System.currentTimeMillis();
        
        long totalTime = (finishTime - startTime) / Integer.valueOf(args[2]);
        
        System.out.println("Total Time is: " + totalTime + " milliseconds. There were " + Integer.valueOf(args[2]) + " iterations.");
        
        CloneAndObserveVisitor cloner = new CloneAndObserveVisitor();
        sd.accept(cloner);
        
        StringNode node = sd.getRoot();
        BackUpNode bNode = cloner.getClonedRoot();
        while (node.getDuplicateNode() != null)
        {
            System.out.println("Regular Tree: " + node.getWord() + "     Cloned Tree: " + bNode.getWord());
            node = node.getDuplicateNode();
            bNode = bNode.getDuplicateNode();
        }
        
        VisitorInterface adder = new AddLetterVisitor();
        sd.accept(adder);
        
        node = sd.getRoot();
        bNode = cloner.getClonedRoot();
        while (node.getDuplicateNode() != null)
        {
            System.out.println("Regular Tree: " + node.getWord() + "     Cloned Tree: " + bNode.getWord());
            node = node.getDuplicateNode();
            bNode = bNode.getDuplicateNode();
        }
        
    }
    
    public void checkArgs(String[] args){
        if(args.length != 3){
            System.err.println("ERROR: Please enter 3 arguments. args[0] is " + args.length);
			System.exit(-1);
        }
		
    }
}
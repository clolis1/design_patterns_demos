package wordCount.util;
import wordCount.visitors.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class FileProcessor{
    Scanner sc = null;
    String fileName;
    
    public FileProcessor(String fileNameIn){
        fileName = fileNameIn;
        
        try{
            sc = new Scanner(new File(fileName));
        } catch(FileNotFoundException e){
            e.printStackTrace();
            System.exit(-1);
        } finally{
            
        }
    }
    
    /**
     *  This method returns true if the scanner can read a word in the file, and false otherwise.
     *  
     */
    public synchronized boolean canRead(){
        if(sc.hasNext()){
            return true;
        }
        return false;
    }
    
    /**
     *  This method reads a word from a file and returns the word as a String.
     *  
     */
    public synchronized String readNext(){
        return sc.next();
    }
    
    public String toString(){
        String ret = String.format("Input file is %s",fileName);
        return ret;
    }
    
    public void accept(VisitorInterface visitor)
    {
        visitor.visit(this);
    }
}

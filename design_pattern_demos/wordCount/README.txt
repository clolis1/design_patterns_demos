CS442 Design Patterns
Fall 2016
PROJECT 2 README FILE

Due Date: Wednesday, November 24, 2016
Submission Date: Thursday, December 1, 2016
Grace Period Used This Project: 5 Days
Grace Period Remaining: 0 Days
Author(s): Christian Lolis
e-mail(s): clolis1@binghamton.edu


PURPOSE:

  This program accepts an input file whose name is specified in the command line
  arguments. It arranges all the words in the document into a custom database
  structure. Statistics about the structure are then printed on another
  document whose name is indicated in the command line.
  
  The program runs this process a number of times (specified in the command line).
  It then gives the average speed of the process of arranging the words.
  
  The program also backs up the database with a complementary cloned structure.
  Whenever a word is changed in the original structure, there is an immediate
  update to the cloned structure.

PERCENT COMPLETE:

  I was responsible for the whole project. To my knowledge, it is 100% complete.

PARTS THAT ARE NOT COMPLETE:

  There are no parts that are incomplete.

BUGS:

None.

FILES:

  Included with this project are 12 files:
  
  build.xml, the file that helps ant compile and run the program
  Driver.java, the main file associated with the program and also contains main
  BackUpNode.java, the file which contains the format for the backup nodes
  StringDatabase.java, the file which contains the functionality for creating the database
  FileProcessor.java, the file responsible for parsing the input file
  Observer.java, an interface used to help implement the back-up functionality
  Subject.java, an interface used to help implement the back-up functionality
  AddLetterVisitor.java, a visitor which adds an X to every instance of a duplicate of the first word in the input file
  CloneAndObserveVisitor.java, a visitor which creates a back-up tree for the main database
  PopulateVisitor.java, a visitor which populates an empty database
  VisitorInterface.java, the interface for all the visitors
  WordCountVisitor.java, a visitor which collects statistics such as wordCount about the database
  README.txt, the file that you are currently reading.

SAMPLE OUTPUT:

  $ ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=10
Buildfile: /home/ubuntu/workspace/lolis_christian_assign4/wordCount/src/build.xml

jar:
      [jar] Building jar: /home/ubuntu/workspace/lolis_christian_assign4/wordCount/BUILD/jar/wordCount.jar

run:
     [java] Total Time is: 67 milliseconds. There were 10 iterations.
     [java] Regular Tree: It     Cloned Tree: It
     [java] Regular Tree: It     Cloned Tree: It
     [java] Regular Tree: It     Cloned Tree: It
     [java] Regular Tree: It     Cloned Tree: It
     [java] Regular Tree: ItX     Cloned Tree: ItX
     [java] Regular Tree: ItXX     Cloned Tree: ItXX

BUILD SUCCESSFUL
Total time: 1 second

TO COMPILE:
  
  gunzip lolis_christian_assign4.tar.gz
  tar -zxvf lolis_christian_assign4.tar
  cd lolis_christian_assign4/wordCount
  ant -buildfile src/build.xml all

TO RUN:

  ant -buildfile src/build.xml run -Darg0=[INPUT FILE] -Darg1=[OUTPUT FILE] -Darg2=[NUM ITERATIONS]
  
EXTRA CREDIT:

  N/A


BIBLIOGRAPHY:

  This serves as evidence that I am in no way intending Academic Dishonesty.
  Christian Lolis

  No code was borrowed from outside sources.

ACKNOWLEDGEMENT:

  None.
  
NOTE:

    This project is notably late. I spoke to professor Govindaraju about this
    and he offered to accomodate the lateness at no penalty if I completed the
    project by Wednesday. Although, it's technically Thursday...
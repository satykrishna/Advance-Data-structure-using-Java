

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class DatatoHeap {

    /* Variables 
     * char []Operation : it stores the sequence of inserts and deletes given in a file or 
     * the inserts and deletes that are randomly generated
     * 
     * int []inputSeq : it stores the data to be inserted in given order in a file
     * 
     * int []seqSize : it stores the number of insert and delete operations and 
     * also the how many numbers in total to be inserted
     * 
     * int randomSize : User can give the size of the random numbers to be generated
     * by which operation and inputSeq variables are intialized to this size.
     */
    
    private	int []inputseq;
    private	char []operation;
    private	int []seqSize;
    private   int randomSize;


    /*setter and getter methods for random size */
    public int getRandomSize() {
	return randomSize;
    }

    public void setRandomSize(int randomSize) {
	this.randomSize = randomSize;
    }
    
    /*Setters and getters for sequence size */

    public int[] getSeqSize() {
	return seqSize;
    }

    public void setSeqSize(File f) throws FileNotFoundException {
	Scanner scanner = new Scanner(f); 
	seqSize= new int[2];
	while(scanner.hasNext()&&!scanner.hasNext("\\*")) {
	    if(scanner.hasNext("I")||scanner.hasNext("D")) {
		seqSize[0]++;
	    }
	    if(scanner.hasNextInt()) {
		seqSize[1]++;
	    }
	    scanner.next();
	}
    }

    /*Setters and getters for seqSize */
    
    public void setSeqSize() {
	seqSize= new int[2];
	seqSize[0]=randomSize;
	seqSize[1]=randomSize;
    }
    
    
    /*initialize the operation sequence */

    public void initiateOperationSeq() {
	operation = new char[seqSize[0]];
    }

    /* intiailize the input sequence */
    public void inititateInputSeq() {
	inputseq = new int[seqSize[1]];
    }


    /*getter and setters for insert and deleteSequence from a file or in a random mode */
    @SuppressWarnings("unused")
    public char[] getOperation() {
	return operation;
    }

    @SuppressWarnings({ "unused", "resource" })
    public void setOperation(File f) throws FileNotFoundException {
	Scanner scanner = new Scanner(f);
	setSeqSize(f);
	initiateOperationSeq();
	int j=0;
	while(scanner.hasNext()&&!scanner.hasNext("\\*")) {
	    if(scanner.hasNext("I")||scanner.hasNext("D")) {
		operation[j++]=scanner.next().charAt(0);
	    }	
	    else {
		scanner.next();
	    }
	}
    }

    public void setOperation() {
	Random random = new Random();
	setSeqSize();
	initiateOperationSeq();
	int operationSequence[] = new int[randomSize];
	operationSequence[1]=operationSequence[0]=1;
	for (int i = 2; i < operationSequence.length; i++) {
	    operationSequence[i]=random.nextInt(1+1)+1;
	}

	for (int i = 0; i < operationSequence.length; i++) {
	    if(operationSequence[i]==1)
		operation[i]='I';
	    if(operationSequence[i]==2)
		operation[i]='D';
	}
    }

    /*Getters and setters for input data sequence from file or in a random mode */

    @SuppressWarnings("unused")
    public int[] getInputseq() {
	return inputseq;
    }

    @SuppressWarnings("unused")
    public void setInputseq(File f) throws FileNotFoundException {
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(f);
	inititateInputSeq();
	int j=0;
	while(scanner.hasNext()&&!scanner.hasNext("\\*")) {
	    if(scanner.hasNextInt()) {
		inputseq[j++]= scanner.nextInt();
	    }		
	    else {
		scanner.next();
	    }
	}
    }

    @SuppressWarnings("unused")
    public void setInputSeq() {
	Random random = new Random();
	setSeqSize();
	inititateInputSeq();
	for (int i = 0; i < inputseq.length; i++) {
	    inputseq[i]=i;
	}
	for(int i =0; i<inputseq.length; i++) {
	    int temp  = random.nextInt(inputseq.length);
	    if(inputseq[i]==i) {
		if(inputseq[temp]==temp) 
		    inputseq[temp]=inputseq[i];
	    }
	}
    }

}

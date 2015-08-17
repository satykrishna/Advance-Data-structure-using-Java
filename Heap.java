

import java.io.File;
import java.io.FileNotFoundException;

public class Heap {



    public static void main(String[] args) throws FileNotFoundException {

	/*A General Wrapper Class which creates Leftist Tree and Binomial Tree 
	 * from the file whose path is mentioned in the command line arguments
	 * (if given). Else Generate Random Data sequence and Operation Sequence
	 * for m = 5000 records and display the time taken.
	 */


	LeftistHeap leftistTree = new LeftistHeap();
	DatatoHeap data = new DatatoHeap();
	BinomialHeap heap = new BinomialHeap();

	/*leftistTree class is used to Generate leftist Tree and BinomialHeap class 
	 * is used to generate Binomial heap. 
	 * DatatoHeap class is a class in which provides the input to the above classes 
	 * either from a file or from a random sequence generator
	 */

	try {
	    /*create a file*/
	    File file = new File(args[0]);

	    /*Store the Given operation sequence given in the file in to an character Array*/
	    data.setOperation(file);
	    /*store the given data sequence to be inserted in a binomial heao or a tree in an integer array*/
	    data.setInputseq(file);

	    System.out.println("Min Leftist Tree is ");
	    /*construct a Tree*/
	    leftistTree.constructLeftistTree(data.getOperation(), data.getInputseq());
	    /*level Order Traversal */
	    leftistTree.levelOrder();

	    /*construct a Bionmial heap */
	    heap.constructHeap(data.getOperation(), data.getInputseq());
	    System.out.println();
	    System.out.println("Binomial Tree is");
	    /*level order traversal*/
	    heap.levelOrder();


	}catch(ArrayIndexOutOfBoundsException e ) {

	    /*initialize the character array and integer array of the given random size */
	    data.setRandomSize(5000);
	    double lAvgTime=0, hAvgTime=0;

	    /* Random Input and Insert and delete Operations are generated over 5000 times and 
	     * average time is calculated to generate the LeftistTree and Binomial heap
	     */

	    for(int i = 0; i<5; i++) {
		
		/*sequence of inserts and delete operations  and random input data is generated*/
		
		data.setOperation();
		data.setInputSeq();
		
		double lstart = 0;
		lstart = System.nanoTime();
		/*construct a leftist tree using above generated data*/
		leftistTree.constructLeftistTree(data.getOperation(), data.getInputseq());
		double lstop  = System.nanoTime();
		double ltime =  ((lstop -lstart)/1e6);
		lAvgTime+=ltime;// Average time to generate the MinLeftist Tree
		double hstart = 0;
		hstart = System.nanoTime();
		heap.constructHeap(data.getOperation(), data.getInputseq());
		double hstop  = System.nanoTime();
		double htime =  ((hstop -hstart)/1e6);
		hAvgTime+=htime;//Average time to generate Binomial heap
	    }

	    System.out.println("Time to construct Leftist Tree (in milli Seconds) = "+lAvgTime/5);
	    System.out.println("Time to construct Bionmial Heap (in milli Seconds) = "+hAvgTime/5);
	}




    }



}

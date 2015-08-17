

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class LeftistHeap {

    
    private LeftHeapNode root;

    /* Default Constructor */

    public LeftistHeap() {
	root=null;
    }

    /*checks if heap is empty*/

    public boolean isEmpty() {
	return root==null;
    }


    /*Clear the root */
    
    public void clear() {
	root=null;
    }
    
    /*insert operation */

    public void insert(int x) {
	root= merge(new LeftHeapNode(x), root);
    }

    //Merge operation
    
    public void merge(LeftistHeap rhs) {
	if(this==rhs) {
	    return;
	}
	root=merge(root, rhs.root);
	rhs.root=null;
    }

    /** Function merge **/

    public LeftHeapNode merge(LeftHeapNode x, LeftHeapNode y)  {
	if (x == null)
	    return y;
	if (y == null)
	    return x;
	if (x.data	 >  y.data){
	    LeftHeapNode temp = x;
	    x = y;
	    y = temp;
	}
	x.right = merge(x.right, y);
	if(x.left == null) {
	    x.left = x.right;
	    x.right = null;         
	} 
	else {
	    if(x.left.sValue < x.right.sValue){
		LeftHeapNode temp = x.left;
		x.left = x.right;
		x.right = temp;
	    }
	    x.sValue = x.right.sValue + 1;
	}        
	return x;
    }



    /** Function to delete minimum element **/

    public int deleteMin( ) {
	if (isEmpty() )
	    return -1;
	int minItem = root.data;
	root = merge(root.left, root.right);
	return minItem;
    }

   /*Display the Level order Tree using stacks*/
    
    public void levelOrder() {
	LeftHeapNode temp;
	int level =1;
	int lefttoRight =1 ;
	if(root==null)
	    return;
	Stack<LeftHeapNode> currentLevel = new Stack<LeftHeapNode>();
	Stack<LeftHeapNode> nextLevel = new Stack<LeftHeapNode>();
	Stack<LeftHeapNode> tempStack = new Stack<LeftHeapNode>();
	currentLevel.push(root);
	while(!currentLevel.isEmpty()) {
	    temp = currentLevel.pop();
	    if(temp!=null) {
		System.out.print("level "+level+ ": ["+ temp.data+ "] ");
		if(lefttoRight==1){
		    if(temp.left!=null)
			nextLevel.push(temp.left);
		    if(temp.right!=null)
			nextLevel.push(temp.right);
		}
		else {
		    if(temp.right!=null)
			nextLevel.push(temp.right);
		    if(temp.left!=null)
			nextLevel.push(temp.left);
		}
	    }
	    if(currentLevel.isEmpty()) {
		lefttoRight=0;
		level++;
		tempStack = currentLevel;
		currentLevel= nextLevel;
		nextLevel=tempStack;
		System.out.println();
	    }
	}

    }

    /*construct a LeftistTree from given array of input data and insert and delete operations*/
    
    public void constructLeftistTree(char a[], int b[]) {
	int j=0;
	for (int i = 0; i < a.length; i++) {
	    if(a[i]=='I') {
		this.insert(b[j++]);
	    }
	    if(a[i]=='D') {
		this.deleteMin();
	    }
	}
    }
}

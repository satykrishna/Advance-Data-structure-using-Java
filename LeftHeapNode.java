

public class LeftHeapNode {

    /*Structure of a LeftHeap Node */
    int data;
    int sValue;
    LeftHeapNode left, right;

    public LeftHeapNode(int data) {
	this.data=data;
	this.sValue =0;
	this.left=this.right=null;
    }
    public LeftHeapNode(int data, LeftHeapNode left, LeftHeapNode right) {
	this.data=data;
	this.left=left;
	this.left=right;
	this.sValue=0;
    }


}



/*A Queue is generated using LinkedList called ListNode. The structure of a LinkedListNode is defined here*/


public class ListNode {

    /* stores the data of the type LeftHeap Node */
    
    LeftHeapNode node;
    ListNode next;

    public ListNode() {
	this.node=null;
	this.next=null;
    }
    
    /*over loaded constructor */

    public ListNode(LeftHeapNode data) {
	this.node=data;
	this.next=null;
    }


}

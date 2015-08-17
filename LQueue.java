


/*Create a queue using the basic memory pointers and which stores LeftHeapNode */

/*Structure for a queue */
public class LQueue {

    ListNode front;
    ListNode rear;

    public LQueue() {
	this.front=this.rear=null;
    }

    /*checks if Queue is Empty*/
    public boolean isQueueEmpty() {
	return(this.front==null);
    }
    
    //Enqueue operation
    public	void enQueue(LeftHeapNode data) {
	ListNode newNode = new ListNode(data);
	if(rear==null) {
	    rear=newNode;
	}
	else {
	    this.rear.next=newNode;
	    this.rear =  newNode;
	}
	if(this.front==null) {
	    this.front=this.rear;
	}

    }
    
    //dequeue from queue

    public	LeftHeapNode deQueue() {
	if(isQueueEmpty())
	    return null;
	else {
	    ListNode temp = this.front;
	    LeftHeapNode data = this.front.node;
	    this.front=this.front.next;
	    temp=null;
	    return data;
	}
    }
    
    //deletes the queue

    public void deleteQueue() {
	if(this!=null) {
	    ListNode current=this.front;
	    while(current!=null) {
		ListNode temp = current;
		current=current.next;
		temp=null;
	    }
	}

    }
}

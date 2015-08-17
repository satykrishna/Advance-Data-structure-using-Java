Advance Data Structure using JAVA
=================================

Problem Description
-------------------
This project implements min binomial heap and min leftist tree and measure and compare the relative performance of these two implementations under the assumption that the only permissible operations are insert and delete-min.

Programming Language 
--------------------
Java

Files Associated
----------------

<i><b>Heap.java</b></i> : The file contains the main function and initiates the execution<br><br><br>
<i><b>DatatoHeap.java</b></i>: The class converts the raw data from a given file and store the insert and delete operations in a Character array and data to be inserted in an integer array.<br><br><br>
<i><b>LeftHeapNode.java</b>  </i>: The class implements a Leftist Tree node. It stores the data as well as link to its two children. Along with them, it also stores the the shortest external path length.<br><br><br>
<i><b>LQueue.java </b></i>: The class implements a Queue to store and display the leftist tree nodes in breadth first manner. Enqueue and Dequeue are the methods which have been implemented. This Queue is implemented using LinkedList<br><br><br>
<i><b>LeftistHeap.java </b></i>: This class implements the Min Leftist Tree. It uses the Node objects to create a linked tree structure. The methods which have been implemented are insert, deleteMin, merge and LevelOrder. The data structure uses the Queue object to print the tree. <br><br><br>
<i><b>BinomialHeapNode.java </b></i> : The class implements a Binomial Node. The attributes are the data element, link to the next Binomial node in the circular linked list and the link to one of the child node of this binomial node. It also contains a degree field which denotes the number of children of this binomial node. <br><br><br>
<i><b> BinomialHeap.java</b></i> : This class implements a Min Binomial Heap. It provides a linked heap structure using Binomial Node object to store the elements. Insert and DeleteMin are the two important functions which have been implemented. <br><br><br>
<i><b> ListNode.java</b></i>: This class describes the LinkedList node structure. It stores data and provides link to its immediate next.<br><br><br>

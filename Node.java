public class Node {

     private int data;
     private Node next;
     private Node previous;

     public Node(int val, Node n, Node p) {
          data = val;
          next = n;
          previous = p;
     }

     public int getData() {
          return data;
     }

     public void setNext(Node newNext) {
          next = newNext;
     }

     public void setPrevious(Node newPrevious) {
          previous = newPrevious;
     }

     public Node getNext() {
          return next;
     }

     public Node getPrevious() {
          return previous;
     }

}

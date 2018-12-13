public class Node {

     private Integer data;
     private Node next;
     private Node prev;

     public Node(Integer val, Node n, Node p) {
          data = val;
          next = n;
          prev = p;
     }

     public Node next() {
          return next;
     }

     public Node prev() {
          return prev;
     }

     public void setData(Integer newData) {
          data = newData;
     }

     public void setNext(Node other) {
          next = other;
     }

     public void setPrev(Node other) {
          prev = other;
     }

     public String toString() {
          return "Node: " + data;
     }

}

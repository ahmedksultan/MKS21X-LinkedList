public class MyLinkedList {

     /* INSTRUCTIONS
     Fields -
          :Node start, end
          :int length
     Constructor -
          :MyLinkedList()
     Methods -
          :boolean add(Integer value)
          int size()
          String toString() ///get(INDEX)!!!
          Integer get(int index)
          Integer set(int index,Integer value)
          boolean contains(Integer value)
          int indexOf(Integer value)
          void add(int index,Integer value)
          Integer remove(int index)
          boolean remove(Integer value) ///PRIVATE!!!
     */

     private Node start;
     private Node end;
     private int length;

     public MyLinkedList() {
          length = 0;
          start = null;
          end = null;
     }

     public boolean add(Integer value) {
          //create new node >>> add to MyLinkedList
          Node temp = new Node(value, null, null);
          if (length == 0) {
               //if the length is 0 (empty), start&end both new node
               start = temp;
               end = temp;
          }
          else {
               //current end sets next, new end sets previous
               end.setNext(temp);
               temp.setPrev(end);
               //added node is now new end
               end = temp;
          }
          //method complete:
          length = length+1;
          return true;
     }
}

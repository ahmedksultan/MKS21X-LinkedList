public class MyLinkedList {

     public static void main(String[] args) {
          MyLinkedList test = new MyLinkedList();
          System.out.println(test);
          test.add(30);
          System.out.println(test);
          test.add(64);
          System.out.println(test);
          test.add(67);
          test.add(99);
          test.add(4);
          test.add(101);
          System.out.println(test);
          System.out.println(test.size());
          System.out.println(test.get(3));
          System.out.println(test.set(3, 7));
          System.out.println(test);
          System.out.println(test.contains(99));
          System.out.println(test.contains(7));
          System.out.println(test.indexOf(99));
          System.out.println(test.indexOf(7));
          System.out.println(test.remove(3));
          System.out.println(test);
     }

     /* INSTRUCTIONS
     Fields -
          :Node start, end
          :int length
     Constructor -
          :MyLinkedList()
     Methods -
          :boolean add(Integer value)
          :int size()
          :String toString() ///get(INDEX)!!!
          :Integer get(int index)
          :Integer set(int index,Integer value)
          :boolean contains(Integer value)
          :int indexOf(Integer value)
          ...void add(int index,Integer value)
          :Integer remove(int index)
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

     private Node getNthNode(int n) {
          if (n >= length || n < 0) {
               throw new IndexOutOfBoundsException("Error! Index out of bounds: " + n);
          }
          Node temp = start;
          for (int idx = 0; idx < n; idx++) {
               temp = temp.next();
          }
          return temp;
     }

     public boolean add(Integer value) {
          //create new node >>> add to MyLinkedList
          Node temp = new Node(value, null, null);
          if (length == 0) {
               //if the length is 0 (empty), start&end both new node
               start = temp;
               end = start;
               length = length+1;
               return true;
          }
          /* long code unnecessary
          else if (length == 1) {
               end = temp;
               end.setPrev(temp);
               start.setNext(end);
               length = length+1;
               return true;
          }
          else {
               //current end sets next, new end sets previous
               temp.setPrev(end);
               end.setNext(temp);
               end = temp;
               //added node is now new end
               length = length+1;
               return true;
          }
          */
          else {
               end.setNext(temp);
               temp.setPrev(end);
               end = end.next();
               length = length+1;
               return true;
          }
     }

     public int size() {
          return length;
     }

     public String toString() {
          String result = "[";
          if (length == 0) {
               result = result + "]";
          }
          else {
               Node current = start;
               for (int i = 1; i < length; i++) {
                    result = result + current + ", ";
                    current = current.next();
               }
               result = result + end + "]";
          }
          return result;
     }

     public Integer get(int index) {
          //need exception just in case user/program calls outside of list limits
          if (index >= length || index < 0) {
               throw new IndexOutOfBoundsException("Error! Index out of bounds: " + index);
          }
          return getNthNode(index).getData();
     }

     public Integer set(int index, Integer val) {
          if (index >= length || index < 0) {
               throw new IndexOutOfBoundsException("Error! Index out of bounds: " + index);
          }
          return getNthNode(index).setData(val);
     }

     public boolean contains(Integer val) {
          for (int i = 0; i < length; i++) {
               if (getNthNode(i).getData() == val) {
                    return true;
               }
          }
          return false;
     }

     public int indexOf(Integer val) {
          for (int i = 0; i < length; i++) {
               if (getNthNode(i).getData() == val) {
                    return i;
               }
          }
          return -1;
     }

     public Integer remove(int index) {
          if (index >= length || index < 0) {
               throw new IndexOutOfBoundsException("Error! Index out of bounds: " + index);
          }
          Node target = getNthNode(index);
          if (length == 1) {
               start = null;
               end = null;
          }
          else if (index == 0) {
               start = target.next();
          }
          else if (index == length - 1) {
               end = target.prev();
          }
          else {
               target.prev().setNext(target.next());
               target.next().setPrev(target.prev());
          }
          length--;
          return target.getData();
     }

}

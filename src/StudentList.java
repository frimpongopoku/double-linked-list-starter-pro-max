import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentList implements IDisplayable {
    private Node head = new Node(), tail = new Node();
    private int length = 0;

    public StudentList() {
    }


    public Student findById(int id) {
        int count = 0;
        Node node = head.next;
        while (count < length - 1) {
            if (node.data != null && id == node.data.getId()) return node.data;
            node = node.next;
            count++;
        }
        return null;
    }

    public Student findByName(String name) {
        int count = 0;
        Node node = head.next;
        while (count < length - 1) {
            if (node.data != null && name.equals(node.data.getName())) return node.data;
            node = node.next;

            count++;
        }
        return null;
    }


    public void insert(Node n, int position) {
        if (length == 0) {
            head.next = n;
            tail.previous = n;
        } else {
            int count = 0;
            Node node = head.next;
            while (count < position) {
                node = node.next;
                count++;
            }
            node.previous.next = n;
            n.previous = node.previous;
            n.next = node;
            node.previous = n;
        }
        length++;
    }

    public void delete(int position) {

        if (length == 1) {
            head.next = tail;
            tail.previous = head;
            length = 0;
        }

        if (position < 0 || position > length - 1) {
            System.out.println(String.format("The node you want to delete at position %s is out of range", position));
        }

        int count = 0;
        Node node = head.next;

        while (count < position) {
            node = node.next;
            count++;
        }
//        Node previous = node.previous;
//        Node next = node.next;
        node.previous.next = node.next;
        node.next.previous = node.previous;
        length--;

    }

    public void saveToFile(String filename){
        try (PrintWriter output = new PrintWriter(filename)) {
            output.print(this.toString());
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void display() {
        Node node = head.next;
        int count = 0;
        while (count <= length) {
            if (node.previous != null && node.next != null) {
                node.data.display();
                System.out.println("...............");
            }
            node = node.next;
            count++;
        }
    }


    public String toString(){
        String string ="";
        Node node = head.next;
        int count = 0;
        while (count <= length) {
            if (node.previous != null && node.next != null) {
                string += "\n"+node.data.toString();
            }
            node = node.next;
            count++;
        }
        return string;
    }

    public Node createDummyList() {

        Node node1 = new Node(new Student("Monday Guy", "full-time", 1));

        Node node2 = new Node(new Student("Tuesday Guy", "part-time", 2));

        Node node3 = new Node(new Student("Wednesday Guy", "part-time", 3));

        Node node4 = new Node(new Student("Thursday Guy", "full-time", 4));

        Node node5 = new Node(new Student("Friday Guy", "full-time", 5));

        Node node6 = new Node(new Student("Saturday Guy", "part-time", 6));
        head.next = node1;
        node1.previous = head;
        node1.next = node2;
        node2.previous = node1;
        node2.next = node3;
        node3.previous = node2;
        node3.next = node4;
        node4.previous = node3;
        node4.next = node5;
        node5.previous = node4;
        node5.next = node6;
        node6.previous = node5;
        node6.next = tail;
        tail.previous = node6;
        length = 6;
        return head;
    }
}

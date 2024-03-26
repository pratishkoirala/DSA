// Node structure for singly linked list
class SinglyNode {
    int data;
    SinglyNode next;

    SinglyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Implementation of Singly Linked List
class SinglyLinkedList {
    SinglyNode head;

    SinglyLinkedList() {
        this.head = null;
    }

    // Insertion at the end of the singly linked list
    void insert(int value) {
        SinglyNode newNode = new SinglyNode(value);
        if (head == null) {
            head = newNode;
        } else {
            SinglyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Displaying the singly linked list
    void display() {
        SinglyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Searching for an element in the singly linked list
    boolean search(int value) {
        SinglyNode temp = head;
        while (temp != null) {
            if (temp.data == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Deletion of a node with given value from the singly linked list
    void delete(int value) {
        if (head == null)
            return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        SinglyNode temp = head;
        SinglyNode prev = null;
        while (temp != null && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        prev.next = temp.next;
    }
}

// Node structure for doubly linked list
class DoublyNode {
    int data;
    DoublyNode prev, next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

// Implementation of Doubly Linked List
class DoublyLinkedList {
    DoublyNode head;

    DoublyLinkedList() {
        this.head = null;
    }

    // Insertion at the end of the doubly linked list
    void insert(int value) {
        DoublyNode newNode = new DoublyNode(value);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Displaying the doubly linked list
    void display() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Searching for an element in the doubly linked list
    boolean search(int value) {
        DoublyNode temp = head;
        while (temp != null) {
            if (temp.data == value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Deletion of a node with given value from the doubly linked list
    void delete(int value) {
        if (head == null)
            return;

        if (head.data == value) {
            head = head.next;
            if (head != null)
                head.prev = null;
            return;
        }

        DoublyNode temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Singly linked list operations
        SinglyLinkedList singlyList = new SinglyLinkedList();
        singlyList.insert(1);
        singlyList.insert(2);
        singlyList.insert(3);
        System.out.print("Singly linked list: ");
        singlyList.display();
        int searchValue = 2;
        if (singlyList.search(searchValue))
            System.out.println(searchValue + " found in singly linked list.");
        else
            System.out.println(searchValue + " not found in singly linked list.");
        int deleteValue = 2;
        singlyList.delete(deleteValue);
        System.out.print("After deleting " + deleteValue + " from singly linked list: ");
        singlyList.display();

        // Doubly linked list operations
        DoublyLinkedList doublyList = new DoublyLinkedList();
        doublyList.insert(1);
        doublyList.insert(2);
        doublyList.insert(3);
        System.out.print("Doubly linked list: ");
        doublyList.display();
        searchValue = 2;
        if (doublyList.search(searchValue))
            System.out.println(searchValue + " found in doubly linked list.");
        else
            System.out.println(searchValue + " not found in doubly linked list.");
        deleteValue = 2;
        doublyList.delete(deleteValue);
        System.out.print("After deleting " + deleteValue + " from doubly linked list: ");
        doublyList.display();
    }
}

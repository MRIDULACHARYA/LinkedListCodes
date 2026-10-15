class SinglyLinkedList {

    Node head;
    int size = 0;

    class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            next = null;
        }
    }

    void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    void addLast(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        size++;
    }

    void insertAt(int index, Object data) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    Object get(int index) {
        if (index < 0 || index >= size) return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    void update(int index, Object data) {
        if (index < 0 || index >= size) return;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.data = data;
    }

    void deleteFirst() {
        if (head == null) return;

        head = head.next;
        size--;
    }

    void deleteLast() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }

        size--;
    }

    void deleteAt(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    boolean search(Object data) {
        Node temp = head;

        while (temp != null) {
            if (java.util.Objects.equals(temp.data, data)) return true;
            temp = temp.next;
        }

        return false;
    }

    int length() {
        return size;
    }

    void reverse() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        head = prev;
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    void clear() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addLast("Hello");
        list.insertAt(1, 15);

        list.display();
        System.out.println("Length: " + list.length());
        System.out.println("Search 20: " + list.search(20));
        System.out.println("Element at index 2: " + list.get(2));

        list.deleteAt(1);
        list.display();

        list.reverse();
        list.display();
    }
}

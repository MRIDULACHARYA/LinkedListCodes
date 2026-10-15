class DoublyLinkedList {

    Node head;
    Node tail;
    int size = 0;

    class Node {
        Object data;
        Node next;
        Node prev;

        Node(Object data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    void addFirst(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    void addLast(Object data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    void insertAt(int index, Object data) {
        if (index < 0 || index > size) return;

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
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

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    void deleteLast() {
        if (tail == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    void deleteAt(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
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
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = temp.prev;
            temp.prev = nextNode;
            temp = nextNode;
        }

        Node tempHead = head;
        head = tail;
        tail = tempHead;
    }

    void displayForward() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    void displayBackward() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }

        System.out.println("null");
    }

    void clear() {
        head = tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addLast("Hello");
        list.insertAt(1, 15);

        list.displayForward();
        System.out.println("Length: " + list.length());
        System.out.println("Search 20: " + list.search(20));

        list.deleteAt(1);
        list.displayForward();
        list.displayBackward();

        list.reverse();
        list.displayForward();
    }
}

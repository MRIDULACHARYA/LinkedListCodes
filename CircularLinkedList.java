class CircularLinkedList {

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

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }

        size++;
    }

    void addLast(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
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

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            head = head.next;
            temp.next = head;
        }

        size--;
    }

    void deleteLast() {
        if (head == null) return;

        if (head.next == head) {
            head = null;
        } else {
            Node temp = head;

            while (temp.next.next != head) {
                temp = temp.next;
            }

            temp.next = head;
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
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    boolean search(Object data) {
        if (head == null) return false;

        Node temp = head;

        do {
            if (java.util.Objects.equals(temp.data, data)) return true;
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    int length() {
        return size;
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    void clear() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

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

        list.clear();
        list.display();
    }
}

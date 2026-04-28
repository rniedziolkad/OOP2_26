public class CustomList {
    private static class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public CustomList() {
        this.head = this.tail = null;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (this.tail == null) {
            this.tail = this.head = newNode; // była pusta lista, jest 1 element
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public int getLast() {
        if (this.tail == null) {
            throw new RuntimeException("Lista jest pusta");
        }
        return this.tail.value;
    }



}

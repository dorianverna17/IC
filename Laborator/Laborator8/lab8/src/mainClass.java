public class mainClass {
    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();

        for (int i = 0; i < 10; i++) {
            myList.addNode(i);
        }

        for (int i = 0; i < 4; i++) {
            myList.deleteNode(i * 2 + 1);
        }

        if (!myList.containsNode(4)) {
            System.exit(1);
        }

        if (myList.containsNode(7)) {
            System.exit(1);
        }
    }
}

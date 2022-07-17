/**
 * Add Two Numbers!
 * <p>
 * The AddNum program implements a
 * Circular Linked List
 * </p>
 *
 * @author  Zara Ali
 * @version 1.0
 * @since   2014-03-31
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * This method is used to add a node to the list
     * @param value retained by the node
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * This method is used to search for a node
     * @param searchValue This is the value we try to search
     * @return boolean Returns whether the node with that value
     * is in the list or not
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * This method is used to delete a node
     * @param valueToDelete value of the node that we should delete
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * This method is used to return the next node in the list
     * @param currentNode the current node
     * @return the next node
     */
    public Node getNextNode(Node currentNode) {
        if (currentNode != null) {
            if (currentNode.nextNode != null)
                return currentNode.nextNode;
        }
        return null;
    }
}
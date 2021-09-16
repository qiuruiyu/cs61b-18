public class LinkedListDeque<T> implements Deque<T> {

    /**
     * basic data structure of single Node
     */
    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;

        /**
         * Constructor
         */
        public IntNode(T i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /**
     * global variables
     */
    private int size = 0;
    private IntNode sentF;
    private IntNode sentB;

    /**
     * Create a new LinkedListDeque
     */
    public LinkedListDeque() {
        sentF = new IntNode(null, null, null);
        sentB = new IntNode(null, null, null);
        sentF.prev = sentB;
        sentF.next = sentB;
        sentB.next = sentF;
        sentB.prev = sentF;
    }

    /**
     * Add first item to Deque
     */
    @Override
    public void addFirst(T item) {
        IntNode nextNode = sentF.next;
        IntNode node = new IntNode(item, sentF, nextNode);
        sentF.next = node;
        nextNode.prev = node;
        size += 1;
    }

    /**
     * Add last item to Deque
     */
    @Override
    public void addLast(T item) {
        IntNode prevNode = sentB.prev;
        IntNode node = new IntNode(item, prevNode, sentB);
        sentB.prev = node;
        prevNode.next = node;
        size += 1;
    }

    /**
     * Judge whether the Deque is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Return the size of Deque
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Print all items in the Deque
     */
    @Override
    public void printDeque() {
        IntNode ptr = sentF;
        for (int i = 0; i < size; i++) {
            System.out.println(ptr.next.item);
            ptr = ptr.next;
        }
    }

    /**
     * Remove and return the first item of Deque
     */
    @Override
    public T removeFirst() {
        IntNode removeNode = sentF.next;
        if (removeNode.item == null) {
            return null;
        }
        IntNode targetNode = removeNode.next;
        sentF.next = targetNode;
        targetNode.prev = sentF;
        size -= 1;
        return removeNode.item;
    }

    /**
     * Remove and re
     * turn the last item of Deque
     */
    @Override
    public T removeLast() {
        IntNode removeNode = sentB.prev;
        if (removeNode.item == null) {
            return null;
        }
        IntNode targetNode = removeNode.prev;
        sentB.prev = targetNode;
        targetNode.next = sentB;
        size -= 1;
        return removeNode.item;
    }

    /**
     * Get the index-th item of Deque iteratively
     * 0 is front, 1 is first
     * if no such item, return null
     */
    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            IntNode ptr = sentF;
            while (index >= 0) {
                ptr = ptr.next;
                index -= 1;
            }
            return ptr.item;
        }
    }

    /**
     * Get the index-th item of Deque recursively
     */
    @Override
    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        } else {
            return getR(sentF.next, index);
        }
    }

    private T getR(IntNode node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getR(node.next, index - 1);
    }
}


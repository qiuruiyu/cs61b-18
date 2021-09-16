public class ArrayDeque<T> {

    /**
     * global variables
     */
    private T[] items;
    private int size;
    private int rFactor;
    private int nextFirst;
    private int nextLast;

    /**
     * Create a new ArrayDeque
     */
    /*
     0 1 2 3 4 5 6 7 8
    [0 0 0 0 0 0 0 0 0]
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 2;
        nextLast = 3;
        rFactor = 2;
    }

    /**
     * Copy the origin items to newer items
     */
    private void copyArray(T[] copiedItems, String input) {
        int preNextFirst = nextFirst;
        int preNextLast = nextLast;
        if (input.equals("smaller")) {
            nextFirst = 0;
            nextLast = size + 1;
        }
        int idx = nextFirst + 1;
        if (preNextLast > preNextFirst) {
            for (int i = preNextFirst + 1; i < preNextLast; i++) {
                copiedItems[idx] = items[i];
                idx += 1;
            }
        } else {
            for (int i = preNextFirst + 1; i < items.length + preNextLast; i++) {
                copiedItems[idx % copiedItems.length] = items[(i + items.length) % items.length];
                idx += 1;
            }
            nextLast = idx;
        }
        items = copiedItems;
    }

    /**
     * Resize the items array when needed
     */
    private void resize(String input) {
        if (input.equals("larger")) {
            T[] copiedItems = (T[]) new Object[items.length * rFactor];
            copyArray(copiedItems, input);
        } else if (input.equals("smaller")) {
            T[] copiedItems = (T[]) new Object[size * 3];
            copyArray(copiedItems, input);
        }

    }

    /**
     * Add first item to Deque
     */
    public void addFirst(T item) {
        if (size + 1 >= items.length) {
            /* Adjust the items Array */
            resize("larger");
        }
        items[nextFirst] = item;
        if (nextFirst > 0) {
            nextFirst -= 1;
        } else {
            nextFirst = items.length - 1;
        }
        size += 1;
    }

    /**
     * Add last item to Deque
     */
    public void addLast(T item) {
        if (size + 1 >= items.length) {
            /* Adjust the items Array */
            resize("larger");
        }
        items[nextLast] = item;
        if (nextLast < items.length - 1) {
            nextLast += 1;
        } else {
            nextLast = 0;
        }
        size += 1;
    }

    /**
     * Judge whether the Deque is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Return the size of the Deque
     */
    public int size() {
        return size;
    }

    /*** Print all items in the Deque */
    public void printDeque() {
        if (nextLast > nextFirst) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.println(items[i]);
            }
        } else {
            for (int i = nextFirst; i < nextLast + items.length; i++) {
                System.out.println(items[(i + items.length) % items.length]);
            }
        }
    }

    /**
     * Remove and return the first item of Deque
     */
    public T removeFirst() {
        if ((nextFirst + 1) % items.length == nextLast) {
            return null;
        } else {
            T res = items[(nextFirst + 1) % items.length];
            nextFirst = (nextFirst + 1) % items.length;
            items[nextFirst] = null;
            size -= 1;
            if (size * 4 <= items.length && size != 0) {
                resize("smaller");
            }
            return res;
        }
    }

    /**
     * Remove and return the last item of Deque
     */
    public T removeLast() {
        if ((nextLast - 1 + items.length) % items.length == nextFirst) {
            return null;
        } else {
            T res = items[(nextLast - 1 + items.length) % items.length];
            nextLast = (nextLast - 1 + items.length) % items.length;
            items[nextLast] = null;
            size -= 1;
            if (size * 4 <= items.length && size != 0) {
                resize("smaller");
            }
            return res;
        }
    }

    /**
     * Get the index-th item of Deque iteratively
     * if no such item, return null
     */
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else if (nextFirst < nextLast) {
            return items[nextFirst + index + 1];
        } else {
            return items[(nextFirst + index + 1 + items.length) % items.length];
        }
    }
}


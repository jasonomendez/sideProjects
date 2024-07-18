import java.lang.reflect.Array;
import java.util.Arrays;

public class LinkedList<T> {
    private Node<T> head;

    // Inner class to represent a node in the linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to add elements to the linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    // Method to get the size of the linked list
    public int getSize() {
        int size = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    // Method to convert the linked list to an array
    @SuppressWarnings("unchecked")
    public T[] toArray(Class<T> clazz) {
        int size = getSize();
        T[] array = (T[]) Array.newInstance(clazz, size);
        Node<T> currentNode = head;
        int index = 0;

        while (currentNode != null) {
            array[index++] = currentNode.data;
            currentNode = currentNode.next;
        }

        return array;
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        Integer[] intArray = intList.toArray(Integer.class);
        System.out.println(Arrays.toString(intArray)); // Output: [1, 2, 3]

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        String[] strArray = stringList.toArray(String.class);
        System.out.println(Arrays.toString(strArray)); // Output: [a, b, c]
    }
}


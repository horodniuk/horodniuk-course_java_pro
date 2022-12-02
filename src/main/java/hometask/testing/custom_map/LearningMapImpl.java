package hometask.testing.custom_map;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class LearningMapImpl implements LearningMap {
    private Node<Integer, String>[] array;
    private int size;

    public LearningMapImpl(int initialCapacity) {
        if (initialCapacity > 0) {
            array = new Node[initialCapacity];
        }
    }

    @Override
    public void put(Integer key, String value) {
        int index = key.hashCode() % array.length;
        Node<Integer, String> current = array[index];
        while (current != null && current.next != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        if (current == null) {
            array[index] = new Node<>(key, value);
        } else {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current.next = new Node<>(key, value);
        }
        size++;

    }

    @Override
    public String get(Integer key) {
        int index = key.hashCode() % array.length;
        Node<Integer, String> current = array[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.next;
        }
        return null;
    }

    static class Node<Integer, String> {
        private Integer key;
        private String value;
        private Node<Integer, String> next;

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node<Integer, String>[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }
}

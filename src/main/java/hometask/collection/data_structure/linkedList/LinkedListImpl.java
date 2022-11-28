package hometask.collection.data_structure.linkedList;


import hometask.collection.data_structure.MyLIst;

public class LinkedListImpl implements MyLIst {
    private Item first;
    private Item last;
    private int size;

    @Override
    public boolean add(Object element) {
        if (size == 0) {
            size++;
            first = new Item(element);
        } else {
            int counter = 0;
            Item currentItem = first;
            while (counter < size) {
                if (counter == size - 1) {
                    last = currentItem;
                    break;
                } else {
                    counter++;
                    currentItem = currentItem.next;
                }
            }
            size++;
            last.next = new Item(element);
        }
        return true;
    }

    @Override
    public Object get(int index) {
        Item currentItem = first;
        for (int i = 0; i < index; i++) {
            currentItem = currentItem.next;
        }
        return currentItem.next;
    }

    @Override
    public boolean remove(Object o) {
        Pair pair = findPair(o);
        if (pair != null) {
            if (pair.current == first && pair.current == last) {
                first = null;
                last = null;
            } else if (pair.current == first) {
                first = pair.current.next;
            } else {
                pair.previous.next = pair.current.next;
                if (pair.current == last) {
                    last = pair.previous;
                }
            }
            size--;
            return true;
        }
        return false;
    }

    private Pair findPair(Object o) {
        Item previous = first;
        Item current = first;
        while (current != null) {
            if (current.value == o) {
                return new Pair(previous, current);
            } else {
                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        Item current = first;
        while (current != null) {
            result[index++] = current.value;
            current = current.next;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        first = last = null;
    }

    private static class Item {
        private Object value;
        private Item next;

        private Item(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                   "value=" + value +
                   ", next=" + next +
                   '}';
        }
    }

    private static class Pair {
        private Item previous;
        private Item current;

        private Pair(Item previous, Item current) {
            this.previous = previous;
            this.current = current;
        }
    }
}

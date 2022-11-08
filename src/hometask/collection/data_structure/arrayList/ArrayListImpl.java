package hometask.collection.data_structure.arrayList;

import hometask.collection.data_structure.MyLIst;

import java.util.Arrays;

public class ArrayListImpl implements MyLIst {
    private Object[] array;
    private int currentCount;

    public ArrayListImpl() {
        array = new Object[5];
    }

    @Override
    public boolean add(Object e) {
        if (currentCount == array.length) {
            increaseArrayLength(array.length == 0 ? currentCount : array.length * 2);
        }
        array[currentCount++] = e;
        return true;
    }

    private void increaseArrayLength(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            removeByIndex(index);
            return true;
        } else {
            return false;
        }
    }

    private int indexOf(Object value) {
        for (int i = 0; i < currentCount; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (index < currentCount) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Array size - " + size() + ". You try get index - " + index);
        }
    }

    private void removeByIndex(int index) {
        if (index < currentCount - 1) {
            System.arraycopy(array, index + 1, array, index, currentCount - 1 - index);
        }
        currentCount--;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, currentCount);
    }

    @Override
    public boolean isEmpty() {
        return currentCount == 0;
    }

    @Override
    public int size() {
        return currentCount;
    }

    @Override
    public void clear() {
        currentCount = 0;
        array = new Object[5];
    }
}

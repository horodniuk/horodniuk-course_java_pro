package hometask.multithreading.petrol_station;

import java.util.Vector;

public class ThreadSafeList<E> {
    private final Vector<E> threadSafeList;

    public ThreadSafeList() {
        this.threadSafeList = new Vector<E>();
    }

    public void add(E element) {
        threadSafeList.add(element);
    }

    public void remove(E element) {
        threadSafeList.remove(element);
    }

    public E get(int index) {
        return threadSafeList.get(index);
    }
}

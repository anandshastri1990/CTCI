package arrays;

public class ArrayList<T> {
    private T[] list = (T[]) new Object[10];
    private int size = 0;

    public void add(T a) {
        if (size == list.length - 1) {
            T[] temp =  (T[]) new Object[list.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
        list[size] = a;
        size++;
    }

    public T get(int i) {
        if (i > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return list[i];
    }

    public boolean contains(T a) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(a)) {
                return true;
            }
        }

        return false;
    }

    public void remove(int i) {
        if (i > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int j = i; j < size; j++) {
            list[j] = list[j + 1];
        }

        size--;
    }

    public int getSize() {
        return size;
    }
}

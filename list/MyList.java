package list;

public class MyList<T> {
    private int capacity;
    private T[] list;

    public MyList() {
        this.capacity = 10;
        setList(new Object[this.capacity]);
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        setList(new Object[this.capacity]);
    }

    public int getCapacity() {
        return capacity;

    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getList() {
        return list;
    }

    public void setList(Object[] list) {
        this.list = (T[]) list;
    }

    public int size() {
        int numberOfElement = 0;
        for (int i = 0; i < this.capacity; i++) {
            if (list[i] != null) {
                numberOfElement++;
            }
        }
        return numberOfElement;
    }

    public void add(T data) {
        if (size() >= getCapacity()) {
            increaseCapasity();
        }
        this.list[size()] = data;
    }

    public void increaseCapasity() {
        T[] oldList = this.list;
        T[] newList = (T[]) new Object[getCapacity() * 2];
        for (int i = 0; i < oldList.length; i++) {
            newList[i] = oldList[i];
        }
        setCapacity(getCapacity() * 2);
        setList(newList);
    }

    public T get(int index) {
        if (index >= getCapacity()) {
            return null;
        }
        return this.list[index];
    }

    public T remove(int index) {
        if (index >= getCapacity()) {
            return null;
        }
        //System.out.print("Silinen eleman : " + this.list[index]);
        for (int i = index + 1; i < this.list.length; i++) {
            this.list[i - 1] = this.list[i];
        }

        return this.list[index];
    }

    public T set(int index, T data) {
        if (index >= getCapacity()) {
            return null;
        }
        //System.out.println("Değişen eleman : " + this.list[index] + " => " + data);
        this.list[index] = data;
        return this.list[index];
    }

    public String toString() {
        System.out.print("[");
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] != null) {
                System.out.print(this.list[i]);
                if (i != (size() - 1)) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print("]");
        return "";
    }

    public int indexOf(T data) {
        int indexOfData = -1;
        for (int i = 0; i < this.list.length; i++) {
            if (list[i] == data) {
                indexOfData = i;
                break;
            }
        }
        return indexOfData;
    }

    public int lastIndexOf(T data) {
        int indexOfData = -1;
        for (int i = 0; i < this.list.length; i++) {
            if (list[i] == data) {
                indexOfData = i;
            }
        }
        return indexOfData;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.list.length; i++) {
            if (list[i] != null) {
                return false;
            }
        }
        return true;
    }

    public T[] toArray() {
        T[] array = list;
        return array;
    }

    public void clear() {
        T[] defaultList = (T[]) new Object[10];
        setList(defaultList);
    }

    public MyList<T> subList(int start, int finish) {
        MyList<T> sublist = new MyList<>();
        if (finish - start > getCapacity() - 1){
            for (int i = start; i < getCapacity(); i++) {
                sublist.add(this.list[i]);
            }
        } else {
            for (int i = start; i <= finish; i++) {
                if(i>this.getCapacity()-1){
                    break;
                }
                sublist.add(this.list[i]);
            }
        }
        return sublist;
    }

    public boolean contains(T data) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == data) {
                return true;
            }
        }
        return false;
    }
}

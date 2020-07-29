package lesson.array_list_linked_list.bai_tap.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private E[] data =(E[]) new Object[DEFAULT_CAPACITY];
    public MyList(){}
    public MyList(int capacity){}
    public MyList(E[] object){
        for (int i=0;i<object.length;i++)
            add(i,object[i]);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public void add(int index, E e){
        ensureCapcity();
        for (int i = size-1; i>=index; i++) data[i+1]=data[i];
        data[index]=e;
        size++;
    }

    private void ensureCapcity() {
        if(size>=data.length){
            E[] newData=(E[]) (new Object[size*2+1]);
            System.arraycopy(data,0,newData,0,size);
            data=newData;
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }
    public E remove(int index){
        checkIndex(index);
        E e=data[index];
        for (int j = index; j < size - 1; j++){
            data[j] = data[j + 1];

        data[size - 1] = null;
        size--;}
        return e;
    }
    public boolean contains(E e) {
        for (int i=0;i<size;i++)
            if (e.equals(data[i])) return true;
        return false;
    }
    public int indexof(E e) {
        for (int i=0;i<size;i++)
            if (e.equals(data[i])) return i;
            return -1;
    }
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }
    public void clear() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public E clone(){
        MyList clone= new MyList(size);
        for (int i=0;i<size;i++) {
            clone.add(i,data[i]);
        }
        return (E) clone;
    }
}

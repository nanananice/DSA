package code;

public class MyArray extends MyArrayBasic {
    public MyArray() {
        MAX_SIZE = 100000;
        data = new int[MAX_SIZE];
    }

    public MyArray(int max) {
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] expandByK(int k){
        MAX_SIZE = k * MAX_SIZE;
        int newdata[] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newdata, 0, size);
        data = newdata;
        return newdata;
    }

    public void expand(){
        expandByK(2);
    }

    @Override
    public void add(int d){
        data[size++] = d;
        if(isFull()){
            expand();
        }
    }
}

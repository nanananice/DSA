package code;

import java.util.Arrays;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic(int... a) {
        if (a == null) {

        } else {
            for (int i = 0; i < a.length; i++) {
                if (size < 5) {
                    add(i);
                } else {
                    break;
                }

            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public void add(int d) {
        data[size++] = d;
    }

    public void insert(int d, int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = d;
        size++;
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b = size - 1;
        while (a <= b) {
            int m = (a + b) / 2;
            if (data[m] == d)
                return m;
            if (d < data[m])
                b = m - 1;
            else
                a = m + 1;
        }
        return -1;
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
            size--;
        }
        
    }

}

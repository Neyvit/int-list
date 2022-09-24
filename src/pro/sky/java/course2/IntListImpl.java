package pro.sky.java.course2;

import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.InvalidItemRange;

import java.util.Arrays;

public class IntListImpl implements IntList {
    private static final int DEFAULT_CAPACITY = 20;
    private int size = 0;


    private int[] intArray;

    public IntListImpl(int size) {
        if (size == 100000) {
            intArray = new int[100000];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = (int) Math.round((Math.random() * 4294967295L) - 2147483647);
            }
        } else {
            intArray = new int[size];
        }
    }

    public IntListImpl() {
        intArray = new int[DEFAULT_CAPACITY];
    }

    @Override
    public boolean validateItem(int item) {
        if (item < -2147483648 || 2147483647 < item) {
            throw new InvalidItemRange();
        } else {
            return true;
        }
    }

    @Override
    public boolean validateIndex(int index) {
        if (index < 0 || index >= DEFAULT_CAPACITY - 1) {
            throw new InvalidIndexException();
        } else
            return true;
    }

    @Override
    public int add(int item) {
        if (size == intArray.length) {
            throw new InvalidIndexException();
        } else if (validateItem(item) == true) {
            intArray[size++] = item;
            return item;
        } else {
            throw new InvalidItemRange();
        }
    }

    @Override
    public int add(int index, int item) {
        if (validateItem(item) == true && validateIndex(index) == true) {
            for (int i = size; i >= index; i--) {
                intArray[i + 1] = intArray[i];
            }
            intArray[index] = item;
            size++;
        }
        return item;
    }

    @Override
    public int set(int index, int item) {
        if (validateIndex(index) == true && validateItem(item) == true) {
            intArray[index] = item;
        }
        return item;
    }

    @Override
    public int removeItem(int item) {
        if (validateItem(item) == true) {
            remove(indexOf(item));
        }
        return item;
    }

    @Override
    public int remove(int index) {
        int temp = 0;
        if (validateIndex(index)) {
            temp = intArray[index];
            System.arraycopy(intArray, index + 1, intArray, index, size - index);
            size--;
        }
        return temp;
    }

    @Override
    public boolean contains(int item) {
        int[] arr = toArray();
        sort(arr);
        return binarySearch(arr, item);
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (item == intArray[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = size; i >= 0; i--) {
            if (item == intArray[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        if (validateIndex(index) == true) {
            return intArray[index];
        } else {
            throw new InvalidIndexException();
        }
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null) {
            throw new NegativeArraySizeException();
        }
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (Arrays.equals(this.toArray(), otherList.toArray())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        intArray = new int[size = 0];
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(intArray, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(intArray);
    }

    private void swapElements(int[] intArray, int indexA, int indexB) {
        int tmp = intArray[indexA];
        intArray[indexA] = intArray[indexB];
        intArray[indexB] = tmp;
    }

    private void sort(int[] intArray) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    swapElements(intArray, j, j + 1);
                }
            }
        }
    }

    private boolean binarySearch(int[] intArray, int element) {
        int min = 0;
        int max = intArray.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == intArray[mid]) {
                return true;
            }

            if (element < intArray[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
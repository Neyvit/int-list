package pro.sky.java.course2;

import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.InvalidItemRange;

import java.util.Arrays;

public class IntListImpl implements IntList {
    private static final int DEFAULT_CAPACITY = 20;
    private int size = 0;


    private int[] intArray;

    public IntListImpl(int size) {
            intArray = new int[size];
    }

    public IntListImpl() {
        intArray = new int[DEFAULT_CAPACITY];
    }

    @Override
    public boolean validateItem(int item) {
        if (item > -2147483648 && 2147483647 > item) {
            return true;
        } else {
            throw new InvalidItemRange();
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
        if (size < intArray.length && validateItem(item)) {
            intArray[size] = item;
            size++;
        } else if (size == intArray.length && validateItem(item)) {
            grow();
            intArray[size] = item;
            size++;
        } else {
            throw new InvalidItemRange();
        }
        return item;
    }

    @Override
    public int add(int index, int item) {
        if (size == intArray.length && validateItem(item)) {
            grow();
            System.arraycopy(intArray, index, intArray, index + 1, size - index);
            intArray[index] = item;
            size++;
            return item;
        } else if (validateItem(item) == true && size < intArray.length && size >= 0) {
            System.arraycopy(intArray, index, intArray, index + 1, size - index);
            intArray[index] = item;
            size++;
            return item;
        } else {
            throw new InvalidItemRange();
        }
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
            if (size < intArray.length / 2) {
                temp = intArray[index];
                System.arraycopy(intArray, index + 1, intArray, index, size - index);
                size--;
                resize();
            } else {
                temp = intArray[index];
                System.arraycopy(intArray, index + 1, intArray, index, size - index);
                size--;
            }
        }
        return temp;
    }

    @Override
    public boolean contains(int item) {
        int[] arr = intArray.clone();
        quickSort(arr,0,size -1);
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
        return size == 0;
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

    private void swapElements(int[] intArray, int left, int right) {
        int tmp = intArray[left];
        intArray[left] = intArray[right];
        intArray[right] = tmp;
    }

    private int partition(int[] intArray, int begin, int end) {
        int pivot = intArray[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (intArray[j] <= pivot) {
                i++;

                swapElements(intArray, i, j);
            }
        }

        swapElements(intArray, i + 1, end);
        return i + 1;
    }

    private void quickSort(int[] intArray, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(intArray, begin, end);

            quickSort(intArray, begin, partitionIndex - 1);
            quickSort(intArray, partitionIndex + 1, end);
        }
    }

    private boolean binarySearch(int[] intArray, int element) {
        int min = 0;
        int max = size - 1;

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

    private void grow() {
        int[] newArray = new int[intArray.length + intArray.length / 2];
        System.arraycopy(intArray, 0, newArray, 0, size);
        intArray = newArray;
    }

    private void resize() {
        int[] newArray = new int[intArray.length - intArray.length / 3];
        System.arraycopy(intArray, 0, newArray, 0, size);
        intArray = newArray;
    }
}
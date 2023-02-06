package pro.sky.java.course2;

public class Main {
    public static void main(String[] args) {
        IntList intArray = new IntListImpl();
        System.out.println(intArray.add(245));
        System.out.println(intArray.add(228));
        System.out.println(intArray.add(1945));
        System.out.println(intArray.add(1812));
        System.out.println(intArray.add(1941));
        System.out.println(intArray.add(1488));
        intArray.toArray();
        System.out.println(intArray.toString());
        System.out.println(intArray.add(5, 3));
        System.out.println(intArray.toString());
        System.out.println(intArray.set(5, 33));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.add(9562876));
        System.out.println(intArray.toString());
        System.out.println(intArray.removeItem(9562876));
        System.out.println(intArray.toString());
        System.out.println(intArray.contains(1945));
        System.out.println(intArray.toString());
        System.out.println(intArray.indexOf(1488));
        System.out.println(intArray.lastIndexOf(228));
        System.out.println(intArray.get(3));
        System.out.println(intArray.add(1));
        System.out.println(intArray.add(2));
        System.out.println(intArray.add(3));
        System.out.println(intArray.add(4));
        System.out.println(intArray.add(5));
        System.out.println(intArray.add(6));
        System.out.println(intArray.add(7));
        System.out.println(intArray.add(8));
        System.out.println(intArray.add(9));
        System.out.println(intArray.add(10));
        System.out.println(intArray.add(11));
        System.out.println(intArray.add(12));
        System.out.println(intArray.add(13));
        System.out.println(intArray.add(14));
        System.out.println(intArray.toString());
        System.out.println(intArray.add(15));
        System.out.println(intArray.toString());
        System.out.println(intArray.add(8, 55));
        System.out.println(intArray.toString());
        System.out.println(intArray.contains(228));
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());
        System.out.println(intArray.remove(5));
        System.out.println(intArray.toString());


        int[] arr = generateRandomArray();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();
        int[] arr4 = arr.clone();
        int[] arr5 = arr.clone();

        long start = System.currentTimeMillis();
        sortBubble(arr);
        System.out.println("BubbleSortTime " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.println("SortSelectionTime " + (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println("SortInsertionTime " + (System.currentTimeMillis() - start3));

        long start4 = System.currentTimeMillis();
        quickSort(arr4, 0,arr4.length - 1);
        System.out.println("QuickSortTime " + (System.currentTimeMillis() - start4));

        long start5 = System.currentTimeMillis();
        mergeSort(arr5);
        System.out.println("MergeSortTime " + (System.currentTimeMillis() - start5));
    }

    public static int[] generateRandomArray() {
        int[] intArray = new int[100000];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) Math.round((Math.random() * 4294967295L) - 2147483647);
        }
        return intArray;
    }

    private static void swapElements(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}

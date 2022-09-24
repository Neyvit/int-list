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

        int[] arr = generateRandomArray();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();

        long start = System.currentTimeMillis();
        sortBubble(arr);
        System.out.println("BubbleSortTime " + (System.currentTimeMillis() - start));

        long start2 = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.println("SortSelectionTime " + (System.currentTimeMillis() - start));

        long start3 = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println("SortInsertionTime " + (System.currentTimeMillis() - start));
    }

    public static int[] generateRandomArray() {
        int[] intArray = new int[100000];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) Math.round((Math.random() * 4294967295L) - 2147483647);
        }
        return intArray;
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
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
}

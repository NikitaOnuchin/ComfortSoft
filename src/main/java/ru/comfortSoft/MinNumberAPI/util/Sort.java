package ru.comfortSoft.MinNumberAPI.util;

public class Sort {
    public static void quickSort(Long[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Long[] array, int from, int to) {
        if (from < to) {
            int partitionIndex = partition(array, from, to);
            quickSort(array, from, partitionIndex - 1);
            quickSort(array, partitionIndex, to);
        }
    }

    private static int partition(Long[] array, int from, int to) {
        long pivot = array[from + (to - from) / 2];
        int leftIndex = from;
        int rightIndex = to;

        while (leftIndex <= rightIndex) {
            while (leftIndex <= to && array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (rightIndex >= from && array[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(Long[] array, int i, int j) {
        Long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
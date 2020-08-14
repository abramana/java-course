package com.quick.sort;

public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high){
        if (low < high){
           int pi = partitioning(array, low, high);
           quickSort(array, low, pi - 1);
           quickSort(array, pi + 1, high);
       }
    }

    private static <T extends Comparable<T>> int partitioning(T[] array, int low, int high){
        int wall = low;
        for (int i = low; i < high; i++){
            if (!isGreaterThen(array[i], array[high])){
                swap(array, wall, i);
                wall++;
            }
        }
        swap(array, wall, high);
        return wall;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int idx1, int idx2) {
        T copy = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = copy;
    }

    private static <T extends Comparable<T>> boolean isGreaterThen(T object1, T object2){
        return object1.compareTo(object2) > 0;
    }

}

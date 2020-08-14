package com.merge.sort;

import java.util.Arrays;

public class MergeSort {
    private static <T extends Comparable<T>> void sort(T[] array, T[] leftArray, T[] rightArray, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right){
            if (isGreaterThan(leftArray[i], rightArray[j])){
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left){
            array[k++] = leftArray[i++];
        }
        while (j < right){
            array[k++] = rightArray[j++];
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, int length) {
        if (length < 2){
            return;
        }
        int middle = length / 2;

        T[] leftArray = Arrays.copyOfRange(array, 0, middle);
        T[] rightArray = Arrays.copyOfRange(array, middle, length);

        merge(leftArray, middle);
        merge(rightArray, length - middle);
        sort(array, leftArray, rightArray, middle, length - middle);

    }

    private static <T extends Comparable<T>> boolean isGreaterThan(T object1, T object2){
        return object1.compareTo(object2) < 0;
    }
}

package com.comb.sort;

public class CombSort {
    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                int distance = array.length - 1 - i;
                if (j + distance < array.length){
                    if (isGreaterThan(array[j], array[j + distance])){
                        swap(j, j + distance, array);
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable<T>> boolean isGreaterThan(T object1, T object2){
        return object1.compareTo(object2) > 0;
    }

    public static <T extends Comparable<T>> void swap(int indexObject1, int indexObject2, T[] array){
        T newObject = array[indexObject1];
        array[indexObject1] = array[indexObject2];
        array[indexObject2] = newObject;
    }
}

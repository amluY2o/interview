package com.jcj.interview.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5,3,6,9,2,1,4,8,7};
        print(arr);
        selectSort(arr);
        print(arr);
    }

    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++){
            int minValueIndex = i;
            for (int j = i +1; j < N; j++){
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr){
        for (int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
    }

}

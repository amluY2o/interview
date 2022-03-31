package com.jcj.interview.collection;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] list = {3, 8, 1, 5, 7, 4, 1};
        findBalanceNumbers(list).forEach(System.out::println);




    }

    public static List<Integer> findBalanceNumbers(int[] list){
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            int lSum = 0,rSum = 0;
            for(int j = 0; j < i; j++){
                lSum += list[j];
            }
            for(int j = i + 1; j < list.length; j++){
                rSum += list[j];
            }
            if(lSum == rSum){
                results.add(list[i]);
            }
        }
        return results;
    }
}

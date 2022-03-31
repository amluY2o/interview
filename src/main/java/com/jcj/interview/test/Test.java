package com.jcj.interview.test;

import cn.hutool.core.net.NetUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        //System.out.println(NetUtil.ipv4ToLong("192.168.1.1"));

        //System.out.println(getIndex(100));

        // 两数之和
        //System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 13)));

        Stack<Integer> s1 = new Stack<>();
        s1.empty();
        char[] chars = String.valueOf(1).toCharArray();

    }

    /**
     * 两数之和
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)){
                Integer index = map.get(key);
                return new int[]{index, i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two sum");
    }

    /**
     * 给定一个m，求大于该数的最小二次幂n，并返回n
     * @param m
     * @return
     */
    private static int getIndex(int m) {
        int i = 1;
        while (true){
            if((2 << i) > m){
                return i;
            }
            i++;
        }
    }

    /**
     * 给定一个链表，删除相邻的重复项，比如，2->2->3,返回2->3
     */


}

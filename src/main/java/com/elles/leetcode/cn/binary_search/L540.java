package com.elles.leetcode.cn.binary_search;

import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class L540 {


    @Test
    public void testOk() {

        int [] a=new int[]{1,1,2,3,3,4,4,5,5};
        String [] temp=new String []{"c", "f", "j"};

        System.out.println(singleNonDuplicate(a));

    }

    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];


    }

}
package com.elles.leetcode;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 找出满足 target值的数组下标
 */
public class L001 {

    @Test
    public void testOk(){
        int target=17;
        int[] nums=new int[] {2,7,11,15};

        int [] result=process(nums,target);
        for(int j=0;j<result.length;j++){
            System.out.println(result[j]);
        }

    }
    private int[]  process(int [] array,int target){
        int lenth=array.length;
        Map<Integer,Integer> tempMap=new HashMap<>();
        for(int i=0;i<lenth;i++){
            Integer value=tempMap.get(array[i]);
            if(value!=null){
                return new int[]{value,i};
            }
            tempMap.put(target-array[i],i);

        }

        return new int[]{-1,-1};
    }
}

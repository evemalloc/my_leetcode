package com.elles.leetcode.cn;

import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class L122 {

    @Test
    public void testOk() {
        int[] [] tempArray=new int[][]{{1,2}, {2,3}, {3,4}, {1,3} };
        int[] [] tempArray2=new int[][]{{1,2}, {1,2},{1,3} };
        int [] a=new int[]{11,1,1,2,2,2,33,3,3,3,3,3,1,1,1,1,4,4};


        System.out.println(temp(a));

    }



    public Object temp(int [] temp){
        if(temp==null||temp.length<2){
            return 0;
        }
        int profit=0;
        for(int i=1;i<temp.length;i++){
            int tempInt=temp[i]-temp[i-1];
            if(tempInt>0){
                profit=profit+tempInt;
            }
        }

        return  profit;
    }

}
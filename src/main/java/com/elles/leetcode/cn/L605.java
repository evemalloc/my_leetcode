package com.elles.leetcode.cn;

import org.testng.annotations.Test;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

 示例 1:

 输入: flowerbed = [1,0,0,0,1], n = 1
 输出: True
 示例 2:

 输入: flowerbed = [1,0,0,0,1], n = 2
 输出: False
 注意:

 数组内已种好的花不会违反种植规则。
 输入的数组长度范围为 [1, 20000]。
 n 是非负整数，且不会超过输入数组的大小。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/can-place-flowers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L605 {

    @Test
    public void testOk() {
        int[] [] tempArray=new int[][]{{1,2}, {2,3}, {3,4}, {1,3} };
        int[] [] tempArray2=new int[][]{{1,2}, {1,2},{1,3} };
        int [] a=new int[]{11,1,1,2,2,2,33,3,3,3,3,3,1,1,1,1,4,4};


        System.out.println(canPlaceFlowers(a,3));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed==null||flowerbed.length==0){
            return  false;
        }

        int cnt=0;
        for(int i=0;i<flowerbed.length-1;i++){
            if(1==flowerbed[i]){
                continue;
            }
            int pre=i==0?0:flowerbed[i-1];
            int next=i==flowerbed.length-1?0:flowerbed[i+1];
            if(pre==0&&next==0){
                cnt++;
                flowerbed[i]=1;
            }
        }

        return  cnt>=n;
    }
}
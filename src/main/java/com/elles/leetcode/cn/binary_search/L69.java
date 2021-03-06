package com.elles.leetcode.cn.binary_search;

import org.testng.annotations.Test;

/**
 * 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sqrtx
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L69 {

    @Test
    public void testOk() {

        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(2147395599));


    }

    public int mySqrt(int x) {

        if(x<=1){
            return  x;
        }

        int l=1;
        int h=x;
        int mid=0;
        while (l<=h){
            mid=l+(h-l)/2;
            //x=2  r1:  l=0 h=2 mid=1;
            //r2:l=2:h=2 mid=2;
            //r3:l=2: h=1, break;
            long temp=(long)mid*mid;
            if(temp==x){
                return  mid;
            }else if(temp<x){
                l=mid+1;
            }else {
                h=mid-1;
            }
        }


        return h;
    }
}
package com.elles.leetcode;

import org.testng.annotations.Test;

/***
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output:  321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 *
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *输入一串数字，然后反序输出
 */
public class L007 {


    @Test
    public  void testOk(){
        int input =Integer.MAX_VALUE+123;

        long output =0;
        int inputTemp=new Integer(input);
        for(;inputTemp!=0;inputTemp=inputTemp/10){

            output=output*10+inputTemp%10;
        }
        output=output > Integer.MAX_VALUE || output < Integer.MIN_VALUE ? 0 : (int) output;

        System.out.println(input);
        System.out.println(output);
    }
}

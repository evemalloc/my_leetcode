package com.elles.leetcode.cn;

import org.testng.annotations.Test;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

  

 示例 1:

 输入: nums = [4,2,3]
 输出: true
 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 示例 2:

 输入: nums = [4,2,1]
 输出: false
 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/non-decreasing-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L665 {

    @Test
    public void testOk() {

        int [] a=new int[]{11,1,1,2,2,2,33,3,3,3,3,3,1,1,1,1,4,4};

        int [] a1=new int[]{1,2,3,4,6,5};
        int [] a2=new int[]{4,2,3};

        System.out.println(temp(a));
        System.out.println(temp(a1));
        System.out.println(temp(a2));

    }


    public boolean temp(int [] temp){
        if(null==temp||temp.length==0){
            return true;
        }
        int cnt=0;
        for(int i=1;i<temp.length&&cnt<2;i++){

            if(temp[i]>=temp[i-1]){
                continue;
            }
            cnt++;
            if(i-2>=0&&temp[i-2]>temp[i]){
                temp[i]=temp[i-1];
            }else {
                temp[i-1]=temp[i];
            }
        }

        return  cnt<=1;
    }

}
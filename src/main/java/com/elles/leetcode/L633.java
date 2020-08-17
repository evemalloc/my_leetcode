package com.elles.leetcode;

/**
 * 是否是两数的平方和
 */
public class L633 {

    public boolean judgeSquareSum(int c) {
        int left=0;
        int right=(int)Math.sqrt(c);//TODO 这里需要注意类型转换
        while(left<=right){//TODO 这里要注意 =号，target=2 的时候
            int temp=left*left+right*right;
            if(temp==c){
                return true;
            }else if(temp<c){
                left++;
            }else{
                right--;
            }
        }

        return false;

    }
}

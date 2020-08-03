package com.elles.leetcode;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class L680 {

    @Test
    public void testOk(){

        System.out.println(validPalindrome("cbbcc"));
    }

    public boolean validPalindrome(String s) {

        for(int left=0,right=s.length()-1;left<right;left++,right--){
            if(s.charAt(left)!=s.charAt(right)){
                return isPalidrome(s,left+1,right)||isPalidrome(s,left,right-1);
            }
        }
        return true;
    }

    private boolean isPalidrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}

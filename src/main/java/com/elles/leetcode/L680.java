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

//        System.out.println(validPalindrome("cbbcc"));
        System.out.println(validPalindrome2("abc"));

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


    public boolean validPalindrome2(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            if(leftChar==rightChar){
                left++;
                right--;
            }else {
                String subStringLeft=s.substring(left,right);//TODO 这里需要特别注意substring的用法 例如："abc".substring(0,2)=ab,
                // "abc".substring(1,3)=bc;
                String subStringRight=s.substring(left+1,right+1);
                return validPalindromeSub(subStringLeft)||validPalindromeSub(subStringRight);
            }
        }

        return true;

    }

    private boolean validPalindromeSub(String s){
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            if(leftChar!=rightChar){
                return false;
            }
            left++;
            right--;

        }

        return true;
    }


}

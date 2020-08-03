package com.elles.leetcode;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class L002 {

    @Test
    public void  testOk(){
//            System.out.println(lengthOfLongestSubstring("abcba"));

//        System.out.println(lengthOfLongestSubstring2("abcba"));

        System.out.println(lengthOfLongestSubstring2("aabaab!bb"));


    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        List<Character> substring = new ArrayList<>();
        int max = 0;
        for(int i=0; i<s.length(); i++){
            System.out.println(s.charAt((i)));
            if (substring.contains(s.charAt(i))){

                int temp=substring.indexOf(s.charAt(i))+1;

                substring.subList(0,temp).clear();
            }
            substring.add(s.charAt(i));
            if(max < substring.size())
                max = substring.size();
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        List<Character> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                if (max < list.size()) {
                    max = list.size();
                }

            } else {

                list = list.subList(list.indexOf(s.charAt(i))+1, list.size());
                list.add(s.charAt(i));
                System.out.println(JSON.toJSON(list));
            }
        }

        return max;
    }
}
